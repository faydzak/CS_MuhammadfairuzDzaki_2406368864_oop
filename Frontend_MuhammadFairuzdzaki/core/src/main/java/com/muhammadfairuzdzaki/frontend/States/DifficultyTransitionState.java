package com.muhammadfairuzdzaki.frontend.States;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.muhammadfairuzdzaki.frontend.Strategies.DifficultyStrategy;

public class DifficultyTransitionState implements GameState {
    private final GameStateManager gsm;
    private final PlayingState playingState;
    private final DifficultyStrategy newStrategy;
    private final BitmapFont font;
    private float timer = 2.0f;

    // This constructor fixes the "Expected 3 arguments" error
    public DifficultyTransitionState(GameStateManager gsm, PlayingState playingState, DifficultyStrategy newStrategy) {
        this.gsm = gsm;
        this.playingState = playingState;
        this.newStrategy = newStrategy;
        this.font = new BitmapFont();
    }

    @Override
    public void update(float delta) {
        timer -= delta;
        if (timer <= 0) {
            playingState.setDifficulty(newStrategy);
            gsm.pop();
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        playingState.render(batch);

        batch.begin();
        font.draw(batch, "DIFFICULTY INCREASED!", 300, 400);

        font.draw(batch, newStrategy.getClass().getSimpleName(), 300, 350);
        batch.end();
    }

    @Override
    public void dispose() {
        font.dispose();
    }
}
