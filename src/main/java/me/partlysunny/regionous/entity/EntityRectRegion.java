package me.partlysunny.regionous.entity;

import me.partlysunny.regionous.api.RectRegion;
import me.partlysunny.regionous.util.Loc2D;
import org.bukkit.entity.Entity;

public class EntityRectRegion extends RectRegion implements EntityBinder {

    private final Entity tracking;

    public EntityRectRegion(String identifier, Loc2D size, Entity tracking) {
        super(identifier, size);
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
