package dev.thelecrafter.dimensionz.scoreboardmanager.engine;

import dev.thelecrafter.dimensionz.scoreboardmanager.config.LocationFileManager;
import dev.thelecrafter.dimensionz.scoreboardmanager.config.ScoreboardFileManager;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.BoundingBox;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LocationHandler implements Listener {

    public static final Map<BoundingBox, String> BOXES = new HashMap<>();
    public static final Map<BoundingBox, Integer> BOX_PRIORITIES = new HashMap<>();

    public static void setup() {
        for (String location_id : LocationFileManager.get().getKeys(false)) {
            String location_name = LocationFileManager.get().getString(location_id + ".display_name");
            BoundingBox box = new BoundingBox(
                    LocationFileManager.get().getInt(location_id + ".x1"),
                    LocationFileManager.get().getInt(location_id + ".y1"),
                    LocationFileManager.get().getInt(location_id + ".z1"),
                    LocationFileManager.get().getInt(location_id + ".x2"),
                    LocationFileManager.get().getInt(location_id + ".y2"),
                    LocationFileManager.get().getInt(location_id + ".z2"));
            BOXES.put(box, location_name);
            BOX_PRIORITIES.put(box, LocationFileManager.get().getInt(location_id + ".priority"));
        }
    }

    @EventHandler
    public static void onPlayerMove(PlayerMoveEvent event) {
        BoundingBox box = null;
        for (BoundingBox toCheck : BOXES.keySet()) {
            if (toCheck.contains(event.getTo().getX(), event.getTo().getY(), event.getTo().getZ())) {
                if (box != null) {
                    int currentPriority = BOX_PRIORITIES.get(box);
                    int newPriority = BOX_PRIORITIES.get(toCheck);
                    if (newPriority > currentPriority) {
                        box = toCheck;
                    }
                } else box = toCheck;
            }
        }
        String displayName = ChatColor.DARK_GREEN + "Wildnis";
        if (box != null) {
            displayName = BOXES.get(box);
        }
        event.getPlayer().getScoreboard();
        if (event.getPlayer().getScoreboard().getTeam("line" + ScoreboardFileManager.get().getInt("location_line")) != null) {
            event.getPlayer().getScoreboard().getTeam("line" + ScoreboardFileManager.get().getInt("location_line")).setPrefix(displayName);
        }
    }

}
