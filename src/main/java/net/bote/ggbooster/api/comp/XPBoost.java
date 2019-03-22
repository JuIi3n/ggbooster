package net.bote.ggbooster.api.comp;

import net.bote.ggbooster.api.Boost;
import org.bukkit.Bukkit;

/**
 * @author Elias Arndt | bote100
 * Created on 22.03.2019
 */

public class XPBoost extends Boost {

    public XPBoost() {
        super("XPBoost", 4);
    }

    @Override
    public void onStart() {
        Bukkit.getOnlinePlayers().forEach(player ->
                player.sendMessage("§a§lDer Boost " + getName() + " §a§lwurde für "+getLenght()+" Minuten gestartet!"));
        startTicking();
    }
}
