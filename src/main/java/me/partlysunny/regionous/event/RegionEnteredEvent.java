package me.partlysunny.regionous.event;

import me.partlysunny.regionous.api.Region;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

public class RegionEnteredEvent extends RegionEvent {
    public RegionEnteredEvent(Player player, Region region) {
        super(player, region);
    }

    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }
}
