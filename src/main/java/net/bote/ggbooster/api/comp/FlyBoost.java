package net.bote.ggbooster.api.comp;

import net.bote.ggbooster.api.Boost;
import org.bukkit.Bukkit;

/**
 * @author Elias Arndt | bote100
 * Created on 22.03.2019
 */

public class FlyBoost extends Boost {

    public FlyBoost() {
        super("§d§lFlyBoost", 5);
    }

    @Override
    public void onStart() {
        Bukkit.getOnlinePlayers().forEach(player -> {
            player.sendMessage("§a§lDer Boost " + getName() + " §a§lwurde für "+getLenght()+" Minuten gestartet!");
            player.setAllowFlight(true);
            player.setFlying(true);
        });
        startTicking();
    }

    @Override
    public void onEnd() {
        Bukkit.getOnlinePlayers().forEach(player -> {
            player.sendMessage("§a§lDer Boost " + getName() + " §a§lwurde beendet.");
            player.setAllowFlight(false);
            player.setFlying(false);
        });
    }
}
