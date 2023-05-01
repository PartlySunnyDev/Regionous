package me.partlysunny.regionous.api;

import org.bukkit.Location;

public abstract class SphereRegion implements XYZRegion {

    private final float radius;

    public SphereRegion(float radius) {
        this.radius = radius;
    }

    @Override
    public boolean isLocationInside(Location location) {
        return location.distanceSquared(getLocation()) <= (radius * radius);
    }
}
