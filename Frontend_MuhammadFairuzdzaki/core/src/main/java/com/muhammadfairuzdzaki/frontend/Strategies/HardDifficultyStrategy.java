package com.muhammadfairuzdzaki.frontend.Strategies;

import java.util.HashMap;
import java.util.Map;

public class HardDifficultyStrategy implements DifficultyStrategy {

    @Override
    public Map<String, Integer> getObstacleWeights(){
        Map<String, Integer> weights = new HashMap<>();
        weights.put("VerticalLaser",  3);
        weights.put("HorizontalLaser", 3);
        weights.put("HomingMissile", 3);
        return weights;
    }
    @Override
    public float getSpawnInterval(){
        return 0.8f;
    }
    @Override
    public int getDensity(){
        return 3;
    }
    @Override
    public float getMiniGap(){
        return 200f;
    }
}
