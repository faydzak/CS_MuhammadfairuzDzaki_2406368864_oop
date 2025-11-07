package com.muhammadfairuzdzaki.frontend.obstacle;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class BaseObstacle {
    private Vector2 position;
    private Rectangle collider;
    private float length;
    private final float width = 10.0f;
    private boolean active = false;

    public  BaseObstacle(){
        position = new Vector2();
    }
    void render(ShapeRenderer shapeRenderer){
        if ()
    }
    public boolean isColliding(Rectangle playerCollider){
        if (active){
            return
        }
    }
    public boolean isActive(){
        return isActive();
    }
    public boolean isOffscreenCamera(float cameraLeftEdge){
        if (isOffscreenCamera()){

        }

    }
    public abstract void updateCollider(){

    }
    public abstract void drawShape(ShapeRenderer shapeRenderer){

    }
    public abstract float getRenderWidth(){

    }

    public void setActive(boolean active) {
    }
    public Vector2 setPosition(float x, float y){
        this.position = collider;
    }
    public Vector2 getPosition(){
        return position;
    }

}
