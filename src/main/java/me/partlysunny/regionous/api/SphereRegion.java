package me.partlysunny.regionous.api;

import org.bukkit.Location;

public abstract class SphereRegion extends AbstractXYZ {

    private final double radius;

    public SphereRegion(String identifier, double radius) {
        super(identifier);
        this.radius = radius;
    }

    @Override
    public boolean isLocationInside(Location location) {
        return location.distanceSquared(getLocation()) <= (radius * radius);
    }

    public double getRadius() {
        return radius;
    }
}
