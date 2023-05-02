package me.partlysunny.regionous.entity;

import me.partlysunny.regionous.handler.RegionManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class DeathHandler implements Listener {

    private final RegionManager regionManager;

    public DeathHandler(RegionManager regionManager) {
        this.regionManager = regionManager;
    }

    @EventHandler
    public void entityDie(EntityDeathEvent e) {
        regionManager.stream().filter(r -> r instanceof EntityBinder).forEach(r -> {
            EntityBinder binder = (EntityBinder) r;
            if (binder.getEntity().equals(e.getEntity())) {
                regionManager.unregister(r);
            }
        });
    }

}
