package me.partlysunny.regionous;

import me.partlysunny.regionous.handler.RegionManager;
import me.partlysunny.regionous.hooks.worldedit.NoWorldEdit;
import me.partlysunny.regionous.hooks.worldedit.StandardWorldEditHook;
import me.partlysunny.regionous.hooks.worldedit.WorldEditHook;
import me.partlysunny.regionous.hooks.worldguard.NoWorldGuard;
import me.partlysunny.regionous.hooks.worldguard.StandardWorldGuardHook;
import me.partlysunny.regionous.hooks.worldguard.WorldGuardHook;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

import static java.util.logging.Level.INFO;

public class Regionous {

    private static Regionous instance;
    private final JavaPlugin plugin;
    private final RegionManager regionManager;
    private final WorldGuardHook worldGuardHook;
    private final WorldEditHook worldEditHook;

    public Regionous(JavaPlugin plugin) {
        this.plugin = plugin;
        this.regionManager = new RegionManager(plugin);
        Logger logger = plugin.getLogger();
        if (plugin.getServer().getPluginManager().getPlugin("WorldGuard") != null) {
            this.worldGuardHook = new StandardWorldGuardHook(plugin);
            logger.log(INFO, "Regionous is hooking into WorldGuard via plugin " + plugin.getName());
        } else {
            this.worldGuardHook = new NoWorldGuard();
        }
        if (plugin.getServer().getPluginManager().getPlugin("WorldEdit") != null) {
            this.worldEditHook = new StandardWorldEditHook(plugin);
            logger.log(INFO, "Regionous is hooking into WorldEdit via plugin " + plugin.getName());
        } else {
            this.worldEditHook = new NoWorldEdit();
        }
    }

    public static Regionous getInstance() {
        return instance;
    }

    public static void init(JavaPlugin plugin) {
        instance = new Regionous(plugin);
    }

    public JavaPlugin getPlugin() {
        return plugin;
    }

    public RegionManager getRegionManager() {
        return regionManager;
    }

    public WorldGuardHook getWorldGuardHook() {
        return worldGuardHook;
    }

    public WorldEditHook getWorldEditHook() {
        return worldEditHook;
    }
}
