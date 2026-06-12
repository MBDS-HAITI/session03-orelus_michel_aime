package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a player and their team of three characters.
 */
public class Player {

    private final String name;
    private final List<Character> team = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public void addCharacter(Character character) {
        team.add(character);
    }

    /** Returns true when every character in the team is dead. */
    public boolean isDefeated() {
        return team.stream().noneMatch(Character::isAlive);
    }

    public List<Character> getTeam() {
        return team;
    }

    public String getName() {
        return name;
    }

    /** Returns only the living members of the team. */
    public List<Character> getAliveCharacters() {
        return team.stream().filter(Character::isAlive).toList();
    }

    public void printTeamStatus() {
        for (Character c : team) {
            System.out.println("  " + c);
        }
    }
}
