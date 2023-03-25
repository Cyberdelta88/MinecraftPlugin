package fr.cyberdelta88.PluginMCtest;

import fr.cyberdelta88.PluginMCtest.commands.*;
import fr.cyberdelta88.PluginMCtest.files.Customconfigfiles;
import fr.cyberdelta88.PluginMCtest.listeners.Clickguievent;
import fr.cyberdelta88.PluginMCtest.listeners.moove;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.*;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        System.out.println("Le serveur s'allume");

        this.getCommand("katana").setExecutor(new Cmdyoutube());
        this.getCommand("quoi").setExecutor(new Cmdquoi());
        this.getCommand("namemc").setExecutor(new Cmdnamemc());
        this.getCommand("gui").setExecutor(new Cmdgui());
        this.getCommand("testconfig").setExecutor(new Cmdtestsconfig());
        this.getCommand("setrdmdata").setExecutor(new CmdSetrdmdata());
        this.getCommand("troll").setExecutor(new Cmdtroll());
        this.getCommand("armorstand").setExecutor(new CmdArmorstand());
        this.getCommand("reloadconfig").setExecutor(new CmdReloadConfig());
        this.getCommand("animation").setExecutor(new CmdAnimation());

        getServer().getPluginManager().registerEvents(new DecoReco(), this);
        getServer().getPluginManager().registerEvents(new scoreboardtimer(), this);
        getServer().getPluginManager().registerEvents(new Clickguievent(), this);
        getServer().getPluginManager().registerEvents(new moove(), this);


        getConfig().options().copyDefaults();
        saveDefaultConfig();

        Customconfigfiles.setup();
        Customconfigfiles.getcustomfile().addDefault("message", "message par défaut");
        Customconfigfiles.getcustomfile().options().copyDefaults(true);
        Customconfigfiles.savecustomfile();

    }



    @Override
    public void onDisable() {
        System.out.println("Le serveur s'éteint");
    }

}


class DecoReco implements Listener {

    @EventHandler
    public void onPlayerJoinn(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        p.sendMessage(ChatColor.DARK_GREEN + "Bienvenue beau gosse !");
        Bukkit.broadcastMessage(ChatColor.GREEN + p.getName() + ChatColor.DARK_RED + " a rejoint le serveur !");
    }
    @EventHandler
    public void onPlayerJoinn(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        Bukkit.broadcastMessage(ChatColor.GREEN + p.getName() + ChatColor.DARK_RED + " a quitté le serveur !");
    }

    @EventHandler
    public void onPlayerJoinn(PlayerBedEnterEvent de) {
        Player p = de.getPlayer();
        p.sendMessage(ChatColor.LIGHT_PURPLE + "Bonne nuit");
    }

}

class scoreboardtimer implements Listener {

    @EventHandler
    public void onPlayerJoinn(PlayerJoinEvent e) {
        createScoreboard(e.getPlayer());
        updateScoreboard();
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        updateScoreboard();
    }

    public void createScoreboard(Player p) {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();
        Objective obj = board.registerNewObjective("Stats", "Dummy;");
        obj.setDisplayName("§6Infos");

        int timer = 0;

        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        Score score = obj.getScore("Nombre de joueurs : " + Bukkit.getOnlinePlayers().size());
        Score s2 = obj.getScore("");
        Score s3 = obj.getScore("Serveur de dev de Cyberdelta88");
        Score s4 = obj.getScore("Valeur : " + timer);

        score.setScore(1);
        s2.setScore(2);
        s3.setScore(3);
        s4.setScore(4);

        p.setScoreboard(board);


    }

    public void updateScoreboard() {
        for (Player online : Bukkit.getOnlinePlayers()) {
            Score score = online.getScoreboard().getObjective(DisplaySlot.SIDEBAR).getScore("Nombre de joueurs : " + Bukkit.getOnlinePlayers().size());
            score.setScore(1);

        }
    }

}
