package com.example.cs2340project;

import static org.junit.Assert.*;

import org.junit.Test;

// JUNIT BY SAGAR SADAK

public class ScoreTest {

    @Test
    public void moveForwardScoreTest() {
        Score score = new Score();
        score.increaseTilePassed();
        assertEquals(score.getScore(), 1);

        score.increaseTilePassed();
        score.increaseTilePassed();
        assertEquals(score.getScore(), 9);
    }

    @Test
    public void moveBackwardScoreTest() {
        Score score = new Score();
        score.increaseTilePassed();
        score.increaseTilePassed();
        assertEquals(score.getScore(), 4);
        score.increaseTilePassed();
        assertEquals(score.getScore(), 9);

        score.decreaseTilePassed();
        assertEquals(score.getScore(), 9);
        score.decreaseTilePassed();
        assertEquals(score.getScore(), 9);
    }
}