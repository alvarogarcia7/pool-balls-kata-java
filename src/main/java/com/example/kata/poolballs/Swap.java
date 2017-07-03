package com.example.kata.poolballs;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Swap {
    private final int from;
    private final int to;

    public Swap(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public static Swap of(int from, int to) {
        return new Swap(from, to);
    }
}
