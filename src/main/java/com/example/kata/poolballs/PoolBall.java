package com.example.kata.poolballs;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.*;

@EqualsAndHashCode
@ToString
public class PoolBall {
    private String value;

    private PoolBall(String value) {
        this.value = value;
    }

    public static PoolBall of(String value) {
        return new PoolBall(value);
    }

    public static class PoolBalls {
        private final Map<Index, PoolBall> values;

        public PoolBalls(PoolBall[] values) {
            this.values = new HashMap<>();
            for(int i=0;i<values.length;i++) {
                Index index = Index.of(i);
                this.values.put(index, values[i]);
            }
        }

        private PoolBalls(Map<Index, PoolBall> balls) {
            values = balls;
        }

        public int size() {
            return values.entrySet().size();
        }

        public BallsInTheWrongPlace differenceTo(PoolBalls otherBalls) {
            Iterator<Map.Entry<Index, PoolBall>> iterator = otherBalls.values.entrySet().iterator();
            Iterator<Map.Entry<Index, PoolBall>> iteratorMine = values.entrySet().iterator();
            List<Index> wrongBallIndices = new ArrayList<>();
            while ( iterator.hasNext() && iteratorMine.hasNext()) {
                Map.Entry<Index, PoolBall> next = iteratorMine.next();
                final PoolBall myBall = next.getValue();
                final PoolBall otherBall = iterator.next().getValue();

                if (!myBall.equals(otherBall)) {
                    wrongBallIndices.add(next.getKey());
                }
            }

            return BallsInTheWrongPlace.at(wrongBallIndices.toArray(new Index[0]));

        }

        public PoolBalls apply(Swap swap) {
            Map<Index, PoolBall> balls = new HashMap<>(this.values);
            PoolBall from = balls.get(swap.getFrom());
            PoolBall to = balls.get(swap.getTo());

            balls.replace(swap.getFrom(), to);
            balls.replace(swap.getTo(), from);

            return new PoolBalls(balls);
        }

    }

    @ToString
    @EqualsAndHashCode
    public static class Index {
        private final int value;

        private Index(int value) {
            this.value = value;
        }

        public static Index of(int index) {
            return new Index(index);
        }
    }
}
