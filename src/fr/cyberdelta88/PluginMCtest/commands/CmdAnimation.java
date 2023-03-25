package fr.cyberdelta88.PluginMCtest.commands;

import fr.cyberdelta88.PluginMCtest.Main;
import fr.cyberdelta88.PluginMCtest.runnable.animation;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class CmdAnimation implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;

            ArmorStand stand = (ArmorStand) p.getWorld().spawnEntity(p.getLocation(), EntityType.ARMOR_STAND);
            stand.setGravity(false);
            stand.setVisible(false);
            stand.setArms(true);
            stand.setItemInHand(new ItemStack(Material.GOLDEN_APPLE));

            Runnable animation;
            int animate = Bukkit.getScheduler().scheduleAsyncRepeatingTask(Main.getPlugin(Main.class), new animation(stand), 0, 1);



            new BukkitRunnable() {
                @Override
                public void run() {
                    Bukkit.getScheduler().cancelTask(animate);
                    stand.remove();
                }

            }.runTaskLater(Main.getPlugin(Main.class), 100);

        }

        return false;
    }
}
