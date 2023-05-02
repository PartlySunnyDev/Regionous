package me.partlysunny.regionous.hooks.worldedit;

import org.bukkit.entity.Player;

public class NoWorldEdit extends WorldEditHook {
    public NoWorldEdit() {
        super(null);
    }

    @Override
    public WorldEditRegion getSelectionRegion(String identifier, Player player) {
        throw new UnsupportedOperationException("WorldEdit was not found!");
    }
}
