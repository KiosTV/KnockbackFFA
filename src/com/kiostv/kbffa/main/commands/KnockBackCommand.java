package com.kiostv.kbffa.main.commands;


import com.kiostv.kbffa.utils.GameFileUtils;
import com.kiostv.kbffa.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class KnockBackCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player){
            Player p = (Player) sender;

            if(p.hasPermission("knockback.setup")){
                if(args.length >= 1){
                    if (args[0].equalsIgnoreCase("setLobby")){
                        GameFileUtils.setLocation("Lobby", p.getLocation());

                        p.sendMessage(Utils.prefix + "&7 The position of the &eLobby &7 was saved &asuccessfully! ");
                    }else if (args.length >= 2){
                        if (args[0].equalsIgnoreCase("createmap")){
                            List<String> maps = GameFileUtils.cfg.getStringList("maps");
                            if(!(maps.contains(args[1].toUpperCase()))) {
                                maps.add(args[1].toUpperCase());
                                GameFileUtils.cfg.set("Maps", maps);

                                p.sendMessage(Utils.prefix + "&7 The Map &e" + args[1].toUpperCase() + " &7 was saved &asuccessfully! ");
                            }else {
                                p.sendMessage(Utils.prefix + "&7 The Map &e" + args[1].toUpperCase() + " &7 is already existing! ");
                            }

                        }
                        else if (args[0].equalsIgnoreCase("deletemap")){
                            List<String> maps = GameFileUtils.cfg.getStringList("maps");
                            if(maps.contains(args[1].toUpperCase())) {
                                maps.remove(args[1].toUpperCase());
                                GameFileUtils.cfg.set("Maps", maps);


                                String path = "Locations." + args[1].toUpperCase();
                                GameFileUtils.cfg.set(path, null);
                                GameFileUtils.saveFiles();

                                p.sendMessage(Utils.prefix + "&7 The Map &e" + args[1].toUpperCase() + " &7 was removed &asuccessfully! ");
                            }else {
                                p.sendMessage(Utils.prefix + "&7 The Map &4" + args[1].toUpperCase() + " &7 doesn't exist! ");
                            }

                        }
                        else if (args[0].equalsIgnoreCase("setspawn")) {
                            if (GameFileUtils.cfg.getStringList("Maps").contains(args[1].toUpperCase())){
                                GameFileUtils.setLocation(Utils.currentMap, "Spawn", p.getLocation());
                            }

                        }
                        else
                         {
                            sendHelp(p);
                            
                        }
                    }
                    else{
                        sendHelp(p);
                    }
                }
                else {
                    sendHelp(p);
                }
            }else{
                p.sendMessage(Utils.prefix + "&CYou do not have permission to perform that command!");
            }

        }else {
            Utils.sendConsole("&cOnly players can perform that command!");
        }

        return true;
    }

    private void sendHelp(Player p) {
        p.sendMessage(Utils.prefix + "&7/knockback createlobby");
        p.sendMessage(Utils.prefix + "&7/knockback createmap|deletemap <name>");
        p.sendMessage(Utils.prefix + "&7/knockback setspawn");
    }
}
