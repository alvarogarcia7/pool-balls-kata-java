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
            return new Triangle(new PoolBall.Collection(arrangement), new PoolBall.Collection(currentArrangement));
        }
    }
}
