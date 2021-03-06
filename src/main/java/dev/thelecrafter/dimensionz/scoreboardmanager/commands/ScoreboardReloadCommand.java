package dev.thelecrafter.dimensionz.scoreboardmanager.commands;

import dev.thelecrafter.dimensionz.scoreboardmanager.config.LocationFileManager;
import dev.thelecrafter.dimensionz.scoreboardmanager.config.ScoreboardFileManager;
import dev.thelecrafter.dimensionz.scoreboardmanager.engine.LocationHandler;
import dev.thelecrafter.dimensionz.scoreboardmanager.engine.ScoreboardCreator;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ScoreboardReloadCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        sender.sendMessage(ChatColor.YELLOW + "Lade neu...");
        ScoreboardFileManager.reload();
        LocationFileManager.reload();
        LocationHandler.setup();
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.setScoreboard(ScoreboardCreator.createFromConfig());
        }
        sender.sendMessage(ChatColor.GREEN + "Neugeladen!");
        return true;
    }
}
