package dev.thelecrafter.dimensionz.scoreboardmanager;

import dev.thelecrafter.dimensionz.scoreboardmanager.commands.ScoreboardReloadCommand;
import dev.thelecrafter.dimensionz.scoreboardmanager.config.DefaultConfig;
import dev.thelecrafter.dimensionz.scoreboardmanager.config.FileManager;
import dev.thelecrafter.dimensionz.scoreboardmanager.listeners.JoinListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class ScoreboardManagerPlugin extends JavaPlugin {

    public static ScoreboardManagerPlugin INSTANCE;

    @Override
    public void onEnable() {
        INSTANCE = this;
        FileManager.setup();
        DefaultConfig.addDefaultValues();
        getCommand("scoreboardreload").setExecutor(new ScoreboardReloadCommand());
        Bukkit.getPluginManager().registerEvents(new JoinListener(), INSTANCE);
    }
}
