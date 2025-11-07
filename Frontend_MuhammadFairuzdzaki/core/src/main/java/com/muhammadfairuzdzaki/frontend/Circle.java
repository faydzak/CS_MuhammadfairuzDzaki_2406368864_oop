package com.muhammadfairuzdzaki.frontend;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Circle extends Shape {

    public Circle() {
        super();
        this.type = "Circle";
    }

    @Override
    public void render(ShapeRenderer shapeRenderer) {
        shapeRenderer.setColor(Color.CYAN);
        shapeRenderer.circle(position.x, position.y, size / 2);
    }
}
