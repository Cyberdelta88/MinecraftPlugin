package fr.cyberdelta88.PluginMCtest.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.util.EulerAngle;

public class CmdArmorstand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            ArmorStand armorstand = (ArmorStand) p.getWorld().spawnEntity(p.getLocation(), EntityType.ARMOR_STAND);
            armorstand.setCustomName(ChatColor.LIGHT_PURPLE + "Je suis un magnifique holograme");
            armorstand.setCustomNameVisible(true);
            armorstand.setVisible(false);
            armorstand.setGravity(false);
            armorstand.setBodyPose(new EulerAngle(Math.toRadians(0), Math.toRadians(0), Math.toRadians(0)));

            ArmorStand armorstand2 = (ArmorStand) p.getWorld().spawnEntity(p.getLocation().add(0, -0.25, 0), EntityType.ARMOR_STAND);
            armorstand2.setCustomName(ChatColor.GOLD + "Je suis trop stylé");
            armorstand2.setCustomNameVisible(true);
            armorstand2.setVisible(false);
            armorstand2.setBodyPose(new EulerAngle(Math.toRadians(0), Math.toRadians(0), Math.toRadians(0)));
            armorstand2.setGravity(false);

        }

        return false;
    }
}
