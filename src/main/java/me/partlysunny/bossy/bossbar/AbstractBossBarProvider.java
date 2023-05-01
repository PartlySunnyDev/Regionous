package me.partlysunny.bossy.bossbar;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractBossBarProvider implements Listener {

    private final Map<Player, SunnyBossBar> playerBars = new HashMap<>();

    public AbstractBossBarProvider(JavaPlugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void movement(PlayerMoveEvent e) {
        if (e.hasChangedPosition()) {
            Location location = e.getTo();
            double distSqr = location.distanceSquared(getPosition());
            float radius = radius();
            update(e.getPlayer(), distSqr <= radius * radius);
        }
    }

    private void update(Player player, boolean inside) {
        if (playerBars.containsKey(player)) {
            if (inside) playerBars.get(player).removePlayer(player);
            else playerBars.get(player).addPlayer(player);
        } else {
            if (inside) {
                SunnyBossBar initial = buildInitialBossBar(player);
                initial.addPlayer(player);
                playerBars.put(player, initial);
            }
        }
    }

    protected abstract Location getPosition();

    protected abstract float radius();

    protected abstract SunnyBossBar buildInitialBossBar(Player player);

    protected abstract void updatePlayer(Player player);

}
