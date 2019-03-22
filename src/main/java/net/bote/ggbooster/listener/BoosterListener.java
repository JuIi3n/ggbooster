package net.bote.ggbooster.listener;

import net.bote.ggbooster.GGBooster;
import net.bote.ggbooster.api.comp.FlyBoost;
import net.bote.ggbooster.api.comp.XPBoost;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLevelChangeEvent;

/**
 * @author Elias Arndt | bote100
 * Created on 22.03.2019
 */

public class BoosterListener implements Listener {

    @EventHandler
    public void handleXP(PlayerLevelChangeEvent e) {
        if(e.getNewLevel() > e.getOldLevel()) {
            // dazu
            if(GGBooster.getInstance().getBoosterManager().isActive(new XPBoost())) {
                // aktiv
                e.getPlayer().setLevel(e.getPlayer().getExpToLevel() + (e.getNewLevel() * 2));
            }

        }
    }


    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        FlyBoost flyBoost = new FlyBoost();
        if(GGBooster.getInstance().getBoosterManager().getActiveBoosts().stream().anyMatch(b -> b.getName().equalsIgnoreCase(flyBoost.getName()))) {
            e.getPlayer().setFlying(true);
            e.getPlayer().setAllowFlight(true);
        }

    }

}
