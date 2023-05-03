package me.partlysunny.regionous.statics;

import me.partlysunny.regionous.api.RadialRectRegion;
import me.partlysunny.regionous.util.Vector2;

public class StaticRadialRectRegion extends RadialRectRegion {

    private final Vector2 location;

    public StaticRadialRectRegion(String identifier, Vector2 radii, Vector2 location) {
        super(identifier, radii);
        this.location = location;
    }

    @Override
    public Vector2 getLocation() {
        return location;
    }
}
