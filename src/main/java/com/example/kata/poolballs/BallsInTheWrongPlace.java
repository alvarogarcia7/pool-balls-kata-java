package com.example.kata.poolballs;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;

@EqualsAndHashCode
@ToString
public class BallsInTheWrongPlace {
    private List<PoolBallIndex> values;

    public BallsInTheWrongPlace(PoolBallIndex... values) {
        this.values = Arrays.asList(values);
    }

    public static BallsInTheWrongPlace at(PoolBallIndex... positions) {
        return new BallsInTheWrongPlace(positions);
    }

    public Swap firstSwap() {
        return Swap.of(values.get(0), values.get(1));
    }

    public int size() {
        return values.size();
    }
}
