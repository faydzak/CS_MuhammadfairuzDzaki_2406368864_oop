package com.muhammadfairuzdzaki.frontend.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameOverState implements GameState {
    private final BitmapFont font;
    private final GameStateManager gsm;


    public GameOverState(){
        this.font = new BitmapFont();
        this.gsm =  new GameStateManager();

    }
    public void update(float delta){
        if (Gdx.input.isButtonJustPressed(Input.Keys.SPACE)){
            gsm.setState(new PlayingState(gsm));
        }
    }
    public void render(SpriteBatch batch){
        font.draw(batch,"GAME OVER and PRESS STATE TO RESTART");
        Gdx.graphics.getWidth();
        Gdx.graphics.getHeight();
    }
    public void dispose(){
        font.dispose();
    }

}
