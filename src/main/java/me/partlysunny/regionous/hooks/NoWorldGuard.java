package me.partlysunny.regionous.hooks;

import me.partlysunny.regionous.worldguard.WorldGuardRegion;
import org.bukkit.World;

public class NoWorldGuard extends WorldGuardHook {
    public NoWorldGuard() {
        super(null);
    }

    @Override
    public WorldGuardRegion getWorldGuardRegion(World world, String regionName) {
        throw new UnsupportedOperationException("WorldGuard was not found!");
    }
}
