package com.muhammadfairuzdzaki.frontend.factories;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.muhammadfairuzdzaki.frontend.obstacle.BaseObstacle;
import com.muhammadfairuzdzaki.frontend.obstacle.VerticalLaser;
import com.muhammadfairuzdzaki.frontend.Pools.VerticalLaserPool;
import java.util.List;
import java.util.Random;

public class VerticalLaserCreator implements ObstacleFactory.ObstacleCreator {

    private final VerticalLaserPool pool;
    private static final float MIN_HEIGHT = 100f;
    private static final float MAX_HEIGHT = 300f;

    public VerticalLaserCreator() {
        this.pool = new VerticalLaserPool();
    }

    @Override
    public BaseObstacle create(float groundTopY, float spawnX, float playerHeight, Random rng) {
        int height = (int) (MIN_HEIGHT + rng.nextFloat() * (MAX_HEIGHT - MIN_HEIGHT));

        float yPos = groundTopY;

        return pool.obtain(new Vector2(spawnX, yPos), height);
    }

    @Override
    public void release(BaseObstacle obstacle) {
        if (obstacle instanceof VerticalLaser) {
            pool.release((VerticalLaser) obstacle);
        }
    }

    @Override
    public void releaseAll() {
        pool.releaseAll();
    }

    @Override
    public List<VerticalLaser> getInUse() {
        return pool.getInUse();
    }

    @Override
    public boolean supports(BaseObstacle obstacle) {
        return obstacle instanceof VerticalLaser;
    }

    @Override
    public String getName() {
        return "VerticalLaser";
    }
}
