package me.partlysunny.regionous.api;

import org.bukkit.Location;

public interface Region {

    boolean isLocationInside(Location location);

    String identifier();

    boolean toSave();

    void setToSave(boolean toSave);
}
