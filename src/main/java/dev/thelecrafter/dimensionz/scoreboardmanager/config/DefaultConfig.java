package dev.thelecrafter.dimensionz.scoreboardmanager.config;

import org.bukkit.configuration.file.FileConfiguration;

public class DefaultConfig {

    private static final FileConfiguration config = FileManager.get();

    public static void addDefaultValues() {
        if (!config.contains("title")) {
            config.set("title", "Scoreboard Title");
            FileManager.save();
        }
        if (!config.contains("lines")) {
            config.set("lines", new String[]{"Highest line", "Mid line", "Lowest line"});
            FileManager.save();
        }
    }

}
