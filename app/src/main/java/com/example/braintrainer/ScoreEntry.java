package com.example.braintrainer;

public class ScoreEntry {
    private int score;
    private int level;

    public void setScore(int score) {
        this.score = score;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getScore() {
        return score;
    }

    public int getLevel() {
        return level;
    }

    public ScoreEntry(int level, int score) {
        this.score = score;
        this.level = level;
    }
}
