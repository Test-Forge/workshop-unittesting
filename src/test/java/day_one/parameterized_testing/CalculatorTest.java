package day_one.parameterized_testing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    Calculator calculator = new Calculator();

    // Expected values

    @Test
    public void squaredIntegerHappyPath() {

        assertEquals(9, calculator.squareInteger(3));
        assertEquals(100, calculator.squareInteger(10));
    }

    // Boundary values
    @ParameterizedTest
    @ValueSource(ints = {Integer.MAX_VALUE, Integer.MIN_VALUE, 46341, -46341, 0})
    public void squaredIntegerInvalidBoundaryTest(int value) {
        assertThrows(RuntimeException.class, () -> calculator.squareInteger(value));
    }

    @ParameterizedTest
    @CsvSource({
            "46340,         2147395600",
            "-46340,        2147395600",
            "1,                      1",
            "-1,                     1"
    })
    public void squareIntegerValidBoundaryTest(int inputValue, int expectedOutput) {
        assertEquals(expectedOutput, calculator.squareInteger(inputValue));
    }

}