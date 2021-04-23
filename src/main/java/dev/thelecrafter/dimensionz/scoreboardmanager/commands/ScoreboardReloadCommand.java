package dev.thelecrafter.dimensionz.scoreboardmanager.commands;

import dev.thelecrafter.dimensionz.scoreboardmanager.config.FileManager;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class ScoreboardReloadCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        sender.sendMessage(ChatColor.YELLOW + "Lade neu...");
        FileManager.reload();
        sender.sendMessage(ChatColor.GREEN + "Neugeladen!");
        return true;
    }
}
