package com.muhammadfairuzdzaki.frontend.Observer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ScoreUIObserver implements Observer {
    private final BitmapFont font;
    private int currentScore = 0; // Store score from update (optional)

    public ScoreUIObserver() {
        font = new BitmapFont();
        font.setColor(Color.WHITE);
        font.getData().setScale(2);
    }

    @Override
    public void update(int score) {
        this.currentScore = score;
    }
    public void render(SpriteBatch batch, int score) {
        batch.begin();
        String scoreText = "Distance: " + score + " m";
        font.draw(batch, scoreText, 20, Gdx.graphics.getHeight() - 20);
        batch.end();
    }

    public void dispose() {
        font.dispose();
    }
}
