package me.partlysunny.regionous.statics;

import me.partlysunny.regionous.api.RectRegion;
import me.partlysunny.regionous.util.Loc2D;

public class StaticRectRegion extends RectRegion {

    private final Loc2D location;

    public StaticRectRegion(String identifier, Loc2D size, Loc2D location) {
        super(identifier, size);
        this.location = location;
    }

    @Override
    public Loc2D getLocation() {
        return location;
    }
}
