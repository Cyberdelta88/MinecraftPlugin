package fr.cyberdelta88.PluginMCtest.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Cmdgui implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            p.sendMessage(ChatColor.MAGIC + "DEBUG");

            Inventory gui = Bukkit.createInventory(p, 18, ChatColor.BLUE + "GUI");

            ItemStack suicide = new ItemStack(Material.TNT);
            ItemStack feed = new ItemStack(Material.COOKED_BEEF);
            ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
            ItemStack mystere = new ItemStack(Material.BARRIER);

            ItemMeta suicidemeta = suicide.getItemMeta();
            suicidemeta.setDisplayName(ChatColor.RED + "Suicide");
            ArrayList<String> suicide_lore = new ArrayList<>();
            suicide_lore.add("Ca tue hein");
            suicidemeta.setLore(suicide_lore);
            suicide.setItemMeta(suicidemeta);
            suicide.addUnsafeEnchantment(Enchantment.THORNS, 100);

            ItemMeta feedmeta = feed.getItemMeta();
            feedmeta.setDisplayName(ChatColor.RED + "Nourir");
            ArrayList<String> feed_lore = new ArrayList<>();
            feed_lore.add(ChatColor.GREEN + "Si tu as faim c'est ce qu'il faut faire");
            feed_lore.add("JAJ");
            feedmeta.setLore(feed_lore);
            feed.setItemMeta(feedmeta);

            ItemMeta swordmeta = sword.getItemMeta();
            swordmeta.setDisplayName(ChatColor.DARK_AQUA + "Avoir une épée");
            ArrayList<String> sword_lore = new ArrayList<>();
            sword_lore.add(ChatColor.BLUE + "Qu'est ce que tu veux que je dise");
            sword_lore.add(ChatColor.BLUE + "c'est juste une épée en diamant");
            swordmeta.setLore(sword_lore);
            sword.setItemMeta(swordmeta);

            ItemMeta mysteremeta = mystere.getItemMeta();
            mysteremeta.setDisplayName(ChatColor.GRAY + "Mystere");
            ArrayList<String> mystere_lore = new ArrayList<>();
            mystere_lore.add(ChatColor.MAGIC + "adafrgzaefefa eo aoeiufop");
            mystere_lore.add(ChatColor.MAGIC + "a aeiohfaoef");
            mysteremeta.setLore(mystere_lore);
            mystere.setItemMeta(mysteremeta);



            ItemStack[] guicontent = {suicide, feed, sword, mystere};
            gui.setContents(guicontent);

            p.openInventory(gui);
        }
        return true;
    }
}

//utiliser le "\n" pour retourner à la ligne