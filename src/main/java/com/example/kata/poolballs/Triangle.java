package com.example.kata.poolballs;

import java.util.Arrays;
import java.util.List;

public class Triangle {
    private List<PoolBall> balls;

    public Triangle(PoolBall... poolBalls) {
        this.balls = Arrays.asList(poolBalls);
    }

    public Swaps minimumSetOfSwaps() {
        return Swaps.empty();
    }
}
