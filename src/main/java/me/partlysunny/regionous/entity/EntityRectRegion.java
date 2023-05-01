package me.partlysunny.regionous.entity;

import me.partlysunny.regionous.api.RectRegion;
import me.partlysunny.regionous.util.Vector2;
import org.bukkit.entity.Entity;

public class EntityRectRegion extends RectRegion {

    private final Entity tracking;

    public EntityRectRegion(Vector2 size, Entity tracking) {
        super(size);
        this.tracking = tracking;
    }

    @Override
    public Vector2 getLocation() {
        return Vector2.fromLocationXZ(tracking.getLocation());
    }
}
