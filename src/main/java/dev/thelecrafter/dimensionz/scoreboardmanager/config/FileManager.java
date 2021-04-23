package dev.thelecrafter.dimensionz.scoreboardmanager.config;

import dev.thelecrafter.dimensionz.scoreboardmanager.ScoreboardManagerPlugin;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class FileManager {

    private static File file;
    private static FileConfiguration customFile;

    // Finds or generates the custom file
    public static void setup() {
        file = new File(ScoreboardManagerPlugin.INSTANCE.getDataFolder(), "scoreboard.yml");

        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                // Just a catch lol
            }
        }

        customFile = YamlConfiguration.loadConfiguration(file);

    }

    // Get the file configuration
    public static FileConfiguration get() {
        return customFile;
    }

    // Save the file configuration
    public static void save() {
        try {
            customFile.save(file);
        } catch (IOException e) {
            System.out.println("Failed to save the scoreboard file!");
        }
    }

    // Reload the file configuration
    public static void reload() {
        customFile = YamlConfiguration.loadConfiguration(file);
    }

}
