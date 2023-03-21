package com.example.cs2340project;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GameStateTest {
    GameState gameState = new GameState("Jongin", "Easy");

    @Test
    public void checkInitialPoints() {
        assertEquals((gameState.getPoints()), 0);
    }

    @Test
    public void checkDifficulty() {
        assertEquals((GameState.getDifficulty()), "Easy");
    }

    @Test
    public void checkPlayerName() {
        assertEquals((GameState.getPlayerName()), "Jongin");
    }

    @Test
    public void checkSetPoints() {
        gameState.setPoints(200);
        assertEquals((gameState.getPoints()), 200);
    }

    @Test
    public void checkRestart() {
        gameState.restart();
        assertEquals((gameState.getPoints()), 0);
    }


}
