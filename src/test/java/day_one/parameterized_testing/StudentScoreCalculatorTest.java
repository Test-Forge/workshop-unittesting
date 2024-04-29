package day_one.parameterized_testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


class StudentScoreCalculatorTest {

    private StudentScoreCalculator sc;

    @BeforeEach
    public void initClass() {
        sc = new StudentScoreCalculator();
    }

    @ParameterizedTest
    @MethodSource("testValuesAsObjects")
    public void studentScoreCalculatorRegularTestWithObjectsAsValues(int mathScore, int literacyScore, int expectedResult) {
        sc.calculateSATScore(mathScore, literacyScore);
        assertEquals(expectedResult, sc.getSatScore());
    }

    @ParameterizedTest
    @MethodSource("testValuesFromStreams")
    public void studentScoreCalculatorRegularTestWithStreamsAsValues(int mathScore, int literacyScore, int expectedResult) {
        sc.calculateSATScore(mathScore, literacyScore);
        assertEquals(expectedResult, sc.getSatScore());
    }

    public void someShit(String input) {
        String smth = input.equals("A") ? "" : input.equals("B") ? " " : input.equals("C") ? "  " : input.equals("D") ? "    " : "          ";
    }

    private static Object[] testValuesAsObjects() {
        return new Object[]{
                new Object[]{50, 50, 2500},
                new Object[]{-10, 50, -1},
                new Object[]{50, -1, -1},
                new Object[]{-1, -1, -1},
                new Object[]{150, 50, -1},
                new Object[]{50, 150, -1},
                new Object[]{150, 150, -1},
                new Object[]{0, 0, 0},
                new Object[]{100, 100, 10000}
        };
    }

    static Stream<Arguments> testValuesFromStreams() {
        return Stream.of(
                Arguments.of(50, 50, 2500),
                Arguments.of(-10, 50, -1),
                Arguments.of(50, -1, -1),
                Arguments.of(-1, -1, -1),
                Arguments.of(150, 50, -1),
                Arguments.of(50, 150, -1),
                Arguments.of(150, 150, -1),
                Arguments.of(0, 0, 0),
                Arguments.of(100, 100, 10000)
        );
    }
}