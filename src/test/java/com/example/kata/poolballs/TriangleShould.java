package com.example.kata.poolballs;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TriangleShould {
    @Test
    public void get_the_swaps_() {
        Triangle triangle = new Triangle(PoolBall.of("Y"));

        assertThat(triangle.minimumSetOfSwaps(), is(Swaps.empty()));
    }
}
