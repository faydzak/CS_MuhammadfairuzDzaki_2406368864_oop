package com.muhammadfairuzdzaki.frontend.obstacle;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.muhammadfairuzdzaki.frontend.player;

public class HomingMissile extends BaseObstacle {

    private player target;
    private Vector2 velocity;
    private float speed = 200f;
    private float width = 40f;
    private float height = 20f;

    private Vector2 targetPosition = new Vector2();

    public HomingMissile(Vector2 startPosition) {
        super(startPosition, 0);
        this.velocity = new Vector2();
    }

    @Override
    public void initialize(Vector2 startPosition, int length) {
        super.initialize(startPosition, length);
        this.velocity.set(0, 0);
        this.target = null;
    }

    public void setTarget(player target) {
        this.target = target;
    }

    public boolean isTargetingPlayer() {
        if (target == null) {
            return false;
        }

        float targetCenterX = target.getPosition().x + target.getCollider().width / 2;
        float missileCenterX = position.x + width / 2;

        return missileCenterX > targetCenterX;
    }

    public void update(float delta) {
        if (target == null || !active) {
            return;
        }

        if (isTargetingPlayer()) {
            targetPosition.set(
                target.getPosition().x + target.getCollider().width / 2,
                target.getPosition().y + target.getCollider().height / 2
            );

            velocity.set(targetPosition).sub(position.x + width/2, position.y + height/2).nor().scl(speed);

            position.x += velocity.x * delta;
            position.y += velocity.y * delta;

            updateCollider();
        }
    }

    @Override
    protected void updateCollider() {
        collider.set(position.x, position.y, width, height);
    }

    @Override
    protected void drawShape(ShapeRenderer shapeRenderer) {
        shapeRenderer.rect(position.x, position.y, width, height);
    }

    @Override
    public float getRenderWidth() {
        return width;
    }
}
