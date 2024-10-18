package junit.classwork.b.parameterized;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

// test class for Calculator.class method
class CalculatorTest {

    // declaration and initialisation of the class under test
    private static final Calculator CALCULATOR = new Calculator();

    // write a @ParameterizedTest that uses a "Csv file" as source of test data
    // provide valid data for Expected values (path c)
    @ParameterizedTest
    // provide the path for CSV file with test data
    @CsvFileSource(resources = "/square_integer_test_data.csv", useHeadersInDisplayName = true)
    // add test data as parameters to the test method
    void squaredIntegerHappyPath(int sqrResult, int inputData) {
        // write an "assertEquals()" assertion
        assertEquals(sqrResult, CALCULATOR.squareInteger(inputData));
    }

    // write a @ParameterizedTest that uses a "@ValueSource" as source of test data
    // provide valid data for INVALID values (Boundary values) (path b)
    @ParameterizedTest
    // provide the values
    @ValueSource(ints = {Integer.MAX_VALUE, Integer.MIN_VALUE, 46341, -46341, 0})
    // add test data as parameters to the test method
    void squaredIntegerInvalidBoundaryTest(int value) {
        // write an "assertThrows()" assertion
        assertThrows(RuntimeException.class, () -> CALCULATOR.squareInteger(value));
    }

    // write a @ParameterizedTest that uses a "@CsvSource" as source of test data
    // provide valid data for VALID values (Boundary values) (path c)
    @ParameterizedTest
    // provide the values
    @CsvSource({
            "46340,         2147395600",
            "-46340,        2147395600",
            "1,                      1",
            "-1,                     1"
    })
    // add test data as parameters to the test method
    void squareIntegerValidBoundaryTest(int inputValue, int expectedOutput) {
        // write an "assertEquals()" assertion
        assertEquals(expectedOutput, CALCULATOR.squareInteger(inputValue));
    }

    //TODO write a test for squareInteger() method with null as parameter (path a)
    @Test
    void squareIntegerValidBoundaryTestNullInput() {
        // write an "assertEquals()" assertion
        assertEquals(0, CALCULATOR.squareInteger(null));
    }

    //TODO write a @ParameterizedTest for cubeInteger() method
    // that uses a "Csv file" as source of test data
    // provide valid data for Expected values (path c)
    @ParameterizedTest
    // provide the path for CSV file with test data
    @CsvFileSource(resources = "/cube_integer_test_data.csv", useHeadersInDisplayName = true)
    // add test data as parameters to the test method
    void cubeIntegerHappyPath(int sqrResult, int inputData) {
        // write an "assertEquals()" assertion
        assertEquals(sqrResult, CALCULATOR.cubeInteger(inputData));
    }

    //TODO write a @ParameterizedTest for cubeInteger() method
    // that uses a "@ValueSource" as source of test data
    // provide valid data for INVALID values (Boundary values) (path b)
    // write a @ParameterizedTest that uses a "@ValueSource" as source of test data
    @ParameterizedTest
    // provide the values
    @ValueSource(ints = {Integer.MAX_VALUE, Integer.MIN_VALUE, 1291, -1291, 0})
    // add test data as parameters to the test method
    void cubeIntegerInvalidBoundaryTest(int value) {
        // write an "assertThrows()" assertion
        assertThrows(RuntimeException.class, () -> CALCULATOR.cubeInteger(value));
    }

    //TODO write a @ParameterizedTest for cubeInteger() method
    // that uses a "@CsvSource" as source of test data
    // provide valid data for VALID values (Boundary values) (path c)
    @ParameterizedTest
    // provide the values
    @CsvSource({
            "1290,         2146689000",
            "-1290,        -2146689000",
            "1,                      1",
            "-1,                     -1"
    })
    // add test data as parameters to the test method
    void cubeIntegerValidBoundaryTest(int inputValue, int expectedOutput) {
        // write an "assertEquals()" assertion
        assertEquals(expectedOutput, CALCULATOR.cubeInteger(inputValue));
    }

    //TODO write a test for cubeInteger() method with null as parameter (path a)
    @Test
    void cubeIntegerValidBoundaryTestNullInput() {
        // write an "assertEquals()" assertion
        assertEquals(0, CALCULATOR.cubeInteger(null));
    }
}