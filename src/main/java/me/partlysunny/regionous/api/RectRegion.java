package me.partlysunny.regionous.api;

import me.partlysunny.regionous.util.Loc2D;
import org.bukkit.Location;

public abstract class RectRegion extends AbstractXZ {

    private final Loc2D size;

    public RectRegion(String identifier, Loc2D size) {
        super(identifier);
        this.size = size;
    }

    @Override
    public boolean isLocationInside(Location location) {
        return location.getX() >= getLocation().getX() && location.getX() <= getLocation().getX() + size.getX() &&
                location.getZ() >= getLocation().getZ() && location.getZ() <= getLocation().getZ() + size.getZ();
    }

    public Loc2D getSize() {
        return size;
    }
}
