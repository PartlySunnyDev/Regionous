package me.partlysunny.regionous.entity;

import me.partlysunny.regionous.api.CircleRegion;
import me.partlysunny.regionous.util.Vector2;
import org.bukkit.entity.Entity;

public class EntityCircleRegion extends CircleRegion {

    private final Entity tracking;

    public EntityCircleRegion(String identifier, float radius, Entity tracking) {
        super(identifier, radius);
        this.tracking = tracking;
    }

    @Override
    public Vector2 getLocation() {
        return Vector2.fromLocationXZ(tracking.getLocation());
    }
}
