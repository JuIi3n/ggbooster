package net.bote.ggbooster.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import net.bote.ggbooster.GGBooster;
import org.bukkit.Bukkit;

/**
 * @author Elias Arndt | bote100
 * Created on 22.03.2019
 */

@AllArgsConstructor
@Getter
@Setter
public class Boost implements BoostEvents {

    private String name;
    private int lenght;

    public void onStart() { }

    public void onEnd() { }

    public void startTicking() {
        GGBooster.getInstance().getBoosterManager().getActiveBoosts().add(this);
        Bukkit.getScheduler().runTaskLater(GGBooster.getInstance(), () -> {
            onEnd();
            GGBooster.getInstance().getBoosterManager().getActiveBoosts().remove(this);
        }, 20*60*lenght);
    }

}
