package me.partlysunny.regionous.hooks.worldedit;

import com.sk89q.worldedit.IncompleteRegionException;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.bukkit.BukkitPlayer;
import com.sk89q.worldedit.bukkit.BukkitWorld;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.regions.AbstractRegion;
import com.sk89q.worldedit.regions.Region;
import com.sk89q.worldedit.regions.RegionOperationException;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Iterator;
import java.util.List;

public class StandardWorldEditHook extends WorldEditHook {
    public StandardWorldEditHook(JavaPlugin plugin) {
        super(plugin);
    }

    @Override
    public WorldEditRegion getSelectionRegion(String identifier, Player player) {
        Region playerSelection;
        try {
            playerSelection = WorldEdit.getInstance().getSessionManager().get(new BukkitPlayer(player)).getSelection();
        } catch (IncompleteRegionException e) {
            throw new IllegalStateException("Player selection was incomplete!");
        }
        return new WorldEditRegion(identifier, playerSelection);
    }

    @Override
    public WorldEditRegion getFromLocationList(String identifier, List<Location> locations) {
        return new WorldEditRegion(identifier, new AbstractRegion(new BukkitWorld(locations.get(0).getWorld())) {
            @Override
            public BlockVector3 getMinimumPoint() {
                return null;
            }

            @Override
            public BlockVector3 getMaximumPoint() {
                return null;
            }

            @Override
            public void expand(BlockVector3... changes) {
                throw new IllegalStateException("Cannot expand this region!");
            }

            @Override
            public void contract(BlockVector3... changes) {
                throw new IllegalStateException("Cannot contract this region!");
            }

            @Override
            public boolean contains(BlockVector3 position) {
                return false;
            }
        });
    }
}
