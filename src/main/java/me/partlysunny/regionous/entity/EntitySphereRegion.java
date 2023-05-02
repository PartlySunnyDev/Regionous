package me.partlysunny.regionous.entity;

import me.partlysunny.regionous.api.SphereRegion;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class EntitySphereRegion extends SphereRegion implements EntityBinder {

    private final Entity tracking;

    public EntitySphereRegion(String identifier, float radius, Entity tracking) {
        super(identifier, radius);
        this.tracking = tracking;
    }

    @Override
    public Location getLocation() {
        return tracking.getLocation();
    }

    @Override
    public Entity getEntity() {
        return tracking;
    }
}
