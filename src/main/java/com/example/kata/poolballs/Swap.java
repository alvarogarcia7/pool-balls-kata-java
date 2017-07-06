package com.example.kata.poolballs;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Getter
public class Swap {
    private final PoolBallIndex from;
    private final PoolBallIndex to;

    public Swap(PoolBallIndex from, PoolBallIndex to) {
        this.from = from;
        this.to = to;
    }

    public static Swap of(PoolBallIndex from, PoolBallIndex to) {
        return new Swap(from, to);
    }
}
