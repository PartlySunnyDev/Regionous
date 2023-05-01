package me.partlysunny.regionous.api;

import me.partlysunny.regionous.util.Vector2;
import org.bukkit.Location;

public abstract class RadialRectRegion implements XZRegion {

    private final Vector2 radii;

    protected RadialRectRegion(Vector2 radii) {
        this.radii = radii;
    }

    @Override
    public boolean isLocationInside(Location location) {
        return Math.abs(location.getX() - getLocation().getA()) <= radii.getA() && Math.abs(location.getZ() - getLocation().getB()) <= radii.getB();
    }
}
