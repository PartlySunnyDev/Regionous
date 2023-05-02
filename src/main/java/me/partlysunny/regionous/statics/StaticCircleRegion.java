package me.partlysunny.regionous.statics;

import me.partlysunny.regionous.api.CircleRegion;
import me.partlysunny.regionous.util.Vector2;

public class StaticCircleRegion extends CircleRegion {

    private final Vector2 location;

    public StaticCircleRegion(String identifier, float radius, Vector2 location) {
        super(identifier, radius);
        this.location = location;
    }

    @Override
    public Vector2 getLocation() {
        return location;
    }
}
