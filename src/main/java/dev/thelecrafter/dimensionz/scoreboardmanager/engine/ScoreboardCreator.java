package dev.thelecrafter.dimensionz.scoreboardmanager.engine;

import dev.thelecrafter.dimensionz.scoreboardmanager.config.FileManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scoreboard.*;

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
        int index = lines.size() - 1;
        for (String line : lines) {
            if (line.length() > 40) {
                line = line.substring(0, 40);
            }
            objective.getScore(line).setScore(index);
            index--;
        }
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        return scoreboard;
    }

    // Unfinished
    public static Scoreboard createFromConfigWithTeams() {
        List<String> lines = FileManager.get().getStringList("lines");
        String title = FileManager.get().getString("title");
        return createFromListWithTeams(lines, title);
    }

    public static Scoreboard createFromListWithTeams(List<String> lines, String title) {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = manager.getNewScoreboard();
        Objective objective = scoreboard.registerNewObjective("managerboard", "dummy", title);
        int index = lines.size() - 1;
        int colorIndex = 0;
        ChatColor[] colors = ChatColor.values();
        if (lines.size() > 22) {
            for (int i = 22; i < lines.size(); i++) {
                lines.remove(i);
            }
            System.out.println("Too many lines!");
        }
        for (String line : lines) {
            if (line.length() > 40) {
                line = line.substring(0, 40);
            }
            objective.getScore(String.valueOf(colors[colorIndex])).setScore(index);
            Team team = scoreboard.registerNewTeam("line" + index);
            team.addEntry(String.valueOf(colors[colorIndex]));
            team.setPrefix(line);
            colorIndex++;
            index--;
        }
        return scoreboard;
    }

}
