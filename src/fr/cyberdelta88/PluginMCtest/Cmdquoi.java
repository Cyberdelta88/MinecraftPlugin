package fr.cyberdelta88.PluginMCtest;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class Cmdquoi implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
              if (p.hasPermission("PluginMc_V1.op_perms")) {
                p.sendMessage("§4FEUR");
            }
            p.sendMessage(ChatColor.DARK_AQUA + "Tu n'a pas les permissions pour faire ça");
        }
        return true;
    }
}
