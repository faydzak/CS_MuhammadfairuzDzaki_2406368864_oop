package com.muhammadfairuzdzaki.frontend.Pools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.muhammadfairuzdzaki.frontend.obstacle.VerticalLaser;

public class VerticalLaserPool extends ObjectPool<VerticalLaser> {

    private Vector2 defaultPosition = new Vector2(Gdx.graphics.getWidth(), 0);

    @Override
    protected VerticalLaser createObject() {
        return new VerticalLaser(defaultPosition, 100);
    }

    @Override
    protected void resetObject(VerticalLaser object) {
        object.initialize(defaultPosition, 100);
        object.setActive(false);
    }

    public VerticalLaser obtain(Vector2 position, int length) {
        VerticalLaser laser = super.obtain();
        laser.initialize(position, length);
        laser.setActive(true);
        return laser;
    }
}
