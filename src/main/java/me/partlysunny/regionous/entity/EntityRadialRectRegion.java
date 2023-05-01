package me.partlysunny.regionous.entity;

import me.partlysunny.regionous.api.RadialRectRegion;
import me.partlysunny.regionous.util.Vector2;
import org.bukkit.entity.Entity;

public class EntityRadialRectRegion extends RadialRectRegion {

    private final Entity tracking;

    protected EntityRadialRectRegion(Vector2 radii, Entity tracking) {
        super(radii);
        this.tracking = tracking;
    }

    @Override
    public Vector2 getLocation() {
        return Vector2.fromLocationXZ(tracking.getLocation());
    }
}
