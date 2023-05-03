package me.partlysunny.regionous.entity;

import me.partlysunny.regionous.api.RadialRectRegion;
import me.partlysunny.regionous.util.Vector2;
import org.bukkit.entity.Entity;

public class EntityRadialRectRegion extends RadialRectRegion implements EntityBinder {

    private final Entity tracking;

    public EntityRadialRectRegion(String identifier, Vector2 radii, Entity tracking) {
        super(identifier, radii);
        this.tracking = tracking;
    }

    @Override
    public Vector2 getLocation() {
        return Vector2.fromLocationXZ(tracking.getLocation());
    }

    @Override
    public Entity getEntity() {
        return tracking;
    }
}
