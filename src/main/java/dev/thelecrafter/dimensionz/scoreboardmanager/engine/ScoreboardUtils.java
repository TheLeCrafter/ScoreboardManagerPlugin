package dev.thelecrafter.dimensionz.scoreboardmanager.engine;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScoreboardUtils {

    public static Scoreboard createBoard(Player player) {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = manager.getNewScoreboard();
        Objective objective = scoreboard.registerNewObjective("pluginboard", "dummy", ChatColor.GOLD + "RPG [SOON]");
        if (lines(player).values().size() > 22) return scoreboard;
        int index = lines(player).size() - 1;
        int colorIndex = 0;
        ChatColor[] colors = ChatColor.values();
        for (String teamString : lines(player).keySet()) {
            String line = lines(player).get(teamString);
            if (line.length() > 40) {
                line = line.substring(0, 40);
            }
            objective.getScore(String.valueOf(colors[colorIndex])).setScore(index);
            Team team = scoreboard.registerNewTeam(teamString);
            team.addEntry(String.valueOf(colors[colorIndex]));
            team.setPrefix(line);
            colorIndex++;
            index--;
        }
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        return scoreboard;
    }

    public static Map<String, String> lines(Player player) {
        Map<String, String> map = new HashMap<>();
        map.put("day", ChatColor.DARK_GRAY + "Tag " + Math.floor(player.getWorld().getFullTime() / 24000));
        map.put("empty_one", "");
        map.put("welcome_one", ChatColor.GRAY + "Willkommen");
        map.put("welcome_two", ChatColor.WHITE + player.getDisplayName());
        return map;
    }

}
