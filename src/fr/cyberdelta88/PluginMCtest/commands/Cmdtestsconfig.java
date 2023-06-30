package fr.cyberdelta88.PluginMCtest.commands;


import fr.cyberdelta88.PluginMCtest.files.Customconfigfiles;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Cmdtestsconfig implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if (sender instanceof Player) {
            p.sendMessage(Customconfigfiles.getcustomfile().getString("message"));
        }

        return true;
    }
}
