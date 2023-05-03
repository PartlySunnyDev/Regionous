package me.partlysunny.regionous.hooks.worldedit;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public abstract class WorldEditHook {

    protected final JavaPlugin plugin;

    public WorldEditHook(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public abstract WorldEditRegion getSelectionRegion(String identifier, Player player);

    public abstract WorldEditRegion getFromLocationList(String identifier, List<Location> locations);

}
