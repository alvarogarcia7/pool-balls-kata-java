package com.example.kata.poolballs;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;

@EqualsAndHashCode
@ToString
public class Swaps {
    private final List<Swap> values;

    private Swaps(Swap[] swaps) {
        this.values = Arrays.asList(swaps);
    }

    private Swaps() {
        this.values = Arrays.asList();
    }

    public static Swaps empty() {
        return new Swaps();
    }

    public static Swaps of(Swap... swaps) {
        return new Swaps(swaps);
    }
}
