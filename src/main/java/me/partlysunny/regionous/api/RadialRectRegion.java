package me.partlysunny.regionous.api;

import me.partlysunny.regionous.util.Loc2D;
import org.bukkit.Location;

public abstract class RadialRectRegion extends AbstractXZ {

    private final Loc2D radii;

    public RadialRectRegion(String identifier, Loc2D radii) {
        super(identifier);
        this.radii = radii;
    }

    @Override
    public boolean isLocationInside(Location location) {
        return Math.abs(location.getX() - getLocation().getX()) <= radii.getX() && Math.abs(location.getZ() - getLocation().getZ()) <= radii.getZ();
    }

    public Loc2D getRadii() {
        return radii;
    }
}
