package com.kiostv.kbffa.game;

import org.bukkit.entity.Player;

import java.util.ArrayList;

public class GameManager {
    public static ArrayList<KnockBackTeam> teams = new ArrayList<>();

    public static KnockBackTeam getTeam(Player p){
        KnockBackTeam team = null;

        for (KnockBackTeam knockBackTeam : teams){
            if(knockBackTeam.isTeamMember(p)){
                team = knockBackTeam;
            }
        }

        return team;
    }
    public static KnockBackTeam getTeamByName(String name){
        KnockBackTeam team = null;

        for (KnockBackTeam knockBackTeam : teams){
            if(knockBackTeam.getTeamName().equalsIgnoreCase(name)){
                team = knockBackTeam;
            }
        }

        return team;
    }

}
