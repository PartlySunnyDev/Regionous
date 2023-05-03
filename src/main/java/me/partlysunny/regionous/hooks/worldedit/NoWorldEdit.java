package me.partlysunny.regionous.hooks.worldedit;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.Iterator;

public class NoWorldEdit extends WorldEditHook {
    public NoWorldEdit() {
        super(null);
    }

    @Override
    public WorldEditRegion getSelectionRegion(String identifier, Player player) {
        throw new UnsupportedOperationException("WorldEdit was not found!");
    }

    @Override
    public WorldEditRegion getFromLocationList(String identifier, Iterator<Location> locations) {
        throw new UnsupportedOperationException("WorldEdit was not found!");
    }
}
