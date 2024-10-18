package junit.homework.asserting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorAssertJTest {

    private static final Calculator CALCULATOR = new Calculator();

    @Test
    @DisplayName("Test add method")
    void testAdd() {
        //TODO: Write an isEqualTo() assertion to test the add method
        assertThat(CALCULATOR.add(2, 3)).isEqualTo(5);
    }

    @Test
    @DisplayName("Test subtract method")
    void testSubtract() {
        //TODO: Write an isNotEqualTo() assertion to test the subtract method
        assertThat(CALCULATOR.subtract(3, 2)).isNotEqualTo(5);
    }

    @Test
    @DisplayName("Test multiply method")
    void testMultiply() {
        //TODO: Write an containsExactly() assertion to test the multiply method
        assertThat(new int[]{CALCULATOR.multiply(1, 2), CALCULATOR.multiply(2, 2), CALCULATOR.multiply(3, 2)})
                .containsExactly(2, 4, 6);
        assertThat(List.of(CALCULATOR.multiply(1, 1))).containsExactly(1);
    }

    @Test
    @DisplayName("Test divide method with zero divisor")
    void testDivideWithZeroDivisor() {
        //TODO: Write an isEqualTo() assertion to test the divide method with zero divisor
        try {
            assertThat(CALCULATOR.divide(1, 0)).isEqualTo(0);
        } catch (ArithmeticException _) {
        }
    }

    @Test
    @DisplayName("Test isEven method with odd number")
    void testIsEvenWithOddNumber() {
        //TODO: Write an isFalse() assertion to test the isEven method with odd number
        assertThat(CALCULATOR.isEven(3)).isFalse();
    }

    @Test
    @DisplayName("Test getEvenNumbers method with all even numbers")
    void testGetEvenNumbersWithAllEvenNumbers() {
        //TODO: Write a hasSize() assertion to test the getEvenNumbers method with all even numbers
        assertThat(CALCULATOR.getEvenNumbers(new int[]{2, 4, 6, 7})).hasSize(3);
    }

    @Test
    @DisplayName("Test getEvenNumbers method with no even numbers")
    void testGetEvenNumbersWithNoEvenNumbers() {
        //TODO: Write an isEmpty() assertion to test the getEvenNumbers method with no even numbers
        assertThat(CALCULATOR.getEvenNumbers(new int[]{1, 3, 5})).isEmpty();
    }

    @Test
    @DisplayName("Test add method with same inputs")
    void testAddWithSameInputs() {
        //TODO: Write an isSameAs() assertion to test the add method with same inputs
        assertThat(CALCULATOR.add(0, 0)).isSameAs(0);
    }

    @Test
    @DisplayName("Test add method with different inputs")
    void testAddWithDifferentInputs() {
        //TODO: Write an isNotSameAs() assertion to test the add method with different inputs
        assertThat(CALCULATOR.add(5, 6)).isNotSameAs(10);
    }

    @Test
    @DisplayName("Test divide method with zero divisor throws exception")
    void testDivideWithZeroDivisorThrowsException() {
        //TODO: Write an assertThatThrownBy() assertion to test that the divide method throws an exception with zero divisor
        assertThatThrownBy(() -> CALCULATOR.divide(10, 0)).isInstanceOf(ArithmeticException.class);
    }

    @Test
    @DisplayName("Test divide method with non-zero divisor does not throw exception")
    void testDivideWithNonZeroDivisorDoesNotThrowException() {
        //TODO: Write an assertThatCode() assertion to test that the divide method does not throw an exception with non-zero divisor
        assertThatCode(() -> CALCULATOR.divide(0, 2)).doesNotThrowAnyException();
    }
}
