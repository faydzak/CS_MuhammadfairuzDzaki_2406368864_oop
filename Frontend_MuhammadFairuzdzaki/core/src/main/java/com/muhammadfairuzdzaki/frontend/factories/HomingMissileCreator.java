package com.muhammadfairuzdzaki.frontend.factories;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.muhammadfairuzdzaki.frontend.obstacle.BaseObstacle;
import com.muhammadfairuzdzaki.frontend.obstacle.HomingMissile;
import com.muhammadfairuzdzaki.frontend.Pools.HomingMissilePool;
import java.util.List;
import java.util.Random;

public class HomingMissileCreator implements ObstacleFactory.ObstacleCreator {

    private final HomingMissilePool pool;

    public HomingMissileCreator() {
        this.pool = new HomingMissilePool();
    }

    @Override
    public BaseObstacle create(float groundTopY, float spawnX, float playerHeight, Random rng) {
        float spawnY = groundTopY + rng.nextFloat() * (Gdx.graphics.getHeight() - groundTopY);
        return pool.obtain(new Vector2(spawnX, spawnY));
    }

    @Override
    public void release(BaseObstacle obstacle) {
        if (obstacle instanceof HomingMissile) {
            pool.release((HomingMissile) obstacle);
        }
    }

    @Override
    public void releaseAll() {
        pool.releaseAll();
    }

    @Override
    public List<HomingMissile> getInUse() {
        return pool.getInUse();
    }

    @Override
    public boolean supports(BaseObstacle obstacle) {
        return obstacle instanceof HomingMissile;
    }

    @Override
    public String getName() {
        return "HomingMissile";
    }
}
