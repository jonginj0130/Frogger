package com.example.cs2340project;

public class GameState {
    protected static String playerName;
    protected static String diff;
    public GameState(String playerName, String diff) {
        this.playerName = playerName;
        this.diff = diff;
    }
}
