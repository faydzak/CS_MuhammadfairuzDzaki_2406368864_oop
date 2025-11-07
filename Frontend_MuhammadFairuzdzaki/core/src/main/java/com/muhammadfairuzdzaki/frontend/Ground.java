package com.muhammadfairuzdzaki.frontend;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.Gdx;

public class Ground {
    private float topY = 50f;

    public void update(float cameraX) {
    }

    public void render(ShapeRenderer shapeRenderer) {
        shapeRenderer.rect(0, 0, Gdx.graphics.getWidth() * 10, topY);
    }

    public float getTopY() {
        return topY;
    }
}
