package com.example.kata.poolballs;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
    private List<PoolBall> balls;

    public Triangle() {
        this.balls = new ArrayList<>();
    }

    public boolean isEmpty() {
        return balls.isEmpty();
    }

    public void addBall(PoolBall poolBall) {
        balls.add(poolBall);
    }
}
