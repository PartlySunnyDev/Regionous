package me.partlysunny.regionous.statics;

import me.partlysunny.regionous.api.CircleRegion;
import me.partlysunny.regionous.util.Loc2D;

public class StaticCircleRegion extends CircleRegion {

    private final Loc2D location;

    public StaticCircleRegion(String identifier, double radius, Loc2D location) {
        super(identifier, radius);
        this.location = location;
    }

    @Override
    public Loc2D getLocation() {
        return location;
    }
}
