package me.partlysunny.regionous;

import me.partlysunny.regionous.handler.RegionManager;
import me.partlysunny.regionous.hooks.worldguard.NoWorldGuard;
import me.partlysunny.regionous.hooks.worldguard.StandardWorldGuardHook;
import me.partlysunny.regionous.hooks.worldguard.WorldGuardHook;
import org.bukkit.plugin.java.JavaPlugin;

public class Regionous {

    private static Regionous instance;

    public static Regionous getInstance() {
        return instance;
    }

    public static void init(JavaPlugin plugin) {
        instance = new Regionous(plugin);
    }

    private final JavaPlugin plugin;
    private final RegionManager regionManager;
    private final WorldGuardHook worldGuardHook;

    public Regionous(JavaPlugin plugin) {
        this.plugin = plugin;
        this.regionManager = new RegionManager(plugin);
        if (plugin.getServer().getPluginManager().getPlugin("WorldGuard") != null) {
            this.worldGuardHook = new StandardWorldGuardHook(plugin);
        } else {
            this.worldGuardHook = new NoWorldGuard();
        }
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
}
