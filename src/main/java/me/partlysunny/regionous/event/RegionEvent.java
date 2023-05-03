package me.partlysunny.regionous.event;

import me.partlysunny.regionous.api.Region;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;

public abstract class RegionEvent extends PlayerEvent {

    public static final HandlerList HANDLER_LIST = new HandlerList();
    private final HandlerList handlers = new HandlerList();
    private final Region region;

    public RegionEvent(Player player, Region region) {
        super(player);
        this.region = region;
    }

    public Region getRegion() {
        return region;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }

}
