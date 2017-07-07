package com.example.kata.poolballs;

import com.example.kata.poolballs.helper.SwapFactory;
import org.hamcrest.Matcher;
import org.junit.Test;

import static com.example.kata.poolballs.PoolBall.of;
import static com.example.kata.poolballs.helper.SwapFactory.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TriangleShould {
    @Test
    public void get_the_swaps_for_a_correct_triangle() {
        Triangle triangle = Triangle.aNew()
                .arrangement(of("Y"))
                .current(of("Y"))
                .build();

        assertThat(triangle.minimumSetOfSwaps(), is(Swap.Collection.empty()));
    }

    @Test
    public void get_the_single_swap() {
        Triangle triangle = Triangle.aNew()
                .arrangement(poolBalls("YRY"))
                .current(poolBalls("RYY"))
                .build();

        assertThat(triangle.minimumSetOfSwaps(), isSwaps(swap(0, 1)));
    }

    @Test
    public void get_the_swaps_case_2() {
        Triangle triangle = Triangle.aNew()
                .arrangement(poolBalls("YRT"))
                .current(poolBalls("RTY"), of("R"), of("T"), of("Y"))
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

    private PoolBall.Collection poolBalls(String representation) {
        return PoolBallFactory.poolBalls(representation.split(""));
    }

    private Matcher<Swap.Collection> isSwaps(Swap... swaps) {
        return is(Swap.Collection.of(swaps));
    }

}
