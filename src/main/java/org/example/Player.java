package org.example;
import org.example.Character;

import java.util.ArrayList;

public class Player {
    private String playerName;
    private boolean isActive;
    private int round;
    private ArrayList<Character> team;

    public Player() {}

    public Player(String pname,boolean isActive,int round,ArrayList<Character> team) {
        this.playerName = pname;
        this.round = round;
        this.isActive = isActive;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public ArrayList<Character> getTeam() {
        return team;
    }

    public void setTeam(ArrayList<Character> team) {
        this.team = team;
    }
}
