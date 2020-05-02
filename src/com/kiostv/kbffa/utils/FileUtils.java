package com.kiostv.kbffa.utils;


import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class FileUtils {

    public static File folder = new File("plugins/KnockBackFFA/");
    public static File file = new File("plugins/KnockBackFFA/config.yml");
    public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    public static void saveFiles(){
        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Utils.prefix = getConfigString("Messages.Prefix");

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
        cfg.addDefault("Messages.Prefix", "&8&b[Knock-Back FFA] &7");
        cfg.options().copyDefaults(true);
        saveFiles();
    }

    public static String getConfigString(String path){
        return cfg.getString(path).replace("&", "$");
    }

}
