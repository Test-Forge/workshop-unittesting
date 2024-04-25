package day_one.parameterized_testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;


class StudentScoreCalculatorTest {

    private StudentScoreCalculator sc;

    @BeforeEach
    public void initClass() {
        sc = new StudentScoreCalculator();
    }

    @ParameterizedTest
    @MethodSource("testValues")
    public void studentScoreCalculatorRegularTest(int mathScore, int literacyScore, int expectedResult) {
        sc.calculateSATScore(mathScore, literacyScore);
        assertEquals(expectedResult, sc.getSatScore());
    }

    private static Object[] testValues() {
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
}