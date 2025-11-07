package com.muhammadfairuzdzaki.frontend;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class player {
    private Vector2 position;
    private Vector2 startPosition;
    private Rectangle collider;
    private Vector2 velocity;
    private float distanceTraveled;
    private boolean isDead;
    private float height = 50f;
    private float width = 50f;

    public player(Vector2 startPosition) {
        this.position = new Vector2(startPosition);
        this.startPosition = new Vector2(startPosition);
        this.collider = new Rectangle(position.x, position.y, width, height);
        this.velocity = new Vector2();
        this.distanceTraveled = 0;
        this.isDead = false;
    }

    public void update(float delta, boolean isFlying) {
        if (isDead) return;

        if (isFlying) {
            velocity.y = 300;
        } else {
            velocity.y -= 980 * delta;
        }
        position.add(velocity.x * delta, velocity.y * delta);
        position.x += 200 * delta;
        distanceTraveled = position.x / 10;

        collider.setPosition(position.x, position.y);
    }

    public void checkBoundaries(Ground ground, float screenHeight) {
        if (position.y < ground.getTopY()) {
            position.y = ground.getTopY();
            velocity.y = 0;
        }
    }

    public void die() {
        isDead = true;
        velocity.set(0, 0);
    }

    public void reset() {
        isDead = false;
        position.set(startPosition);
        velocity.set(0, 0);
        distanceTraveled = 0;
    }

    public boolean isDead() {
        return isDead;
    }

    public Vector2 getPosition() { return position; }
    public Rectangle getCollider() { return collider; }
    public float getHeight() { return height; }
    public float getDistanceTraveled() { return distanceTraveled; }
    public void render(ShapeRenderer shapeRenderer) {
        shapeRenderer.rect(position.x, position.y, width, height);
    }
}
