package com.muhammadfairuzdzaki.frontend.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameOverState implements GameState {
    private final BitmapFont font;
    private final GameStateManager gsm;


    public GameOverState(GameStateManager gsm){
        this.font = new BitmapFont();
        this.gsm =  gsm;

    }
    @Override
    public void update(float delta){
        if (Gdx.input.isButtonJustPressed(Input.Keys.SPACE)){
            gsm.set(new PlayingState(gsm));
        }
    }
    @Override
    public void render(SpriteBatch batch) {
        batch.begin();
        font.draw(batch, "GAME OVER", Gdx.graphics.getWidth() / 2f - 50, Gdx.graphics.getHeight() / 2f + 20);
        font.draw(batch, "Press SPACE to restart", Gdx.graphics.getWidth() / 2f - 80, Gdx.graphics.getHeight() / 2f - 20);
        batch.end();
    }
    @Override
    public void dispose(){
        font.dispose();
    }

}
