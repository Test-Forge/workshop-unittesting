package junit.b.parameterized.testing;
// class under test
public class Calculator {

    // method that returns the passed parameter multiplied by itself
    public int squareInteger(Integer i){
        i = verifySquaredArgument(i);
        return i * i;
    }

    // internal method that checks the validity of entered argument
    private Integer verifySquaredArgument(Integer i) {

        // path a
        if(i == null){
            return 0;
        }
        // path b
        else if (i > 46340 || i < -46340 || i == (int)Double.NaN){
            throw new IllegalArgumentException("Calculator cannot accept value: " + i);
        }
        // path c
        return i;
    }
}
