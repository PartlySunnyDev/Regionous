package me.partlysunny.regionous.api;

import me.partlysunny.regionous.util.Vector2;
import org.bukkit.Location;

public abstract class RadialRectRegion extends AbstractXZ {

    private final Vector2 radii;

    public RadialRectRegion(String identifier, Vector2 radii) {
        super(identifier);
        this.radii = radii;
    }

    @Override
    public boolean isLocationInside(Location location) {
        return Math.abs(location.getX() - getLocation().getA()) <= radii.getA() && Math.abs(location.getZ() - getLocation().getB()) <= radii.getB();
    }

    public Vector2 getRadii() {
        return radii;
    }
}
