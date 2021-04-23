package dev.thelecrafter.dimensionz.scoreboardmanager.listeners;

import dev.thelecrafter.dimensionz.scoreboardmanager.engine.ScoreboardCreator;
import dev.thelecrafter.dimensionz.scoreboardmanager.engine.ScoreboardUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.getPlayer().setScoreboard(ScoreboardUtils.createBoard(event.getPlayer()));
    }

}
