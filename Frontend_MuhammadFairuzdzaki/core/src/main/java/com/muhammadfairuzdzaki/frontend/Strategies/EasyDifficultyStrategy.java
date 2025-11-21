package com.muhammadfairuzdzaki.frontend.Strategies;

import java.util.HashMap;
import java.util.Map;

public class EasyDifficultyStrategy implements DifficultyStrategy {
    @Override
    public Map<String, Integer> getObstacleWeights(){
        Map<String, Integer> weights = new HashMap<>();
        weights.put("VerticalLaser", 1);
        weights.put("HorizontalLaser", 1);
        return weights;
    }
    @Override
    public float getSpawnInterval(){
        return 1.5f;
    }
    @Override
    public float getMiniGap(){
        return 400f;
    }
    @Override
    public int getDensity(){
        return 1;
    }
}
