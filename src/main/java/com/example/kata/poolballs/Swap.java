package com.example.kata.poolballs;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;

@EqualsAndHashCode
@ToString
@Getter
public class Swap {
    private final PoolBall.Index from;
    private final PoolBall.Index to;

    public Swap(PoolBall.Index from, PoolBall.Index to) {
        this.from = from;
        this.to = to;
    }

    public static Swap of(PoolBall.Index from, PoolBall.Index to) {
        return new Swap(from, to);
    }

    @EqualsAndHashCode
    @ToString
    public static class Swaps {
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
}
