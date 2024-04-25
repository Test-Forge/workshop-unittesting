package day_one.before_and_different_assertion_types;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicTests {

    private Basics basicTests;
    @BeforeEach
    public void setup() {
        basicTests = new Basics();
    }
    @Test
    public void compare() {
        int value = basicTests.compare(2, 1);
        assertEquals(1, value);
    }

    @Test
    @DisplayName("First number is less than the second")
    public void compare2() {
        int value = basicTests.compare(2, 3);
        assertEquals(-1, value);
    }

    @Test
    @DisplayName("First number is equal to the second")
    public void compare3() {
        int value = basicTests.compare(2, 2);
        assertEquals(0, value);
    }

    @Test
    @DisplayName("Array sorted")
    public void sortArray() {
        int[] array = {5, 8, 3, 9, 1, 6};
        basicTests.sortArray(array);
        assertArrayEquals(new int[]{1, 3, 5, 6, 8, 9}, array);
    }

}