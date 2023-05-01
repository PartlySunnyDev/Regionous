package me.partlysunny.regionous.statics;

import me.partlysunny.regionous.api.SphereRegion;
import org.bukkit.Location;

public class StaticSphereRegion extends SphereRegion {

    private final Location location;

    public StaticSphereRegion(float radius, Location location) {
        super(radius);
        this.location = location;
    }

    @Override
    public Location getLocation() {
        return location;
    }
}
