package mockito.presentation.e.injectannotations;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

// class should be extended with MockitoExtension, for the mockito annotations to work
@ExtendWith(MockitoExtension.class)
// test class to test CustomerOrder.class methods
class CustomerOrderTest {

    // creation of a BreakfastWaiter spy()
    @Spy
    BreakfastWaiter breakfastWaiterSpy;

    // creation of a DinnerWaiter spy()
    @Spy
    DinnerWaiter dinnerWaiter;

    // creation of a CustomerOrder test double that contains both of the dependencies
    @InjectMocks
    CustomerOrder customerOrder;

    // example test for vegetarianBreakfast()
    @Test
    void testServeVegetarianBreakfast() {
        System.out.println(customerOrder.vegetarianBreakfast());
    }

    // example test for meatDinner()
    @Test
    void meatDinner() {
        System.out.println(customerOrder.meatDinner());
    }

}