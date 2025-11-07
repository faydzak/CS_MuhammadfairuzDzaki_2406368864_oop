package com.muhammadfairuzdzaki.frontend;

public class GameManager {
    private static final GameManager instance = new GameManager();
    private int score;

    private GameManager() {}

    public static GameManager getInstance() {
        return instance;
    }

    public void startGame() {
        score = 0;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
