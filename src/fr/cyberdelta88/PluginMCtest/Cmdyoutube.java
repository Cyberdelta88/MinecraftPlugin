package fr.cyberdelta88.PluginMCtest;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Cmdyoutube implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            Inventory inv = p.getInventory();
            ItemStack kakatana = new ItemStack(Material.DIAMOND_SWORD, 8);
            ItemMeta metakatana = kakatana.getItemMeta();
            ArrayList<String> lore = new ArrayList<>();
            lore.add(ChatColor.STRIKETHROUGH + "lore1");
            lore.add(ChatColor.GREEN + "lore2");
            metakatana.setLore(lore);

            metakatana.setDisplayName("§1Katana de " + p.getName());
            metakatana.spigot().setUnbreakable(true);

            kakatana.setItemMeta(metakatana);

            p.sendMessage("§4Voici ton katana, fais en bon usage");
            inv.addItem(kakatana);
        }
        return true;
    }
}
