package com.muhammadfairuzdzaki.frontend.Strategies;

import com.muhammadfairuzdzaki.frontend.Coin;
import com.muhammadfairuzdzaki.frontend.factories.CoinFactories;
import java.util.List;
public interface CoinStrategies {
    List<Coin> spawn(CoinFactories factory, float groundTopY, float spawnX, float screenHeight);
    String getName();
}
