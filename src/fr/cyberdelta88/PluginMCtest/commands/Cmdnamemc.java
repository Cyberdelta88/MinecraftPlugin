package fr.cyberdelta88.PluginMCtest.commands;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Cmdnamemc implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p2 = null;
        if (sender instanceof Player) {
            p2 = (Player) sender;
            if (args.length >= 1) {
                String LienNameMc = "https://fr.namemc.com/profile/" + args[0];
                TextComponent msgoui = new TextComponent("§aVoici le lien tu peux cliquer dessus");
                msgoui.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§dClique pour ouvrir le lien").create()));
                msgoui.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, LienNameMc));
                p2.spigot().sendMessage(msgoui);
            } else {
                if (args.length < 1) {
                    sender.sendMessage("§c/" + label + " {nom de l'utilisateur Minectaft}");
                    return false;
                }

            }
            return false;
        } else {
            if (args.length >= 1) {
                String LienNameMc = "https://fr.namemc.com/profile/" + args[0];
                sender.sendMessage(LienNameMc);
            }
        }
        return false;
    }
}
