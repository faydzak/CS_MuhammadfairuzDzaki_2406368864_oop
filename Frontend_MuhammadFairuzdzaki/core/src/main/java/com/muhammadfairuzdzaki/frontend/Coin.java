package com.muhammadfairuzdzaki.frontend;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Coin {
    private Vector2 position;
    private Rectangle collider;
    private float radius = 15.0f;
    private float bobOfset;
    private float bobSpeed;

    public Coin(Vector2 startPosition) {
        this.collider = new Rectangle();
    }

    public void update(float delta) {
        float bobOfset = bobSpeed * delta;
    }

    public void renderShape(ShapeRenderer shapeRenderer) {
        float drawY = position.y + (float) (Math.sin(bobOfset) * 5f);
        shapeRenderer.setColor(1f, 1f, 0f, 1f);
        shapeRenderer.circle(position.x, drawY, radius);
    }

    public void isColliding(Rectangle playerCollider) {
        if ()

    }
}
