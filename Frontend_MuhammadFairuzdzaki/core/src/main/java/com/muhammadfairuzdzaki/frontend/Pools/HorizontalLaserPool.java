package com.muhammadfairuzdzaki.frontend.Pools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.muhammadfairuzdzaki.frontend.obstacle.HorizontalLaser;

public class HorizontalLaserPool extends ObjectPool<HorizontalLaser> {

    private Vector2 defaultPosition = new Vector2(Gdx.graphics.getWidth(), 0);

    @Override
    protected HorizontalLaser createObject() {
        return new HorizontalLaser(defaultPosition, 100);
    }

    @Override
    protected void resetObject(HorizontalLaser object) {
        object.initialize(defaultPosition, 100);
        object.setActive(false);
    }

    public HorizontalLaser obtain(Vector2 position, int length) {
        HorizontalLaser laser = super.obtain();
        laser.initialize(position, length);
        laser.setActive(true);
        return laser;
    }
}
