package me.partlysunny.regionous.hooks.worldguard;

import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import me.partlysunny.regionous.api.AbstractXYZ;
import org.bukkit.Location;

public class WorldGuardRegion extends AbstractXYZ {

    private final ProtectedRegion region;

    public WorldGuardRegion(String identifier, ProtectedRegion region) {
        super(identifier);
        this.region = region;
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
}
