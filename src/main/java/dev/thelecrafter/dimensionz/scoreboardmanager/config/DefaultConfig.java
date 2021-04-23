package dev.thelecrafter.dimensionz.scoreboardmanager.config;

import org.bukkit.configuration.file.FileConfiguration;

public class DefaultConfig {

    private static final FileConfiguration scoreboard_config = ScoreboardFileManager.get();
    private static final FileConfiguration locations_config = LocationFileManager.get();

    public static void addDefaultValues() {
        // scoreboard.yml
        if (!scoreboard_config.contains("title")) {
            scoreboard_config.set("title", "Scoreboard Title");
            ScoreboardFileManager.save();
        }
        if (!scoreboard_config.contains("lines")) {
            scoreboard_config.set("lines", new String[]{"Highest line", "Mid line", "Lowest line"});
            ScoreboardFileManager.save();
        }
        if (!scoreboard_config.contains("location_line")) {
            scoreboard_config.set("location_line", 0);
            ScoreboardFileManager.save();
        }
        // locations.yml
        for (String keys : locations_config.getKeys(false)) {
            if (!locations_config.contains(keys + ".display_name")) {
                locations_config.set(keys + ".display_name", "Display Name");
                LocationFileManager.save();
            }
            if (!locations_config.contains(keys + ".x1")) {
                locations_config.set(keys + ".x1", "0");
                LocationFileManager.save();
            }
            if (!locations_config.contains(keys + ".x2")) {
                locations_config.set(keys + ".x2", "0");
                LocationFileManager.save();
            }
            if (!locations_config.contains(keys + ".y1")) {
                locations_config.set(keys + ".y1", "0");
                LocationFileManager.save();
            }
            if (!locations_config.contains(keys + ".y2")) {
                locations_config.set(keys + ".y2", "0");
                LocationFileManager.save();
            }
            if (!locations_config.contains(keys + ".z1")) {
                locations_config.set(keys + ".z1", "0");
                LocationFileManager.save();
            }
            if (!locations_config.contains(keys + ".z2")) {
                locations_config.set(keys + ".z2", "0");
                LocationFileManager.save();
            }
            if (!locations_config.contains(keys + ".priority")) {
                locations_config.set(keys + ".priority", 0);
                LocationFileManager.save();
            }
        }
    }

}
