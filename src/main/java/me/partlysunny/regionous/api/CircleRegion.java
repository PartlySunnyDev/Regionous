package me.partlysunny.regionous.api;

import me.partlysunny.regionous.util.Vector2;
import org.bukkit.Location;

public abstract class CircleRegion extends AbstractXZ {

    protected final float radius;

    public CircleRegion(String identifier, float radius) {
        super(identifier);
        this.radius = radius;
    }

    @Override
    public boolean isLocationInside(Location location) {
        return Vector2.fromLocationXZ(location).distanceSquared(getLocation()) <= (radius * radius);
    }
}
