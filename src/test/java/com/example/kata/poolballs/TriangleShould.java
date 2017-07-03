package com.example.kata.poolballs;

import org.junit.Test;

import static com.example.kata.poolballs.PoolBall.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TriangleShould {
    @Test
    public void get_the_swaps_for_a_correct_triangle() {
        Triangle triangle = new Triangle(of("Y"));

        assertThat(triangle.minimumSetOfSwaps(), is(Swaps.empty()));
    }

    @Test
    public void get_the_single_swap() {
        Triangle triangle = new Triangle(of("R"), of("Y"), of("Y"));

        assertThat(triangle.minimumSetOfSwaps(), is(Swaps.of(Swap.of(0, 1))));
    }
}
