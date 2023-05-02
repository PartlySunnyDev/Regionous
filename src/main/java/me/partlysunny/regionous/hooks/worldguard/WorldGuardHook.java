package me.partlysunny.regionous.hooks.worldguard;

import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class WorldGuardHook {

    protected final JavaPlugin plugin;

    public WorldGuardHook(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public abstract WorldGuardRegion getWorldGuardRegion(World world, String regionName);

}
