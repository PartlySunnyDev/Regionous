package me.partlysunny.regionous.statics;

import me.partlysunny.regionous.api.RadialRectRegion;
import me.partlysunny.regionous.util.Vector2;

public class StaticRadialRectRegion extends RadialRectRegion {

    private final Vector2 location;

    protected StaticRadialRectRegion(Vector2 radii, Vector2 location) {
        super(radii);
        this.location = location;
    }
    
    @Override
    public Vector2 getLocation() {
        return location;
    }
}