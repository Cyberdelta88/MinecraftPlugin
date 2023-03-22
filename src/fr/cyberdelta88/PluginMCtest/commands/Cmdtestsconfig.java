package fr.cyberdelta88.PluginMCtest.commands;

import fr.cyberdelta88.PluginMCtest.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class Cmdtestsconfig implements CommandExecutor {

    Plugin plugin = Main.getPlugin(Main.class);
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            String rdmdata = plugin.getConfig().getString("rdmdata");
            String c = plugin.getConfig().getStringList("c").get(2);
            p.sendMessage(ChatColor.BLUE + rdmdata);
            p.sendMessage(ChatColor.BLUE + c);
        }


        return false;
    }
}
//"La donnée contenue à l'emplacement 'rdmdata' dans le config.yml est : "
//"La donnée contenue au 3ème emplacement de la liste c dans le plugin.yml est : "