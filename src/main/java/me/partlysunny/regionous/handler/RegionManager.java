package me.partlysunny.regionous.handler;

import me.partlysunny.regionous.handler.event.RegionEnteredEvent;
import me.partlysunny.regionous.api.Region;
import me.partlysunny.regionous.handler.event.RegionExitedEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public class RegionManager implements Listener {

    private final List<Region> regions = new ArrayList<>();
    private final Map<UUID, Map<Region, Boolean>> lastKnownStates = new HashMap<>();

    public RegionManager(JavaPlugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void playerMoveEvent(PlayerMoveEvent e) {
        if (!e.getFrom().equals(e.getTo())) {
            // TODO Technically there is a bug here, say if the player is afk and the entity containing the region moves in range, the event will not be called
            UUID uuid = e.getPlayer().getUniqueId();
            if (!lastKnownStates.containsKey(uuid)) {
                lastKnownStates.put(uuid, new HashMap<>());
            }
            Map<Region, Boolean> playerLastState = lastKnownStates.get(uuid);
            regions.stream().filter(region -> region.isLocationInside(e.getTo()) && !playerLastState.get(region)).forEach(region -> {
                Bukkit.getServer().getPluginManager().callEvent(new RegionEnteredEvent(e.getPlayer(), region));
                playerLastState.put(region, true);
            });
            regions.stream().filter(region -> !region.isLocationInside(e.getTo()) && playerLastState.get(region)).forEach(region -> {
                Bukkit.getServer().getPluginManager().callEvent(new RegionExitedEvent(e.getPlayer(), region));
                playerLastState.put(region, false);
            });
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