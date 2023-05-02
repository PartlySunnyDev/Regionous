package me.partlysunny.regionous.hooks;

import com.sk89q.worldedit.bukkit.BukkitWorld;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.managers.RegionManager;
import me.partlysunny.regionous.worldguard.WorldGuardRegion;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

public class StandardWorldGuardHook extends WorldGuardHook {
    public StandardWorldGuardHook(JavaPlugin plugin) {
        super(plugin);
    }

    @Override
    public WorldGuardRegion getWorldGuardRegion(World world, String regionName) {
        RegionManager regionManager = WorldGuard.getInstance().getPlatform().getRegionContainer().get(new BukkitWorld(world));
        if (regionManager == null) {
            return null;
        }
        return new WorldGuardRegion(regionManager.getRegion(regionName));
    }
}
