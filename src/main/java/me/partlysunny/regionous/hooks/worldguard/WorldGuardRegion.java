package me.partlysunny.regionous.hooks.worldguard;

import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import me.partlysunny.regionous.api.AbstractXYZ;
import org.bukkit.Location;
import org.bukkit.World;

public class WorldGuardRegion extends AbstractXYZ {

    private final ProtectedRegion region;
    private final World world;

    public WorldGuardRegion(String identifier, ProtectedRegion region, World world) {
        super(identifier);
        this.region = region;
        this.world = world;
    }

    @Override
    public boolean isLocationInside(Location location) {
        return region.contains(location.getBlockX(), location.getBlockY(), location.getBlockZ());
    }

    @Override
    public Location getLocation() {
        BlockVector3 minPoint = region.getMinimumPoint();
        return new Location(null, minPoint.getX(), minPoint.getY(), minPoint.getZ());
    }

    public String getId() {
        return region.getId();
    }

    public World getWorld() {
        return world;
    }
}
