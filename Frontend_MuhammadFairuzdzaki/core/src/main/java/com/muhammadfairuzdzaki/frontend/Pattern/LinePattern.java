package com.muhammadfairuzdzaki.frontend.Pattern;

import com.muhammadfairuzdzaki.frontend.Coin;
import com.muhammadfairuzdzaki.frontend.factories.CoinFactories;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LinePattern implements CoinPattern {
    private static final float SPACING = 40f;
    private final Random random = new Random();

    @Override
    public List<Coin> spawn(CoinFactories factory, float groundTopY, float spawnX, float screenHeight) {
        List<Coin> coins = new ArrayList<>();

        int count = 3 + random.nextInt(3);

        float minY = groundTopY + 50;
        float maxY = screenHeight - 100;
        float startY = minY + random.nextFloat() * (maxY - minY);

        for (int i = 0; i < count; i++) {
            Coin coin = factory.coinPool.obtain(spawnX + i * SPACING, startY);
            factory.getActiveCoins().add(coin);
            coins.add(coin);
        }
        return coins;
    }

    @Override
    public String getName() {
        return "Line";
    }
}
