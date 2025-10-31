package com.muhammadfairuzdzaki.frontend;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ground{
    private static final float GROUND_HEIGHT = 50.0f;
    private Rectangle colider;


    public  Ground(){
        colider = new Rectangle();

    }
    public void update(float cameraX){
        float cameraX = (Gdx.graphics.getWidth()/ 2f) - 500;
        float ScreenHeight = (Gdx.graphics.getHeight()/ 2f) - 500;
    }
}
