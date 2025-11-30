package com.muhammadfairuzdzaki.frontend;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Coin {
    private Vector2 position;
    private Rectangle collider;
    private final float radius = 15f;
    private boolean active;
    private float bobOffset;
    private final float bobSpeed = 5f;

    public Coin(Vector2 startPosition) {
        this.position = startPosition;
        this.collider = new Rectangle(startPosition.x - radius, startPosition.y - radius, radius * 2, radius * 2);
        this.active = false;
        this.bobOffset = 0;
    }

    public void update(float delta) {
        bobOffset += bobSpeed * delta;
        collider.setPosition(position.x - radius, position.y - radius);
    }

    public void renderShape(ShapeRenderer shapeRenderer) {
        if (!active) return;

        float drawY = position.y + (float)(Math.sin(bobOffset) * 5f);

        shapeRenderer.setColor(1f, 1f, 0f, 1f);
        shapeRenderer.circle(position.x, drawY, radius);
    }

    public boolean isColliding(Rectangle playerCollider) {
        return active && collider.overlaps(playerCollider);
    }

    public void setPosition(float x, float y) { this.position.set(x, y); }
    public void setActive(boolean active) { this.active = active; }
    public boolean isActive() { return active; }
    public Rectangle getCollider() { return collider; }
    public Vector2 getPosition() { return position; }
    public float getRadius() { return radius; }
}
