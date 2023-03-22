package fr.cyberdelta88.PluginMCtest.commands;

import fr.cyberdelta88.PluginMCtest.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class CmdSetrdmdata implements CommandExecutor {
    Plugin plugin = Main.getPlugin(Main.class);
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (sender instanceof Player) {
            if (args.length >= 1) {
                p.sendMessage("debug : 1");
                plugin.getConfig().set("rdmdata", args[0]);
                String rdmdata = plugin.getConfig().getString("rdmdata");
                p.sendMessage(ChatColor.GREEN + "La donnée contenue à l'emplacement 'rdmdata' dans le config.yml est : " + ChatColor.BLUE + rdmdata);
            } else {
                p.sendMessage("debug : 2");
            }

        } else {
            sender.sendMessage("debug : 3");
        }

        return false;
    }
}
