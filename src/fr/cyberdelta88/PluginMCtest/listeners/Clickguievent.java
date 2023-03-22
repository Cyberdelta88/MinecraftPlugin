package fr.cyberdelta88.PluginMCtest.listeners;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class Clickguievent implements Listener {

    @EventHandler
    public void clickguievent(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();

        if (e.getClickedInventory().getName().equalsIgnoreCase(ChatColor.BLUE + "GUI")) {

            switch (e.getCurrentItem().getType()) {
                case TNT :
                    p.closeInventory();
                    p.setHealth(0.0);
                    p.sendMessage(ChatColor.AQUA + "Pourquoi faire" + "\n" + "Citation de Omar Sy");
                    break;
                case COOKED_BEEF:
                    p.closeInventory();
                    p.setFoodLevel(20);
                    break;
                case DIAMOND_SWORD:
                    p.closeInventory();
                    p.getInventory().addItem(new ItemStack(Material.DIAMOND_SWORD));
                    p.sendMessage("Fais gaffe c'est dangereux");
                case BARRIER:
                    p.closeInventory();
                    if (p.getGameMode().equals(GameMode.CREATIVE)) {
                        p.setGameMode(GameMode.SURVIVAL);
                    } else {
                        p.setGameMode(GameMode.CREATIVE);
                    }
            }


            e.setCancelled(true);
        }

    }
}
