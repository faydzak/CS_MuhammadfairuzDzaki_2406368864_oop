package com.muhammadfairuzdzaki.frontend;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Background {
    private Texture backgroundTexture;
    private TextureRegion backgroundRegion;
    private float width;
    private float height;
    private float currentCameraX = 0f;

    public Background() {
        backgroundTexture = new Texture(Gdx.files.internal("background.png"));
        backgroundRegion = new TextureRegion(backgroundTexture);
        this.width = 2688f;
        this.height = 1536f;
    }

    public void update(float cameraX) {
        this.currentCameraX = cameraX;
    }

    public void render(SpriteBatch batch) {
        render(batch, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    public void render(SpriteBatch batch, float screenWidth, float screenHeight) {
        float scale = screenHeight / this.height;
        float scaledWidth = this.width * scale;
        float scaledHeight = this.height * scale;

        int startTile = (int) ((currentCameraX - screenWidth / 2) / scaledWidth);

        for (int i = -1; i <= 2; i++) {
            float drawX = (startTile + i) * scaledWidth;
            batch.draw(backgroundRegion, drawX, 0, scaledWidth, scaledHeight);
        }

    }

    public void dispose() {
        if (backgroundTexture != null) {
            backgroundTexture.dispose();
        }
    }
}
