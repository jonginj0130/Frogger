package com.example.cs2340project;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * GameStateInitializationTest ensures that the GameState class is properly initialized.
 *
 * Name and Diff parameters passed into the context must match the instance.name and
 * instance.diff values.
 *
 * Ensures that all difficulties can exist.
 *
 * Made by Race Williams.
 */
public class GameStateInitializationTest {

    @Test
    public void GameStateEasyTest() {
        String diffValue = "easy";
        String playerName = "playerName";
        GameState state = new GameState(playerName, diffValue);
        assertEquals(diffValue, state.diff);
    }

    @Test
    public void GameStateMediumTest() {
        String diffValue = "medium";
        String playerName = "playerName";
        GameState state = new GameState(playerName, diffValue);
        assertEquals(diffValue, state.diff);
    }

    @Test
    public void GameStateHardTest() {
        String diffValue = "hard";
        String playerName = "playerName";
        GameState state = new GameState(playerName, diffValue);
        assertEquals(diffValue, state.diff);
    }
}