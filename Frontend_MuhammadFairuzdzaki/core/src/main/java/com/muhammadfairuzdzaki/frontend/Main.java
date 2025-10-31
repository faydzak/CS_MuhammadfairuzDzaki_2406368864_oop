package com.muhammadfairuzdzaki.frontend;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class Main extends ApplicationAdapter {

    private ShapeRenderer shapeRenderer;
    private Rectangle box;

    private Color[] colors = {Color.RED, Color.YELLOW, Color.BLUE};
    private int currentColorIndex = 0;

    private static final float MOVE_SPEED = 300f;

    @Override
    public void create() {
        shapeRenderer = new ShapeRenderer();

        box = new Rectangle();
        box.width = 50;
        box.height = 50;

        box.x = (Gdx.graphics.getWidth() / 2f) - (box.width / 2f);
        box.y = (Gdx.graphics.getHeight() / 2f) - (box.height / 2f);
    }

    @Override
    public void render() {
        handleInput();

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        shapeRenderer.setColor(colors[currentColorIndex]);

        shapeRenderer.rect(box.x, box.y, box.width, box.height);

        shapeRenderer.end();
    }

    private void handleInput() {
        float deltaTime = Gdx.graphics.getDeltaTime();

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.A)) {
            box.x -= MOVE_SPEED * deltaTime;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D)) {
            box.x += MOVE_SPEED * deltaTime;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP) || Gdx.input.isKeyPressed(Input.Keys.W)) {
            box.y += MOVE_SPEED * deltaTime;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN) || Gdx.input.isKeyPressed(Input.Keys.S)) {
            box.y -= MOVE_SPEED * deltaTime;
        }

        if (Gdx.input.justTouched()) {
            currentColorIndex = (currentColorIndex + 1) % colors.length;

            String colorName = "";
            switch (currentColorIndex) {
                case 0: colorName = "RED"; break;
                case 1: colorName = "YELLOW"; break;
                case 2: colorName = "BLUE"; break;
            }
            Gdx.app.log("ColorChange", "Box color changed to: " + colorName);
        }

        if (box.x < 0) {
            box.x = 0;
        }
        if (box.x + box.width > Gdx.graphics.getWidth()) {
            box.x = Gdx.graphics.getWidth() - box.width;
        }
        if (box.y < 0) {
            box.y = 0;
        }
        if (box.y + box.height > Gdx.graphics.getHeight()) {
            box.y = Gdx.graphics.getHeight() - box.height;
        }
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }
}
