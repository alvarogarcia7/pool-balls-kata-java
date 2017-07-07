package com.example.kata.poolballs;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
    private final PoolBall.Collection finalArrangement;
    private final PoolBall.Collection currentArrangement;

    private Triangle(PoolBall.Collection finalArrangement, PoolBall.Collection currentArrangement) {
        this.finalArrangement = finalArrangement;
        this.currentArrangement = currentArrangement;
    }

    public Swap.Collection minimumSetOfSwaps() {
        List<Swap> swaps = new ArrayList<>();
        if (currentArrangement.size() == 1) {
            return Swap.Collection.empty();
        }


        PoolBall.Collection x = currentArrangement;
        BallsInTheWrongPlace wrongBalls;
        do {
            wrongBalls = finalArrangement.differenceTo(x);
            if (wrongBalls.size() > 1) {
                Swap swap = wrongBalls.firstSwap();
                swaps.add(swap);
                x = x.apply(swap);
            } else {
                break;
            }
        } while (true);
        return Swap.Collection.of(swaps.toArray(new Swap[0]));

    }

    public static TriangleBuilder aNew() {
        return new TriangleBuilder();
    }

    public static class TriangleBuilder {
        private PoolBall.Collection finalArrangement;
        private PoolBall.Collection currentArrangement;

        public TriangleBuilder arrangement(PoolBall.Collection poolBalls, PoolBall... arrangement) {
            finalArrangement = new PoolBall.Collection(arrangement);
            assert finalArrangement.equals(poolBalls);
            return this;
        }

        public TriangleBuilder arrangement(PoolBall.Collection poolBalls) {
            finalArrangement = poolBalls;
            return this;
        }

        public TriangleBuilder arrangement(PoolBall... arrangement) {
            finalArrangement = new PoolBall.Collection(arrangement);
            return this;
        }

        public TriangleBuilder current(PoolBall... currentArrangement) {
            this.currentArrangement = new PoolBall.Collection(currentArrangement);
            return this;
        }

        public Triangle build() {
            return new Triangle(finalArrangement, currentArrangement);
        }

        public TriangleBuilder current(PoolBall.Collection poolBalls, PoolBall... arrangement) {
            currentArrangement = new PoolBall.Collection(arrangement);
            assert currentArrangement.equals(poolBalls);
            return this;
        }

        public TriangleBuilder current(PoolBall.Collection poolBalls) {
            this.currentArrangement = poolBalls;
            return this;
        }
    }
}
