package me.partlysunny.regionous.hooks.worldedit;

import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.regions.Region;
import me.partlysunny.regionous.api.XYZRegion;
import org.bukkit.Location;

public class WorldEditRegion implements XYZRegion {

    private final Region worldEditRegion;

    public WorldEditRegion(Region worldEditRegion) {
        this.worldEditRegion = worldEditRegion;
    }

    @Override
    public boolean isLocationInside(Location location) {
        return worldEditRegion.contains(BlockVector3.at(location.getX(), location.getY(), location.getZ()));
    }

    @Override
    public Location getLocation() {
        BlockVector3 minimumPoint = worldEditRegion.getMinimumPoint();
        return new Location(null, minimumPoint.getX(), minimumPoint.getY(), minimumPoint.getZ());
    }
}
