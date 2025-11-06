package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Team {
    private String teamName;
    private int playerNum;
    private ArrayList<Character> characters = new ArrayList<>(){};
    public Team(String teamName, int playerNum,ArrayList<Character> characters) {
        this.teamName = teamName;
    }
    public Team() {}
}
