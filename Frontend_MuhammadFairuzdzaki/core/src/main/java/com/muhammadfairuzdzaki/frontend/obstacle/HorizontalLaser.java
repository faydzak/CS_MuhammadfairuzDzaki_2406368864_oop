package com.muhammadfairuzdzaki.frontend.obstacle;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class HorizontalLaser extends BaseObstacle {

    public HorizontalLaser(Vector2 startPosition, int length){
    }
    @Override
    public void initialize(Vector2 startPosition, int length){

    }
    @Override
    public void updateCollider(){
        collider = new Rectangle(position.x, position.y);
    }
    @Override
    public void drawShape(ShapeRenderer shapeRenderer){

    }
    @Override
    public float getRenderWidth(){

    }

}
