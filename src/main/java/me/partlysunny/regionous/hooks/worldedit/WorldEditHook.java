package me.partlysunny.regionous.hooks.worldedit;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class WorldEditHook {

    protected final JavaPlugin plugin;

    public WorldEditHook(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public abstract WorldEditRegion getSelectionRegion(String identifier, Player player);

}
