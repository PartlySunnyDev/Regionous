package me.partlysunny.regionous.entity;

import me.partlysunny.regionous.api.SphereRegion;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class EntitySphereRegion extends SphereRegion {

    private final Entity tracking;

    public EntitySphereRegion(float radius, Entity tracking) {
        super(radius);
        this.tracking = tracking;
    }

    @Override
    public Location getLocation() {
        return tracking.getLocation();
    }
}
