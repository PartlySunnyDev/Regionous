package me.partlysunny.regionous.handler.event;

import me.partlysunny.regionous.api.Region;
import org.bukkit.entity.Player;

public class RegionEnteredEvent extends RegionEvent {
    public RegionEnteredEvent(Player player, Region region) {
        super(player, region);
    }
}
