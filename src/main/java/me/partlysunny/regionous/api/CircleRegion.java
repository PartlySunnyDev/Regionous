package me.partlysunny.regionous.api;

import me.partlysunny.regionous.util.Loc2D;
import org.bukkit.Location;

public abstract class CircleRegion extends AbstractXZ {

    protected final double radius;

    public CircleRegion(String identifier, double radius) {
        super(identifier);
        this.radius = radius;
    }

    @Override
    public boolean isLocationInside(Location location) {
        return Loc2D.fromLocationXZ(location).distanceSquared(getLocation()) <= (radius * radius);
    }

    public double getRadius() {
        return radius;
    }
}
