package fr.cyberdelta88.PluginMCtest.files;


import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Customconfigfiles {

    private static File file;
    private static FileConfiguration customfile;

    public static void setup() {
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("PluginMc_V1").getDataFolder(), "customconfig.yml");

        if (!file.exists()) {
            try{
                file.createNewFile();
            } catch (IOException e) {
                //caefafz
            }

        }
        customfile = YamlConfiguration.loadConfiguration(file);
    }
    public static FileConfiguration getcustomfile() {
        return customfile;
    }

    public static void savecustomfile() {
        try {
            customfile.save(file);
        } catch (IOException e) {
            System.out.println("failed");
        }
    }

    public static void reloadcustomfile() {
        customfile = YamlConfiguration.loadConfiguration(file);
    }
}
