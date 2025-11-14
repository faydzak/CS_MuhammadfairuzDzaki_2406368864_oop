package com.muhammadfairuzdzaki.frontend;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ground {
    private static final float HEIGHT = 100f;
    private float x;
    private float width = 5000f;

    public Ground() {
        this.x = 0;
    }

    public void update(float cameraX) {
        this.x = cameraX - width / 2;
    }

    public void renderShape(ShapeRenderer shapeRenderer) {
        shapeRenderer.setColor(Color.GREEN);
        shapeRenderer.rect(x, 0, width, HEIGHT);
    }

    public float getTopY() {
        return HEIGHT;
    }
}
