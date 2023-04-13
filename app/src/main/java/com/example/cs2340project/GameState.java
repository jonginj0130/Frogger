package com.example.cs2340project;

public class GameState {
    protected static String playerName;
    protected static String diff;
    private static int points;
    public GameState(String playerName, String diff) {
        this.playerName = playerName;
        this.diff = diff;
        this.points = 0;
    }
    public static String getDifficulty() {
        return diff;
    }
    public static String getPlayerName() {
        return playerName;
    }
    public static int getPoints() {
        return points;
    }
    public static void restart() {
        playerName = null;
        diff = null;
        points = 0;
    }
    public static void setPoints(int points) {
        GameState.points = points;
    }
}
