package com.muhammadfairuzdzaki.frontend.Pattern;

import com.muhammadfairuzdzaki.frontend.Coin;
import com.muhammadfairuzdzaki.frontend.factories.CoinFactories;
import java.util.List;

public interface CoinPattern {
    List<Coin> spawn(CoinFactories factory, float groundTopY, float spawnX, float screenHeight);
    String getName();
}
