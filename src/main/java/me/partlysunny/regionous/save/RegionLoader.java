package me.partlysunny.regionous.save;

import me.partlysunny.regionous.Regionous;
import me.partlysunny.regionous.api.*;
import me.partlysunny.regionous.entity.*;
import me.partlysunny.regionous.handler.RegionManager;
import me.partlysunny.regionous.hooks.worldedit.WorldEditRegion;
import me.partlysunny.regionous.hooks.worldguard.WorldGuardRegion;
import me.partlysunny.regionous.statics.StaticCircleRegion;
import me.partlysunny.regionous.statics.StaticRadialRectRegion;
import me.partlysunny.regionous.statics.StaticRectRegion;
import me.partlysunny.regionous.statics.StaticSphereRegion;
import me.partlysunny.regionous.util.RegionType;
import me.partlysunny.regionous.util.Vector2;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RegionLoader {

    private final JavaPlugin plugin;
    private final RegionManager regionManager;

    public RegionLoader(JavaPlugin plugin, RegionManager regionManager) {
        this.plugin = plugin;
        this.regionManager = regionManager;
        loadRegions();
    }

    public void loadRegions() {
        File regionFolder = new File(plugin.getDataFolder(), "regions");
        if (!regionFolder.exists()) {
            regionFolder.mkdir();
        }
        File[] regionFiles = regionFolder.listFiles();
        if (regionFiles == null) {
            return;
        }
        for (File regionFile : regionFiles) {
            try {
                InputStream inputStream = new FileInputStream(regionFile);
                Region region = loadRegion(inputStream);
                regionManager.register(region);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void saveRegions() {
        File regionFolder = new File(plugin.getDataFolder(), "regions");
        if (regionFolder.exists()) {
            for (File file : regionFolder.listFiles()) {
                file.delete();
            }
            regionFolder.delete();
        }
        regionFolder.mkdir();
        for (Region region : regionManager.stream().toList()) {
            try {
                File regionFile = new File(regionFolder, region.identifier() + ".region");
                if (!regionFile.exists()) {
                    regionFile.createNewFile();
                }
                OutputStream outputStream = new FileOutputStream(regionFile);
                saveRegion(region, outputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void saveRegion(Region region, OutputStream outputStream) throws IOException {
        RegionType regionType = RegionType.typeof(region);
        String identifier = region.identifier();
        //Write the type of the region (enum ordinal)
        outputStream.write(ByteBuffer.allocate(4).putInt(regionType.ordinal()).array());
        //Write the size of the identifier
        outputStream.write(ByteBuffer.allocate(4).putInt(identifier.getBytes().length).array());
        //Then write the identifier
        outputStream.write(identifier.getBytes());
        //For entity regions, write the entity id
        if (regionType.isEntity()) {
            EntityBinder entityRegion = (EntityBinder) region;
            UUID uuid = entityRegion.getEntity().getUniqueId();
            outputStream.write(ByteBuffer.allocate(16).putLong(uuid.getLeastSignificantBits()).putLong(uuid.getMostSignificantBits()).array());
        } else if (regionType.isStatic()) {
            //Write the location
            if (regionType.is3d()) {
                Location location = ((XYZRegion) region).getLocation();
                outputStream.write(ByteBuffer.allocate(8).putDouble(location.getX()).array());
                outputStream.write(ByteBuffer.allocate(8).putDouble(location.getZ()).array());
                outputStream.write(ByteBuffer.allocate(8).putDouble(location.getY()).array());
            } else {
                Vector2 location = ((XZRegion) region).getLocation();
                outputStream.write(ByteBuffer.allocate(8).putDouble(location.getA()).array());
                outputStream.write(ByteBuffer.allocate(8).putDouble(location.getB()).array());
            }
        }
        //Then write the region
        switch (regionType) {
            case STATIC_RECTANGLE, ENTITY_RECTANGLE -> {
                RectRegion rectRegion = (RectRegion) region;
                //Write the width, height
                outputStream.write(ByteBuffer.allocate(8).putDouble(rectRegion.getSize().getA()).array());
                outputStream.write(ByteBuffer.allocate(8).putDouble(rectRegion.getSize().getB()).array());
            }
            case STATIC_CIRCLE, ENTITY_CIRCLE -> {
                CircleRegion circleRegion = (CircleRegion) region;
                //Write the radius
                outputStream.write(ByteBuffer.allocate(8).putDouble(circleRegion.getRadius()).array());
            }
            case STATIC_RADIAL_RECT, ENTITY_RADIAL_RECT -> {
                RadialRectRegion radialRectRegion = (RadialRectRegion) region;
                //Write the radii
                outputStream.write(ByteBuffer.allocate(8).putDouble(radialRectRegion.getRadii().getA()).array());
                outputStream.write(ByteBuffer.allocate(8).putDouble(radialRectRegion.getRadii().getB()).array());
            }
            case STATIC_SPHERE, ENTITY_SPHERE -> {
                SphereRegion sphereRegion = (SphereRegion) region;
                //Write the radius
                outputStream.write(ByteBuffer.allocate(8).putDouble(sphereRegion.getRadius()).array());
            }
            case WORLD_EDIT -> {
                WorldEditRegion worldEditRegion = (WorldEditRegion) region;
                //Write the world uuid
                outputStream.write(ByteBuffer.allocate(16).putLong(worldEditRegion.getWorld().getUID().getLeastSignificantBits()).putLong(worldEditRegion.getWorld().getUID().getMostSignificantBits()).array());
                //Write the number of blocks
                outputStream.write(ByteBuffer.allocate(8).putLong(worldEditRegion.size()).array());
                //Write the blocks
                worldEditRegion.iterator().forEachRemaining(block -> {
                    try {
                        outputStream.write(ByteBuffer.allocate(8).putDouble(block.getX()).array());
                        outputStream.write(ByteBuffer.allocate(8).putDouble(block.getZ()).array());
                        outputStream.write(ByteBuffer.allocate(8).putDouble(block.getY()).array());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
            case WORLD_GUARD -> {
                WorldGuardRegion worldGuardRegion = (WorldGuardRegion) region;
                //Write the world guard id length
                outputStream.write(ByteBuffer.allocate(4).putInt(worldGuardRegion.getId().getBytes().length).array());
                //Write the world guard id
                outputStream.write(worldGuardRegion.getId().getBytes());
                //Write the world uuid
                outputStream.write(ByteBuffer.allocate(16).putLong(worldGuardRegion.getWorld().getUID().getLeastSignificantBits()).putLong(worldGuardRegion.getWorld().getUID().getMostSignificantBits()).array());
            }
        }
    }

    /**
     * Loads the region from the input stream
     * HEADER
     * byte_size | purpose
     * 4         | region type (ordinal of RegionType)
     * 4         | identifier length
     * x         | identifier
     * FOR ENTITY REGIONS
     * 16        | entity uuid
     * FOR POSITIONAL REGIONS
     * 4         | x
     * 4         | z
     * 4         | y (only for 3D regions)
     * PROPERTIES
     *
     * @param stream The input stream
     * @return The region
     * @throws IOException If an error occurs
     */
    public Region loadRegion(InputStream stream) throws IOException {
        //Header (region type, identifier length, identifier)
        RegionType regionType = RegionType.values()[ByteBuffer.wrap(stream.readNBytes(4)).getInt()];
        if (regionType == null) {
            throw new IOException("Invalid region type");
        }
        int identifierLength = ByteBuffer.wrap(stream.readNBytes(4)).getInt();
        String identifier = new String(stream.readNBytes(identifierLength));
        //Properties
        if (regionType.isEntity()) {
            //Entity UUID
            UUID uuid = new UUID(ByteBuffer.wrap(stream.readNBytes(8)).getLong(), ByteBuffer.wrap(stream.readNBytes(8)).getLong());
            final Entity entity = Bukkit.getEntity(uuid);
            //Entity region properties
            switch (regionType) {
                case ENTITY_RECTANGLE -> {
                    double width = ByteBuffer.wrap(stream.readNBytes(8)).getDouble();
                    double height = ByteBuffer.wrap(stream.readNBytes(8)).getDouble();
                    return new EntityRectRegion(identifier, new Vector2(width, height), entity);
                }
                case ENTITY_CIRCLE -> {
                    double radius = ByteBuffer.wrap(stream.readNBytes(8)).getDouble();
                    return new EntityCircleRegion(identifier, radius, entity);
                }
                case ENTITY_RADIAL_RECT -> {
                    double radiusX = ByteBuffer.wrap(stream.readNBytes(8)).getDouble();
                    double radiusY = ByteBuffer.wrap(stream.readNBytes(8)).getDouble();
                    return new EntityRadialRectRegion(identifier, new Vector2(radiusX, radiusY), entity);
                }
                case ENTITY_SPHERE -> {
                    double radius = ByteBuffer.wrap(stream.readNBytes(8)).getDouble();
                    return new EntitySphereRegion(identifier, radius, entity);
                }
            }
        } else if (regionType.isWorldEdit()) {
            // Read the world uuid
            UUID worldUuid = new UUID(ByteBuffer.wrap(stream.readNBytes(8)).getLong(), ByteBuffer.wrap(stream.readNBytes(8)).getLong());
            World world = Bukkit.getWorld(worldUuid);
            // Read how many blocks are in the region
            long blockCount = ByteBuffer.wrap(stream.readNBytes(8)).getLong();
            List<Location> locations = new ArrayList<>();
            for (long i = 0; i < blockCount; i++) {
                // Read the block location
                double x = ByteBuffer.wrap(stream.readNBytes(8)).getDouble();
                double y = ByteBuffer.wrap(stream.readNBytes(8)).getDouble();
                double z = ByteBuffer.wrap(stream.readNBytes(8)).getDouble();
                locations.add(new Location(world, x, y, z));
            }
            return Regionous.getInstance().getWorldEditHook().getFromLocationList(identifier, locations);
        } else if (regionType.isWorldGuard()) {
            int worldGuardRegionIdLength = ByteBuffer.wrap(stream.readNBytes(4)).getInt();
            String worldGuardRegionId = new String(stream.readNBytes(worldGuardRegionIdLength));
            UUID worldName = new UUID(ByteBuffer.wrap(stream.readNBytes(8)).getLong(), ByteBuffer.wrap(stream.readNBytes(8)).getLong());
            return Regionous.getInstance().getWorldGuardHook().getWorldGuardRegion(Bukkit.getWorld(worldName), worldGuardRegionId);
        } else {
            //Positional region properties
            double x = ByteBuffer.wrap(stream.readNBytes(8)).getDouble();
            double z = ByteBuffer.wrap(stream.readNBytes(8)).getDouble();
            double y = 0;
            if (regionType.is3d()) y = ByteBuffer.wrap(stream.readNBytes(8)).getDouble();
            switch (regionType) {
                case STATIC_RECTANGLE -> {
                    double width = ByteBuffer.wrap(stream.readNBytes(8)).getDouble();
                    double height = ByteBuffer.wrap(stream.readNBytes(8)).getDouble();
                    return new StaticRectRegion(identifier, new Vector2(x, z), new Vector2(width, height));
                }
                case STATIC_CIRCLE -> {
                    double radius = ByteBuffer.wrap(stream.readNBytes(8)).getDouble();
                    return new StaticCircleRegion(identifier, radius, new Vector2(x, y));
                }
                case STATIC_RADIAL_RECT -> {
                    double radiusX = ByteBuffer.wrap(stream.readNBytes(8)).getDouble();
                    double radiusY = ByteBuffer.wrap(stream.readNBytes(8)).getDouble();
                    return new StaticRadialRectRegion(identifier, new Vector2(x, y), new Vector2(radiusX, radiusY));
                }
                case STATIC_SPHERE -> {
                    double radius = ByteBuffer.wrap(stream.readNBytes(8)).getDouble();
                    return new StaticSphereRegion(identifier, radius, new Location(null, x, y, z));
                }
            }
        }
        return null;
    }
}
