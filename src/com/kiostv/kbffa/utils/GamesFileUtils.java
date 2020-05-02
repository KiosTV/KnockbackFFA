package com.kiostv.kbffa.utils;


import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GamesFileUtils {

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


}
