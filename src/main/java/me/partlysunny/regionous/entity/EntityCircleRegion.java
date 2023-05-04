package me.partlysunny.regionous.entity;

import me.partlysunny.regionous.api.CircleRegion;
import me.partlysunny.regionous.util.Loc2D;
import org.bukkit.entity.Entity;

public class EntityCircleRegion extends CircleRegion implements EntityBinder {

    private final Entity tracking;

    public EntityCircleRegion(String identifier, double radius, Entity tracking) {
        super(identifier, radius);
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
