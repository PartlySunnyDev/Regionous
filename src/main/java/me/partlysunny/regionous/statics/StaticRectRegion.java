package me.partlysunny.regionous.statics;

import me.partlysunny.regionous.api.RectRegion;
import me.partlysunny.regionous.util.Vector2;

public class StaticRectRegion extends RectRegion {

    private final Vector2 location;

    public StaticRectRegion(Vector2 size, Vector2 location) {
        super(size);
        this.location = location;
    }

    @Override
    public Vector2 getLocation() {
        return location;
    }
}
