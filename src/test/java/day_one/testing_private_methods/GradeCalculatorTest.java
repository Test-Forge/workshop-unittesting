package day_one.testing_private_methods;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GradeCalculatorTest {

    // with reflection
    @Test
    public void computeGradeWithReflection() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // Arrange
        GradeCalculator gc = new GradeCalculator();
        Method method = gc.getClass().getDeclaredMethod("computeGrade", Integer.class);
        method.setAccessible(true);

        // Act
        String actualGrade = (String) method.invoke(gc, 80);

        // Assert
        assertEquals("Pass", actualGrade);
    }

}