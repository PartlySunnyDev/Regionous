package me.partlysunny.regionous.statics;

import me.partlysunny.regionous.api.RadialRectRegion;
import me.partlysunny.regionous.util.Loc2D;

public class StaticRadialRectRegion extends RadialRectRegion {

    private final Loc2D location;

    public StaticRadialRectRegion(String identifier, Loc2D radii, Loc2D location) {
        super(identifier, radii);
        this.location = location;
    }

    @Override
    public Loc2D getLocation() {
        return location;
    }
}
