package me.partlysunny.regionous.statics;

import me.partlysunny.regionous.api.CircleRegion;
import me.partlysunny.regionous.util.Vector2;

public class StaticCircleRegion extends CircleRegion {

    private final Vector2 location;

    public StaticCircleRegion(float radius, Vector2 location) {
        super(radius);
        this.location = location;
    }

    @Override
    public Vector2 getLocation() {
        return location;
    }
}
