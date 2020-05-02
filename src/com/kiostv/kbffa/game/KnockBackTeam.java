package com.kiostv.kbffa.game;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.UUID;

public class KnockBackTeam {

    private String teamName;
    private String chatPrefix;
    private int teamSize;
    private ArrayList<UUID> members;
    private Location SpawnLocation;

    public KnockBackTeam(String teamName, String chatPrefix, int teamSize) {
        super();
        this.teamName = teamName;
        this.chatPrefix = chatPrefix;
        this.teamSize = teamSize;
        this.members = new ArrayList<>();
    }

    public String getTeamName(){
        return teamName;
    }

    public String getChatPrefix() {
        return chatPrefix;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public ArrayList<UUID> getMembers() {
        return members;
    }

    public boolean isTeamMember(Player p){
        return members.contains(p.getUniqueId());
    }

    public void setSpawnLocation(Location spawnLocation) {
        SpawnLocation = spawnLocation;
    }
}
