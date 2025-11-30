package com.muhammadfairuzdzaki.frontend.obstacle;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class BaseObstacle {
    protected Vector2 position;
    protected Rectangle collider;
    protected float width = 50f;
    protected float height = 50f;
    protected float speed = 300f;
    protected boolean active;

    public BaseObstacle(float spawnX, float spawnY) {
        this.position = new Vector2(spawnX, spawnY);
        this.collider = new Rectangle(position.x, position.y, width, height);
        this.active = true;
    }

    public void update(float delta) {
        position.x -= speed * delta;
        collider.setPosition(position.x, position.y);
    }

    public void renderShape(ShapeRenderer shapeRenderer) {
        if (!active) return;
        shapeRenderer.rect(collider.x, collider.y, collider.width, collider.height);
    }

    public void render(SpriteBatch batch) {
    }

    public void setInactive() {
        this.active = false;
    }

    public boolean isActive() {
        return active;
    }

    public Rectangle getCollider() {
        return collider;
    }

    public float getPositionX() {
        return position.x;
    }

    public boolean isTargetingPlayer() {
        return false;
    }
}
