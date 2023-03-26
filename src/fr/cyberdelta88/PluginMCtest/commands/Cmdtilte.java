package fr.cyberdelta88.PluginMCtest.commands;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Cmdtilte implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;

            String text = "TITLE (bah oui hein)";
            IChatBaseComponent chatTitle = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + text + "\",color:" + ChatColor.GOLD.name().toLowerCase() + "}");

            PacketPlayOutTitle title = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, chatTitle);
            PacketPlayOutTitle length = new PacketPlayOutTitle(5, 20, 5);

            ((CraftPlayer) p).getHandle().playerConnection.sendPacket(title);
            ((CraftPlayer) p).getHandle().playerConnection.sendPacket(length);
        }

        return false;
    }
}
