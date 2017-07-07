package com.example.kata.poolballs;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static com.example.kata.poolballs.helper.SwapFactory.swap;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PoolBallShould {

    @Test
    public void apply_the_swaps_correctly() {
        assertThat(poolBalls("0", "1", "2").apply(swap(0, 1)), is(poolBalls("1", "0", "2")));
    }

    private PoolBall.Collection poolBalls(String... values) {
        PoolBall[] poolBalls = Arrays.stream(values).map(PoolBall::of).collect(Collectors.toList()).toArray(new PoolBall[0]);
        return PoolBall.Collection.of(poolBalls);
    }
}
