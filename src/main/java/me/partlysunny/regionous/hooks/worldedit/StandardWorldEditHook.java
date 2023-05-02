package me.partlysunny.regionous.hooks.worldedit;

import com.sk89q.worldedit.IncompleteRegionException;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.bukkit.BukkitPlayer;
import com.sk89q.worldedit.regions.Region;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class StandardWorldEditHook extends WorldEditHook {
    public StandardWorldEditHook(JavaPlugin plugin) {
        super(plugin);
    }

    @Override
    public WorldEditRegion getSelectionRegion(Player player) {
        Region playerSelection;
        try {
            playerSelection = WorldEdit.getInstance().getSessionManager().get(new BukkitPlayer(player)).getSelection();
        } catch (IncompleteRegionException e) {
            throw new IllegalStateException("Player selection was incomplete!");
        }
        return new WorldEditRegion(playerSelection);
    }
}
