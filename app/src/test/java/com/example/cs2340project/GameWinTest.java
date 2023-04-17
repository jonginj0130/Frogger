package com.example.cs2340project;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GameWinTest {

    @Test
    public void canRestart() {
        assertTrue(GameWin.canRestart());
    }

    @Test
    public void canExit() {
        assertTrue(GameWin.canExit());
    }

}
