package day_one.exceptions_testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CashierTest {

    @Test
    public void validateTransactionThrowsIllegalArgument() {
        assertThrows(IllegalArgumentException.class, () -> Cashier.validateTransaction("USD", 10));
    }

    @Test
    public void amountIsValidThrowsInvalidAmountException() {
        assertThrows(InvalidTransactionAmountException.class, () -> Cashier.validateTransaction("EUR", -10));
    }


}