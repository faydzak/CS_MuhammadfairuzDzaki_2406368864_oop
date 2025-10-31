package com.muhammadfairuzdzaki.frontend;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ground{
    private static final float GROUND_HEIGHT = 50.0f;
    private Rectangle colider;


    public  Ground(){
        colider = new Rectangle(0, 0, Gdx.graphics.getWidth() * 2, GROUND_HEIGHT);

    }
    public void update(float cameraX){
        float xPos = cameraX - Gdx.graphics.getWidth()/ 2f - 500;
        float yPos = 0;
    }
    public boolean isColiding(Rectangle playercollider){
        return colider.overlaps(playercollider);
    }
    public float getTopY(){
        return GROUND_HEIGHT;
    }
    public void renderShape(ShapeRenderer shapeRenderer){
        shapeRenderer.setColor(0.5f, 0.5f, 0.5f, 1f);
        shapeRenderer.rect(colider.x, colider.y, colider.width, colider.height);
    }
}
