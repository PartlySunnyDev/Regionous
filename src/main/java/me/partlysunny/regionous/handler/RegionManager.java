package me.partlysunny.regionous.handler;

import me.partlysunny.regionous.handler.event.RegionEnteredEvent;
import me.partlysunny.regionous.api.Region;
import me.partlysunny.regionous.handler.event.RegionExitedEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class RegionManager implements Listener {

    private final List<Region> regions = new ArrayList<>();

    public RegionManager(JavaPlugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void playerMoveEvent(PlayerMoveEvent e) {
        if (e.hasChangedPosition()) {
            regions.stream().filter(region -> region.isLocationInside(e.getTo()) && !region.isLocationInside(e.getFrom())).forEach(region -> Bukkit.getServer().getPluginManager().callEvent(new RegionEnteredEvent(e.getPlayer(), region)));
            regions.stream().filter(region -> !region.isLocationInside(e.getTo()) && region.isLocationInside(e.getFrom())).forEach(region -> Bukkit.getServer().getPluginManager().callEvent(new RegionExitedEvent(e.getPlayer(), region)));
        }
    }

    public void register(Region region) {
        regions.add(region);
    }

    public void unregister(Region region) {
        regions.remove(region);
    }

    public void unregisterAll() {
        regions.clear();
    }


}
