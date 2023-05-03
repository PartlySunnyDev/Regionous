package me.partlysunny.regionous.api;

import me.partlysunny.regionous.save.Savable;
import org.bukkit.Location;

public interface Region {

    boolean isLocationInside(Location location);

    String identifier();
}
