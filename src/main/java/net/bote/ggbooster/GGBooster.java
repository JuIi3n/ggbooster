package net.bote.ggbooster;

import lombok.Getter;
import net.bote.ggbooster.api.BoosterManager;
import net.bote.ggbooster.commands.BootserCommand;
import net.bote.ggbooster.listener.BoosterListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Elias Arndt | bote100
 * Created on 22.03.2019
 */

@Getter
public class GGBooster extends JavaPlugin {

    @Getter
    private static GGBooster instance;
    private BoosterManager boosterManager;

    @Override
    public void onEnable() {
        instance = this;
        boosterManager = new BoosterManager();
        Bukkit.getPluginCommand("booster").setExecutor(new BootserCommand());
        Bukkit.getPluginManager().registerEvents(new BoosterListener(), this);
    }

    @Override
    public void onDisable() {

    }
}
