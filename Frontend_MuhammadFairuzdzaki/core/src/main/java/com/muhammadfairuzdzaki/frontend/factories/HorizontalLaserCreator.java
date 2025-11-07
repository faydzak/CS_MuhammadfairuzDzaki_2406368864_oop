package com.muhammadfairuzdzaki.frontend.factories;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.muhammadfairuzdzaki.frontend.obstacle.BaseObstacle;
import com.muhammadfairuzdzaki.frontend.obstacle.HorizontalLaser;
import com.muhammadfairuzdzaki.frontend.Pools.HorizontalLaserPool;
import java.util.List;
import java.util.Random;

public class HorizontalLaserCreator implements ObstacleFactory.ObstacleCreator {

    private final HorizontalLaserPool pool;
    private static final float MIN_LENGTH = 100f;
    private static final float MAX_LENGTH = 300f;

    public HorizontalLaserCreator() {
        this.pool = new HorizontalLaserPool();
    }

    @Override
    public BaseObstacle create(float groundTopY, float spawnX, float playerHeight, Random rng) {
        int length = (int) (MIN_LENGTH + rng.nextFloat() * (MAX_LENGTH - MIN_LENGTH));

        float minY = groundTopY + playerHeight;
        float maxY = Gdx.graphics.getHeight() - playerHeight;

        float randomY = minY + rng.nextFloat() * (maxY - minY);

        return pool.obtain(new Vector2(spawnX, randomY), length);
    }

    @Override
    public void release(BaseObstacle obstacle) {
        if (obstacle instanceof HorizontalLaser) {
            pool.release((HorizontalLaser) obstacle);
        }
    }

    @Override
    public void releaseAll() {
        pool.releaseAll();
    }

    @Override
    public List<HorizontalLaser> getInUse() {
        return pool.getInUse();
    }

    @Override
    public boolean supports(BaseObstacle obstacle) {
        return obstacle instanceof HorizontalLaser;
    }

    @Override
    public String getName() {
        return "HorizontalLaser";
    }
}
