package com.example.kata.poolballs;

import java.util.Arrays;
import java.util.List;

public class Triangle {
    private List<PoolBall> balls;

    public Triangle(PoolBall... poolBalls) {
        this.balls = Arrays.asList(poolBalls);
    }

    public Swaps minimumSetOfSwaps() {
        if (this.balls.size() == 1) {
            return Swaps.empty();
        }
        return Swaps.of(Swap.of(0, 1));
    }
}
