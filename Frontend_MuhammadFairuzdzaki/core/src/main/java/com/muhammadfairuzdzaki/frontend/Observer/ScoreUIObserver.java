package com.muhammadfairuzdzaki.frontend.Observer;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ScoreUIObserver implements Observer {
    private BitmapFont font;
    private SpriteBatch batch;

    public ScoreUIObserver() {
        font = new BitmapFont();
        font.setColor(Color.WHITE);
        batch = new SpriteBatch();
    }

    @Override
    public void update(int score) {
        System.out.println("Score updated: " + score);
    }

    public void render(int score, float cameraX, float cameraY, float screenWidth, float screenHeight) {
        batch.begin();
        float drawX = cameraX - screenWidth / 2f + 20;
        float drawY = cameraY + screenHeight / 2f - 20;
        font.draw(batch, "Score: " + score, drawX, drawY);
        batch.end();
    }

    public void dispose() {
        if (font != null) font.dispose();
        if (batch != null) batch.dispose();
    }
}
