package org.repanda.core;

import java.util.Arrays;
import java.util.OptionalInt;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;

/**
 *
 * @author Khaled BOUSSAIDI
 */
public class MathsTest {

    public int closestToZero(int[] ints) {
        if (ints == null || ints.length < 1) {
            return 0;
        }
        OptionalInt result = Arrays.stream(ints)
                .map(t -> {
                    return Math.abs(t);
                }).min();

        return result.getAsInt();
    }

    @Test
    @Disabled
    public void GivenListInteger_ThenReturnTheClosestToZero() {
        int[] test1 = {3, 4, 1, 12, 98, 10, 11}; // positive values
        assertEquals(1, closestToZero(test1));

        int[] test2 = {3, 4, 2, 12, 98, -2, -11}; // positive & negative values
        assertEquals(2, closestToZero(test2));

        assertEquals(0, closestToZero(null)); // null value

        int[] test3 = {};
        assertEquals(0, closestToZero(test3)); // emplty array
    }

    public int sumOfInts(int[] ints) {
        return Arrays.stream(ints)
                .filter(p -> (p >= 10 && p <= 100)) //intermediate operation using lambda expressions
                .sum(); // terminal operation
    }

    @Test
    public void GivenListInteger_ThenReturnTheSumofInts() {
        int[] ints = {2, 3, 50, 10, 100, 101};
        assertEquals(160, sumOfInts(ints));
    }

}
