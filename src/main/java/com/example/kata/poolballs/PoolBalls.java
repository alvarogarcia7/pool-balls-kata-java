package com.example.kata.poolballs;

import java.util.*;
import java.util.stream.Collectors;

public class PoolBalls {
    private final Map<PoolBallIndex, PoolBall> values;

    public PoolBalls(PoolBall[] values) {
        this.values = new HashMap<>();
        for(int i=0;i<values.length;i++) {
            PoolBallIndex index = PoolBallIndex.of(i);
            this.values.put(index, values[i]);
        }
    }

    private PoolBalls(Map<PoolBallIndex, PoolBall> balls) {
        values = balls;
    }

    public int size() {
        return values.entrySet().size();
    }

    public BallsInTheWrongPlace differenceTo(PoolBalls otherBalls) {
        Iterator<Map.Entry<PoolBallIndex, PoolBall>> iterator = otherBalls.values.entrySet().iterator();
        Iterator<Map.Entry<PoolBallIndex, PoolBall>> iteratorMine = values.entrySet().iterator();
        List<PoolBallIndex> wrongBallIndices = new ArrayList<>();
        while ( iterator.hasNext() && iteratorMine.hasNext()) {
            Map.Entry<PoolBallIndex, PoolBall> next = iteratorMine.next();
            final PoolBall myBall = next.getValue();
            final PoolBall otherBall = iterator.next().getValue();

            if (!myBall.equals(otherBall)) {
                wrongBallIndices.add(next.getKey());
            }
        }

        return BallsInTheWrongPlace.at(wrongBallIndices.toArray(new PoolBallIndex[0]));

    }

    public PoolBalls apply(Swap swap) {
        Map<PoolBallIndex, PoolBall> balls = new HashMap<>(this.values);
        PoolBall from = balls.get(swap.getFrom());
        PoolBall to = balls.get(swap.getTo());

        balls.replace(swap.getFrom(), to);
        balls.replace(swap.getTo(), from);

        return new PoolBalls(balls);
    }
}
