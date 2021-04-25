package dev.thelecrafter.dimensionz.scoreboardmanager.engine;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.util.BoundingBox;

public class SpecialInformationHandler {

    public static String prefix(BoundingBox box) {
        if (box != null) {
            switch (LocationHandler.BOX_IDS.get(box)) {
                case "tempel_tor":
                case "tempel":
                    return ChatColor.GOLD + "Tor Status: ";
                default:
                    return ChatColor.DARK_GRAY + "Keine Informationen";
            }
        } else return "";
    }

    public static String suffix(BoundingBox box) {
        if (box != null) {
            switch (LocationHandler.BOX_IDS.get(box)) {
                case "tempel_tor":
                case "tempel":
                    return ChatColor.RED + "COMING SOON";
                default:
                    return "";
            }
        } else return "";
    }

}
