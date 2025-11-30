package com.muhammadfairuzdzaki.frontend.factories;

import com.muhammadfairuzdzaki.frontend.Coin;
import com.muhammadfairuzdzaki.frontend.Pools.CoinPool;
import java.util.ArrayList;
import java.util.List;

public class CoinFactory {
    public final CoinPool coinPool;
    private List<Coin> activeCoins;

    public CoinFactory() {
        this.coinPool = new CoinPool();
        this.activeCoins = new ArrayList<>();
    }

    public List<Coin> getActiveCoins() {
        return activeCoins;
    }

    public void releaseCoin(Coin coin) {
        if (activeCoins.remove(coin)) {
            coinPool.free(coin);
        }
    }

    public void releaseAll() {
        for(Coin coin : new ArrayList<>(activeCoins)) {
            releaseCoin(coin);
        }
        activeCoins.clear();
    }
}
