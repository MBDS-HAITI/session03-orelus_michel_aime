package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Team {
    private String teamName;
    private int playerNum;
    private ArrayList<Character> characterList = new ArrayList<>(){};
    public Team(String teamName, int playerNum,ArrayList<Character> characterList) {
        this.teamName = teamName;
    }
    public Team() {}
}
