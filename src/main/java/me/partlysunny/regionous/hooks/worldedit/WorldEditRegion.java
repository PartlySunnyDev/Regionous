package me.partlysunny.regionous.hooks.worldedit;

import com.sk89q.worldedit.bukkit.BukkitWorld;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.regions.Region;
import me.partlysunny.regionous.api.AbstractXYZ;
import org.bukkit.Location;
import org.bukkit.World;

import java.util.Iterator;

public class WorldEditRegion extends AbstractXYZ {

    private final Region worldEditRegion;

    public WorldEditRegion(String identifier, Region worldEditRegion) {
        super(identifier);
        this.worldEditRegion = worldEditRegion;
    }

    @Override
    public boolean isLocationInside(Location location) {
        return worldEditRegion.contains(BlockVector3.at(location.getX(), location.getY(), location.getZ()));
    }

    @Override
    public Location getLocation() {
        BlockVector3 minimumPoint = worldEditRegion.getMinimumPoint();
        return new Location(getWorld(), minimumPoint.getX(), minimumPoint.getY(), minimumPoint.getZ());
    }

    public Iterator<Location> iterator() {
        return new Iterator<>() {
            private final Iterator<BlockVector3> iterator = worldEditRegion.iterator();

            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Location next() {
                BlockVector3 next = iterator.next();
                return new Location(getWorld(), next.getX(), next.getY(), next.getZ());
            }
        };
    }

    public World getWorld() {
        return ((BukkitWorld) worldEditRegion.getWorld()).getWorld();
    }

    public long size() {
        return worldEditRegion.getVolume();
    }
}
