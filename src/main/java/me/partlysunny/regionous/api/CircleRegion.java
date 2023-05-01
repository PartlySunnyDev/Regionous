package me.partlysunny.regionous.api;

import me.partlysunny.regionous.util.Vector2;
import org.bukkit.Location;

public abstract class CircleRegion implements XZRegion {

    private final float radius;

    public CircleRegion(float radius) {
        this.radius = radius;
    }

    @Override
    public boolean isLocationInside(Location location) {
        return Vector2.fromLocationXZ(location).distanceSquared(getLocation()) <= (radius * radius);
    }
}
