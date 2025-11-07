package com.muhammadfairuzdzaki.frontend.Pools;

import com.badlogic.gdx.math.Vector2;
import com.muhammadfairuzdzaki.frontend.obstacle.HomingMissile;

public class HomingMissilePool extends ObjectPool<HomingMissile> {

    private Vector2 defaultPosition = new Vector2(0, 0);

    @Override
    protected HomingMissile createObject() {
        return new HomingMissile(defaultPosition);
    }

    @Override
    protected void resetObject(HomingMissile object) {
        object.initialize(defaultPosition, 0);
        object.setTarget(null);
        object.setActive(false);
    }

    public HomingMissile obtain(Vector2 position) {
        HomingMissile missile = super.obtain();
        missile.initialize(position, 0);
        missile.setActive(true);
        return missile;
    }
}
