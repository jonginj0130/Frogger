package com.example.cs2340project;

public class Score {
    private int tilesPassed = 0;
    private int score = 0;

    public void increaseTilePassed() {
        tilesPassed++;
        score = tilesPassed * tilesPassed;
    }

    public void decreaseTilePassed() {
        tilesPassed--;
    }
    public int getTilesPassed() {
        return tilesPassed;
    }

    public int getScore() {
        return score;
    }
    public void setTilesPassed(int tilesPassed) {
        this.tilesPassed = tilesPassed;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
