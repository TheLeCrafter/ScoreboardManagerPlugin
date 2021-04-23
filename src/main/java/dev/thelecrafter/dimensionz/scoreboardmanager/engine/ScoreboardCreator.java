package dev.thelecrafter.dimensionz.scoreboardmanager.engine;

import dev.thelecrafter.dimensionz.scoreboardmanager.config.FileManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import java.util.List;

public class ScoreboardCreator {

    public static Scoreboard createFromConfig() {
        List<String> lines = FileManager.get().getStringList("lines");
        String title = FileManager.get().getString("title");
        return createFromList(lines, title);
    }

    public static Scoreboard createFromList(List<String> lines, String title) {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = manager.getNewScoreboard();
        Objective objective = scoreboard.registerNewObjective("managerboard", "dummy", title);
        int index = lines.size();
        for (String line : lines) {
            objective.getScore(line).setScore(index);
            index--;
        }
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        return scoreboard;
    }

}
