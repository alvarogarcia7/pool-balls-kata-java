package com.example.kata.poolballs;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TriangleShould {
    @Test
    public void is_empty_by_default() {
        Triangle triangle = new Triangle();

        assertThat(triangle.isEmpty(), is(true));
    }

    @Test
    public void is_not_empty_after_adding_balls() {
        Triangle triangle = new Triangle();

        triangle.addBall(PoolBall.of("Y"));

        assertThat(triangle.isEmpty(), is(false));
    }
}
