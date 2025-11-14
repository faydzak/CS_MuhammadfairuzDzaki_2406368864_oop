package com.muhammadfairuzdzaki.frontend;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Player {
    private Vector2 position;
    private Vector2 velocity;
    private Vector2 acceleration;

    private static final float GRAVITY = -15f;
    private static final float FLY_ACCELERATION = 250f;
    private float width = 30f;
    private float height = 30f;
    private boolean isDead = false;
    private float distanceTraveled = 0;

    public Player(Vector2 position) {
        this.position = position;
        this.velocity = new Vector2(0, 0);
        this.acceleration = new Vector2(0, GRAVITY);
    }

    public void fly() {
        velocity.y = FLY_ACCELERATION;
    }

    public void update(float delta, boolean isTouching) {
        velocity.add(0, GRAVITY);
        position.mulAdd(velocity, delta);

        if (!isDead) {
            distanceTraveled += 10 * delta;
        }
    }

    public void renderShape(ShapeRenderer shapeRenderer) {
        shapeRenderer.rect(position.x, position.y, width, height);
    }

    public void checkBoundaries(Ground ground, float screenHeight) {
        if (position.y < ground.getTopY()) {
            position.y = ground.getTopY();
            velocity.y = 0;
        }
        if (position.y + height > screenHeight) {
            position.y = screenHeight - height;
            velocity.y = 0;
        }
    }

    public void die() {
        this.isDead = true;
    }

    public boolean isDead() {
        return isDead;
    }

    public void reset() {
        this.isDead = false;
        this.distanceTraveled = 0;
        this.velocity.set(0, 0);
    }

    public Vector2 getPosition() { return position; }
    public float getHeight() { return height; }
    public float getDistanceTraveled() { return distanceTraveled; }

    public Rectangle getCollider() {
        return new Rectangle(position.x, position.y, width, height);
    }
}

