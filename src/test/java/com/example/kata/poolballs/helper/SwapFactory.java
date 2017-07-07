package com.example.kata.poolballs.helper;

import com.example.kata.poolballs.PoolBall;
import com.example.kata.poolballs.Swap;

public class SwapFactory {
    public static Swap swap(int from, int to) {
        return Swap.of(PoolBall.Index.of(from), PoolBall.Index.of(to));
    }
}
