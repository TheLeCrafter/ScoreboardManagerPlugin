package dev.thelecrafter.dimensionz.scoreboardmanager;

import dev.thelecrafter.dimensionz.scoreboardmanager.commands.ScoreboardReloadCommand;
import dev.thelecrafter.dimensionz.scoreboardmanager.config.DefaultConfig;
import dev.thelecrafter.dimensionz.scoreboardmanager.config.LocationFileManager;
import dev.thelecrafter.dimensionz.scoreboardmanager.config.ScoreboardFileManager;
import dev.thelecrafter.dimensionz.scoreboardmanager.engine.LocationHandler;
import dev.thelecrafter.dimensionz.scoreboardmanager.engine.ScoreboardCreator;
import dev.thelecrafter.dimensionz.scoreboardmanager.listeners.JoinListener;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class ScoreboardManagerPlugin extends JavaPlugin {

    public static ScoreboardManagerPlugin INSTANCE;

    @Override
    public void onEnable() {
        INSTANCE = this;
        ScoreboardFileManager.setup();
        LocationFileManager.setup();
        DefaultConfig.addDefaultValues();
        getCommand("scoreboardreload").setExecutor(new ScoreboardReloadCommand());
        Bukkit.getPluginManager().registerEvents(new JoinListener(), INSTANCE);
        Bukkit.getPluginManager().registerEvents(new LocationHandler(), INSTANCE);
        LocationHandler.setup();
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.setScoreboard(ScoreboardCreator.createFromConfigWithTeams());
        }
    }
}
