package com.example.kata.poolballs;

import org.junit.Test;

import static com.example.kata.poolballs.PoolBall.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TriangleShould {
    @Test
    public void get_the_swaps_for_a_correct_triangle() {
        Triangle triangle = Triangle.aNew()
                .arrangement(of("Y"))
                .current(of("Y"))
                .build();

        assertThat(triangle.minimumSetOfSwaps(), is(Swaps.empty()));
    }

    @Test
    public void get_the_single_swap() {
        Triangle triangle = Triangle.aNew()
                .arrangement(of("Y"), of("R"), of("Y"))
                .current(of("R"), of("Y"), of("Y"))
                .build();

        assertThat(triangle.minimumSetOfSwaps(), is(Swaps.of(Swap.of(0, 1))));
    }

    @Test
    public void get_the_swaps_case_2() {
        Triangle triangle = Triangle.aNew()
                .arrangement(of("Y"), of("R"), of("T"))
                .current(of("R"), of("T"), of("Y"))
                .build();

        assertThat(triangle.minimumSetOfSwaps(), is(Swaps.of(Swap.of(0, 1), Swap.of(0, 2))));
    }
}
