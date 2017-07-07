package com.example.kata.poolballs;

import java.util.Arrays;
import java.util.stream.Collectors;

public class PoolBallFactory {
    static PoolBall.Collection poolBalls(String... values) {
        PoolBall[] poolBalls = Arrays.stream(values).map(PoolBall::of).collect(Collectors.toList()).toArray(new PoolBall[0]);
        return PoolBall.Collection.of(poolBalls);
    }
}
