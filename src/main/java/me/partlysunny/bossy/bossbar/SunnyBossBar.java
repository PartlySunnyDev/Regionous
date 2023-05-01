package me.partlysunny.bossy.bossbar;

import net.kyori.adventure.bossbar.BossBar;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;


public class SunnyBossBar {

    private final BossBar bossBar;

    public SunnyBossBar(Component name, BossBar.Color color, BossBar.Overlay overlay) {
        bossBar = BossBar.bossBar(name, 1.0f, color, overlay);
    }

    public SunnyBossBar(Component name, BossBar.Color color, BossBar.Overlay overlay, BossBar.Flag... flags) {
        bossBar = BossBar.bossBar(name, 1.0f, color, overlay);
        for (BossBar.Flag flag : flags) {
            bossBar.addFlag(flag);
        }
    }

    public SunnyBossBar(BossBar bossBar) {
        this.bossBar = bossBar;
    }

    public void addPlayer(Player player) {
        player.showBossBar(bossBar);
    }

    public void removePlayer(Player player) {
        player.hideBossBar(bossBar);
    }

    public void setDisplay(Component name, BossBar.Color color, BossBar.Overlay overlay) {
        bossBar.name(name);
        bossBar.color(color);
        bossBar.overlay(overlay);
    }

    public float getProgress() {
        return bossBar.progress();
    }

    public void setProgress(float progress) {
        bossBar.progress(progress);
    }

    public void addFlag(BossBar.Flag flag) {
        bossBar.addFlag(flag);
    }

    public void removeFlag(BossBar.Flag flag) {
        bossBar.removeFlag(flag);
    }

    public void clearFlags() {
        bossBar.flags().clear();
    }


}