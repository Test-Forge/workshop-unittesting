package day_one.parameterized_testing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    Calculator calculator = new Calculator();

    // Expected values
    @ParameterizedTest
    @CsvFileSource(resources = "/square_integer_test_data.csv", useHeadersInDisplayName = true)
    public void squaredIntegerHappyPath(int sqrResult, int inputData) {
        assertEquals(sqrResult, calculator.squareInteger(inputData));
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

    @Test
    public void squareIntegerValidBoundaryTestNullInput() {
        assertEquals(0, calculator.squareInteger(null));
    }

}