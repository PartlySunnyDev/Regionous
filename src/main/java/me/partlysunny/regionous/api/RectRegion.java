package me.partlysunny.regionous.api;

import me.partlysunny.regionous.util.Vector2;
import org.bukkit.Location;

public abstract class RectRegion implements XZRegion {

    private final Vector2 size;

    public RectRegion(Vector2 size) {
        this.size = size;
    }

    @Override
    public boolean isLocationInside(Location location) {
        return location.getX() >= getLocation().getA() && location.getX() <= getLocation().getA() + size.getA() &&
                location.getZ() >= getLocation().getB() && location.getZ() <= getLocation().getB() + size.getB();
    }
}
