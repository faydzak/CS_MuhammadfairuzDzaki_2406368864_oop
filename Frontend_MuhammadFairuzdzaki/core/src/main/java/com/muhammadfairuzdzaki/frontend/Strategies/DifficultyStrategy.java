package com.muhammadfairuzdzaki.frontend.Strategies;

import java.util.Map;

public interface DifficultyStrategy {

     Map<String, Integer> getObstacleWeights();
     float getSpawnInterval();
     int getDensity();
     float getMiniGap();
}
