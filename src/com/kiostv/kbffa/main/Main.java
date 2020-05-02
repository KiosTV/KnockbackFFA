package com.kiostv.kbffa.main;


import com.kiostv.kbffa.utils.FileUtils;
import com.kiostv.kbffa.utils.GamesFileUtils;
import com.kiostv.kbffa.utils.Utils;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable(){
        FileUtils.setupFiles();
        GamesFileUtils.setupFiles();
        Utils.sendConsole("Plugin started!");
        //TODO Plugin Start-logic
    }

    @Override
    public void onDisable(){
        Utils.sendConsole("Plugin started!");
        //TODO Plugin Stop-logic
    }

}
