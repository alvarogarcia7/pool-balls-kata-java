package com.example.kata.poolballs;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class PoolBallIndex {
    private final int value;

    private PoolBallIndex(int value) {
        this.value = value;
    }

    public static PoolBallIndex at(int value){
        return new PoolBallIndex(value);
    }

    public static PoolBallIndex of(int index) {
        return new PoolBallIndex(index);
    }
}
