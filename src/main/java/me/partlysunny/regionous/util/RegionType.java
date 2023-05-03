package me.partlysunny.regionous.util;

import me.partlysunny.regionous.api.Region;
import me.partlysunny.regionous.entity.EntityCircleRegion;
import me.partlysunny.regionous.entity.EntityRadialRectRegion;
import me.partlysunny.regionous.entity.EntityRectRegion;
import me.partlysunny.regionous.entity.EntitySphereRegion;
import me.partlysunny.regionous.hooks.worldedit.WorldEditRegion;
import me.partlysunny.regionous.hooks.worldguard.WorldGuardRegion;
import me.partlysunny.regionous.statics.StaticCircleRegion;
import me.partlysunny.regionous.statics.StaticRadialRectRegion;
import me.partlysunny.regionous.statics.StaticRectRegion;
import me.partlysunny.regionous.statics.StaticSphereRegion;

public enum RegionType {

    UNKNOWN(null),
    ENTITY_CIRCLE(EntityCircleRegion.class),
    STATIC_CIRCLE(StaticCircleRegion.class),
    ENTITY_RECTANGLE(EntityRectRegion.class),
    STATIC_RECTANGLE(StaticRectRegion.class),
    ENTITY_RADIAL_RECT(EntityRadialRectRegion.class),
    STATIC_RADIAL_RECT(StaticRadialRectRegion.class),
    ENTITY_SPHERE(EntitySphereRegion.class),
    STATIC_SPHERE(StaticSphereRegion.class),
    WORLD_GUARD(WorldGuardRegion.class),
    WORLD_EDIT(WorldEditRegion.class);

    final Class<? extends Region> clazz;

    RegionType(Class<? extends Region> clazz) {
        this.clazz = clazz;
    }

    public Class<? extends Region> getClazz() {
        return clazz;
    }

    public static RegionType typeof(Region region) {
        for (RegionType type : values()) {
            if (type.getClazz().isInstance(region)) {
                return type;
            }
        }
        return RegionType.UNKNOWN;
    }

    public boolean isEntity() {
        return this.name().startsWith("ENTITY_");
    }

    public boolean is3d() {
        return this == ENTITY_SPHERE || this == STATIC_SPHERE;
    }

    public boolean isWorldGuard() {
        return this == WORLD_GUARD;
    }

    public boolean isWorldEdit() {
        return this == WORLD_EDIT;
    }

    public boolean isStatic() {
        return this.name().startsWith("STATIC_");
    }
}
