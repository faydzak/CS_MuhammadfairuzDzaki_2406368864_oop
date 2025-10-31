package com.muhammadfairuzdzaki.frontend;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

public class Main extends ApplicationAdapter {

    private ShapeRenderer shapeRenderer;
    private Rectangle box;
    private Ground ground;
    private player player;
    private GameManager gameManager;
    private OrthographicCamera camera;
    private float cameraoffset = 0.21f;


    @Override
    public void create() {
        shapeRenderer = new ShapeRenderer();

        gameManager = GameManager.getInstance();

        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.setToOrtho(false);

        player = new player(new Vector2(100, Gdx.graphics.getHeight() / 2f));

        ground = new Ground();

        gameManager.startGame();

    }

    @Override
    public void render() {
        float delta = Gdx.graphics.getDeltaTime();
        update(delta);

        ScreenUtils.clear(0.1f, 0.1f, 0.2f, 1f);
        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        ground.renderShape(shapeRenderer);
        player.renderShape(shapeRenderer);

        shapeRenderer.end();
    }
    private void update(float delta){
        boolean isFlying = Gdx.input.isKeyPressed(Input.Keys.SPACE);

        player.update(delta, isFlying);
        updateCamera(delta);
        ground.update(camera.position.x);

        float ceilingY = camera.position.y + camera.viewportHeight / 2f;
        player.checkBoundries(ground, ceilingY);

        int newScore = (int) player.getDistanceTraveled();
        if (newScore > gameManager.getScore()){
            gameManager.setScore(newScore);
        }
    }
    private void updateCamera(float delta){
        float cameraFocus = player.getPosition().x + (Gdx.graphics.getWidth() * cameraoffset);
        camera.position.x = cameraFocus;
        camera.update();
    }
    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }
}
