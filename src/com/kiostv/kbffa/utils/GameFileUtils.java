package com.kiostv.kbffa.utils;


import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GameFileUtils {

    public static File folder = new File("plugins/KnockBackFFA/");
    public static File file = new File("plugins/KnockBackFFA/data.yml");
    public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    public static void saveFiles(){
        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setupFiles(){
        if(!folder.exists()){
            folder.mkdir();

        }
        if(!file.exists()){
            try{
                file.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        cfg.addDefault("Maps", new ArrayList<>());
        cfg.options().copyDefaults(true);
        saveFiles();
    }

    public static void setLocation(String mapName, String name, Location loc){
        cfg.set("Locations." + mapName + "." + name + ".X", loc.getBlockX() + 0.5);
        cfg.set("Locations." + mapName + "." + name + ".Y", loc.getBlockY());
        cfg.set("Locations." + mapName + "." + name + ".Z", loc.getBlockZ() + 0.5);
        cfg.set("Locations." + mapName + "." + name + ".Yaw", Math.round(loc.getYaw() / 22.5 * 22.5));
        cfg.set("Locations." + mapName + "." + name + ".Pitch", Math.round(loc.getPitch() / 45 * 45));
        cfg.set("Locations." + mapName + "." + name + ".World", loc.getWorld().getName());
        saveFiles();
    }
    public static void setLocation(String name, Location loc){
        cfg.set("Locations." + name + ".X", loc.getBlockX() + 0.5);
        cfg.set("Locations." + name + ".Y", loc.getBlockY());
        cfg.set("Locations." + name + ".Z", loc.getBlockZ() + 0.5);
        cfg.set("Locations." + name + ".Yaw", Math.round(loc.getYaw() / 22.5 * 22.5));
        cfg.set("Locations." + name + ".Pitch", Math.round(loc.getPitch() / 45 * 45));
        cfg.set("Locations." + name + ".World", loc.getWorld().getName());
        saveFiles();
    }
    public static Location getBlockLocation(String mapName, String name){
        String mainPath = "Locations." + mapName + "." + name;

        Location loc = new Location(Bukkit.getWorld(cfg.getString(mainPath + ".World")), cfg.getDouble(mainPath + ".X"), cfg.getDouble(mainPath + ".Y"), cfg.getDouble(mainPath + ".Z"));
        loc.setPitch((float) cfg.getDouble(mainPath + ".Pitch"));
        loc.setYaw((float) cfg.getDouble(mainPath + ".Yaw"));
        return loc;
    }


    public static Location getLocation(String name) {
        String mainPath = "Locations." + "." + name;

        Location loc = new Location(Bukkit.getWorld(cfg.getString(mainPath + ".World")), cfg.getDouble(mainPath + ".X"), cfg.getDouble(mainPath + ".Y"), cfg.getDouble(mainPath + ".Z"));
        loc.setPitch((float) cfg.getDouble(mainPath + ".Pitch"));
        loc.setYaw((float) cfg.getDouble(mainPath + ".Yaw"));
        return loc;
    }
}
