package com.kiostv.kbffa.main;


import com.kiostv.kbffa.main.commands.KnockBackCommand;
import com.kiostv.kbffa.utils.FileUtils;
import com.kiostv.kbffa.utils.GameFileUtils;
import com.kiostv.kbffa.utils.Utils;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable(){
        FileUtils.setupFiles();
        GameFileUtils.setupFiles();

        if(!FileUtils.cfg.getString("Settings.MapName").equalsIgnoreCase("NONE")){
            //TODO Setup
        }

        registerCommands();

        Utils.sendConsole("Plugin started!");
        //TODO Plugin Start-logic
    }



    @Override
    public void onDisable(){
        Utils.sendConsole("Plugin started!");
        //TODO Plugin Stop-logic
    }

    private void registerCommands() {
        getCommand("kockbackffa").setExecutor(new KnockBackCommand());
    }

}
