package com.example.kata.poolballs;

import java.util.Arrays;
import java.util.List;

public class Triangle {
    private final List<PoolBall> finalArrangement;
    private List<PoolBall> balls;

    private Triangle(PoolBall[] finalArrangement, PoolBall[] currentArrangement) {
        this.finalArrangement = Arrays.asList(finalArrangement);
        this.balls = Arrays.asList(currentArrangement);
    }

    public Swaps minimumSetOfSwaps() {
        if (this.balls.size() == 1) {
            return Swaps.empty();
        }
        return Swaps.of(Swap.of(0, 1));
    }

    public static TriangleBuilder aNew() {
        return new TriangleBuilder();
    }

    public static class TriangleBuilder {
        private PoolBall[] arrangement;
        private PoolBall[] currentArrangement;

        public TriangleBuilder arrangement(PoolBall... arrangement) {
            this.arrangement = arrangement;
            return this;
        }

        public TriangleBuilder current(PoolBall... currentArrangement) {
            this.currentArrangement = currentArrangement;
            return this;
        }

        public Triangle build() {
            return new Triangle(arrangement, currentArrangement);
        }
    }
}
