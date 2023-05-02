package me.partlysunny.regionous.statics;

import me.partlysunny.regionous.api.SphereRegion;
import org.bukkit.Location;

public class StaticSphereRegion extends SphereRegion {

    private final Location location;

    public StaticSphereRegion(String identifier, float radius, Location location) {
        super(identifier, radius);
        this.location = location;
    }

    @Override
    public Location getLocation() {
        return location;
    }
}
