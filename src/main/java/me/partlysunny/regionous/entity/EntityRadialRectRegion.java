package me.partlysunny.regionous.entity;

import me.partlysunny.regionous.api.RadialRectRegion;
import me.partlysunny.regionous.util.Loc2D;
import org.bukkit.entity.Entity;

public class EntityRadialRectRegion extends RadialRectRegion implements EntityBinder {

    private final Entity tracking;

    public EntityRadialRectRegion(String identifier, Loc2D radii, Entity tracking) {
        super(identifier, radii);
        this.tracking = tracking;
    }

    @Override
    public Loc2D getLocation() {
        return Loc2D.fromLocationXZ(tracking.getLocation());
    }

    @Override
    public Entity getEntity() {
        return tracking;
    }
}
