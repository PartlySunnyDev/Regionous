package me.partlysunny.regionous.handler.event;

import me.partlysunny.regionous.api.Region;
import org.bukkit.entity.Player;

public class RegionExitedEvent extends RegionEvent {
    public RegionExitedEvent(Player player, Region region) {
        super(player, region);
    }
}
