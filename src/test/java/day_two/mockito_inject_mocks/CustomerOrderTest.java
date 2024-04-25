package day_two.mockito_inject_mocks;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class CustomerOrderTest {

    @Spy
    BreakfastWaiter breakfastWaiter;

    @Spy
    DinnerWaiter dinnerWaiter;

    @InjectMocks
    CustomerOrder customerOrder;

    @Test
    void testServeVegetarianBreakfast() {
        List<String> expectedBreakfast = Arrays.asList("Apple", "Beans", "Hash brown", "Toast");
        List<String> actualBreakfast = customerOrder.vegetarianBreakfast();
        assertThat(expectedBreakfast).isEqualTo(actualBreakfast);
    }

    @Test
    void meatDinner() {
        List<String> expectedDinner = Arrays.asList("Calamari", "Roast Chicken", "Sticky toffee pudding");
        List<String> actualDinner = customerOrder.meatDinner();
        assertThat(expectedDinner).isEqualTo(actualDinner);
    }
}