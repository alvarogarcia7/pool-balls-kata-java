package com.example.kata.poolballs;

public class PoolBall {
    private String value;

    private PoolBall(String value) {
        this.value = value;
    }

    public static PoolBall of(String value) {
        return new PoolBall(value);
    }
}
