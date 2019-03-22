package net.bote.ggbooster.commands;

import net.bote.ggbooster.GGBooster;
import net.bote.ggbooster.api.comp.FlyBoost;
import net.bote.ggbooster.api.comp.XPBoost;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author Elias Arndt | bote100
 * Created on 22.03.2019
 */

public class BootserCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player)sender;

        if(!GGBooster.getInstance().getBoosterManager().getActiveBoosts().isEmpty()) {
            p.sendMessage("§cEs ist derzeit schon ein Boost aktiv!");
            return false;
        }

        switch (args.length) {
            case 0:
                p.sendMessage("§7Nutze bitte §e/booster help");
                return false;
            case 1:
                if(args[0].equalsIgnoreCase("help")) {
                    p.sendMessage("§7Nutze: §e/booster fly");
                    p.sendMessage("§7Nutze: §e/booster xp");
                    return false;
                } else if(args[0].equalsIgnoreCase("fly") || args[0].equalsIgnoreCase("xp")) {
                    if(args[0].equalsIgnoreCase("fly")) {
                        GGBooster.getInstance().getBoosterManager().startBoost(new FlyBoost());
                        return false;
                    }
                    if(args[0].equalsIgnoreCase("xp")) {
                        GGBooster.getInstance().getBoosterManager().startBoost(new XPBoost());
                        return false;
                    }
                } else {
                    p.sendMessage("§7Nutze bitte §e/booster help");
                }
                break;
             default:
                 p.sendMessage("§7Nutze bitte §e/booster help");
                 break;
        }

        return false;
    }
}
