package dev.thelecrafter.dimensionz.scoreboardmanager.listeners;

import dev.thelecrafter.dimensionz.scoreboardmanager.engine.ScoreboardCreator;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.getPlayer().setScoreboard(ScoreboardCreator.createFromConfig());
    }

}
