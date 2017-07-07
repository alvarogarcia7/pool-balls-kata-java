package com.example.kata.poolballs;

import org.hamcrest.Matcher;
import org.junit.Test;

import static com.example.kata.poolballs.PoolBall.of;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TriangleShould {
    @Test
    public void get_the_swaps_for_a_correct_triangle() {
        Triangle triangle = Triangle.aNew()
                .arrangement(of("Y"))
                .current(of("Y"))
                .build();

        assertThat(triangle.minimumSetOfSwaps(), is(Swap.Swaps.empty()));
    }

    @Test
    public void get_the_single_swap() {
        Triangle triangle = Triangle.aNew()
                .arrangement(of("Y"), of("R"), of("Y"))
                .current(of("R"), of("Y"), of("Y"))
                .build();

        assertThat(triangle.minimumSetOfSwaps(), isSwaps(swap(0, 1)));
    }

    @Test
    public void get_the_swaps_case_2() {
        Triangle triangle = Triangle.aNew()
                .arrangement(of("Y"), of("R"), of("T"))
                .current(of("R"), of("T"), of("Y"))
                .build();

        assertThat(triangle.minimumSetOfSwaps(), isSwaps(swap(0, 1), swap(0, 2)));
    }

    @Test
    public void get_the_swaps_case_3() {
        Triangle triangle = Triangle.aNew()
                .arrangement(of("Y"), of("R"), of("T"), of("K"), of("F"))
                .current(of("R"), of("K"), of("T"), of("F"), of("Y"))
                .build();

        assertThat(triangle.minimumSetOfSwaps(), isSwaps(swap(0, 1), swap(0, 3), swap(0, 4)));
    }

    private Matcher<Swap.Swaps> isSwaps(Swap... swaps) {
        return is(Swap.Swaps.of(swaps));
    }

    private Swap swap(int from, int to) {
        return Swap.of(PoolBall.PoolBallIndex.of(from), PoolBall.PoolBallIndex.of(to));
    }
}
