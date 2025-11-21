package com.muhammadfairuzdzaki.frontend.Strategies;
import java.util.HashMap;
import java.util.Map;

public class MediumDifficultyStrategy implements DifficultyStrategy {

    @Override
    public Map<String, Integer> getObstacleWeights() {
        Map<String, Integer> weights = new HashMap<>();
        weights.put("VerticalLaser", 2);
        weights.put("HorizontalLaser", 2);
        weights.put("HomingMissile", 1);
        return weights;
    }

    @Override
    public float getSpawnInterval() {

        return 1.1f;
    }

    @Override
    public int getDensity() {
        return 2;
    }

    @Override
    public float getMiniGap() {
        return 300f;
    }
}

