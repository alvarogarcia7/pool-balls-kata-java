package com.example.kata.poolballs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PoolBalls {
    private final List<PoolBall> values;

    public PoolBalls(PoolBall[] values) {
        this.values = Arrays.asList(values);
    }

    public int size() {
        return values.size();
    }

    public BallsInTheWrongPlace differenceTo(PoolBalls otherBalls) {
        List<Integer> wrongBallIndices = new ArrayList<>();
        for (int i = 0; i < otherBalls.size(); i++) {
            final PoolBall myBall = values.get(i);
            final PoolBall otherBall = otherBalls.values.get(i);

            if (!myBall.equals(otherBall)) {
                wrongBallIndices.add(i);
            }
        }

        return BallsInTheWrongPlace.at(wrongBallIndices.stream().map(PoolBallIndex::at).collect(Collectors.toList()).toArray(new PoolBallIndex[0]));

    }
}
