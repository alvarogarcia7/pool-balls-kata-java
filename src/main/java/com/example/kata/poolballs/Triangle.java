package com.example.kata.poolballs;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
    private final PoolBalls finalArrangement;
    private final PoolBalls currentArrangement;

    private Triangle(PoolBalls finalArrangement, PoolBalls currentArrangement) {
        this.finalArrangement = finalArrangement;
        this.currentArrangement = currentArrangement;
    }

    public Swaps minimumSetOfSwaps() {
        List<Swap> swaps = new ArrayList<>();
        if (currentArrangement.size() == 1) {
            return Swaps.empty();
        }


        PoolBalls x = currentArrangement;
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
        return Swaps.of(swaps.toArray(new Swap[0]));

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
            return new Triangle(new PoolBalls(arrangement), new PoolBalls(currentArrangement));
        }
    }
}
