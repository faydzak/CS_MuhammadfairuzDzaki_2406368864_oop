package com.muhammadfairuzdzaki.frontend;

import com.muhammadfairuzdzaki.frontend.Observer.Observer;
import com.muhammadfairuzdzaki.frontend.Observer.ScoreManager;
import com.muhammadfairuzdzaki.frontend.service.BackendService;

public class GameManager {
    private static GameManager instance;
    private ScoreManager scoreManager;
    private BackendService backendService;
    private String get

    private GameManager() {
        scoreManager = new ScoreManager();
    }

    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public void setScore(int newScore) {
        scoreManager.setScore(newScore);
    }

    public int getScore() {
        return scoreManager.getScore();
    }

    public void addObserver(Observer observer) {
        scoreManager.addObserver(observer);
    }

    public void removeObserver(Observer observer) {
        scoreManager.removeObserver(observer);
    }

    public void startGame() {
        // Implementation
    }
}
