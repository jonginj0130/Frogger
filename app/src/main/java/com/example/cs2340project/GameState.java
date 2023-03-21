package com.example.cs2340project;

public class GameState {
    private static String playerName;
    private static String diff;

    private static int points = 0;
    public GameState(String playerName, String diff) {
        this.playerName = playerName;
        this.diff = diff;
    }
    public static String getDifficulty() {
        return diff;
    }
    public static int getPoints() {
        return points;
    }
    public static void setPoints(int points) {
        GameState.points = points;
    }
}
