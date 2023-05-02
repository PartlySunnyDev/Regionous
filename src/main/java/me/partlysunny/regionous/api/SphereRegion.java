package me.partlysunny.regionous.api;

import org.bukkit.Location;

public abstract class SphereRegion extends AbstractXYZ {

    private final float radius;

    public SphereRegion(String identifier, float radius) {
        super(identifier);
        this.radius = radius;
    }

    @Override
    public boolean isLocationInside(Location location) {
        return location.distanceSquared(getLocation()) <= (radius * radius);
    }
}
