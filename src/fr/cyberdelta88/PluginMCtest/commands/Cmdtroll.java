package fr.cyberdelta88.PluginMCtest.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Cmdtroll implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length >= 1) {
                String playername = args[0];
                Player target = Bukkit.getServer().getPlayerExact(playername);
                if (target == null) {
                    p.sendMessage(ChatColor.GOLD + "Ce joueur n'est pa en ligne");
                } else {
                    p.sendMessage(ChatColor.GOLD + "Tu à trollé " + target.getDisplayName());
                    target.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, 20));
                    target.sendMessage(ChatColor.YELLOW + "Tu t'es fait troller par " + ChatColor.BLUE + p);

                }

            } else {
                p.playSound(p.getLocation(), Sound.ENDERDRAGON_HIT, 3.0F, 0.533F);
                p.sendMessage(ChatColor.DARK_RED + "/troll {nom du joueur}");
            }

        }

        return true;
    }
}
