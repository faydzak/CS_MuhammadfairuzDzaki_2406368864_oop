package com.muhammadfairuzdzaki.frontend;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.muhammadfairuzdzaki.frontend.Observer.Observer;
import com.muhammadfairuzdzaki.frontend.Observer.ScoreManager;
import com.muhammadfairuzdzaki.frontend.service.BackendService;

public class GameManager {
    private static GameManager instance;
    private ScoreManager scoreManager;
    private BackendService backendService;
    private String get;

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
    // Assuming GameManager already has attributes: private BackendService backendService; private String currentPlayerId = null; private int coinsCollected = 0;

    public void registerPlayer(String username) {
        backendService.createPlayer(username, new BackendService.RequestCallback() {
            @Override
            public void onSuccess(String response) {
                try {
                    JsonValue json = new JsonReader().parse(response);
                    currentPlayerId = json.getString("playerId");
                    Gdx.app.log("GameManager", "Player ID: " + currentPlayerId);
                } catch (Exception e) {
                    Gdx.app.error("GameManager", "JSON Parse error");
                }
            }
            @Override
            public void onError(String error) {
                Gdx.app.error("GameManager", error);
            }
        });
    }

    public void endGame() {
        if (currentPlayerId == null) {
            Gdx.app.error("GameManager", "Cannot submit score: Player ID null");
            return;
        }

        int distance = scoreManager.getScore();
        int finalScore = distance + (coinsCollected * 10);

        backendService.submitScore(currentPlayerId, finalScore, coinsCollected, distance, new BackendService.RequestCallback() {
            @Override
            public void onSuccess(String response) {
                Gdx.app.log("GameManager", "Score Submitted: " + response);
            }
            @Override
            public void onError(String error) {
                Gdx.app.error("GameManager", "Score Submit Failed: " + error);
            }
        });
    }

    public void addCoin() {
        coinsCollected++;
        Gdx.app.log("GameManager", "COIN COLLECTED! Total: " + coinsCollected);
    }

    public int getCoins() { return coinsCollected; }
}
