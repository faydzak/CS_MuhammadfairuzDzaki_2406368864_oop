package com.muhammadfairuzdzaki.frontend.Pools;
import com.badlogic.gdx.math.Vector2;
import com.muhammadfairuzdzaki.frontend.Coin;

public class CoinPool extends ObjectPool<Coin> {

    CoinPool createObject = new Coin(new Vector2(0, 0));
    CoinPool resetObject =  Coin.set(Active(false));



}
