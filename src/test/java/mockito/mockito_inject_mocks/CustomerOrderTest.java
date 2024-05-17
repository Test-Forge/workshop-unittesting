package mockito.mockito_inject_mocks;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.spy;

@ExtendWith(MockitoExtension.class)
class CustomerOrderTest {

//    @Mock(answer = Answers.RETURNS_DEFAULTS)
//    BreakfastWaiter breakfastWaiterMock;

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

    @Test
    void testMeatDinner() {
        BreakfastWaiter breakfastWaiterSpy = spy();
        DinnerWaiter dinnerWaiterSpy = spy();
        CustomerOrder customerOrder1 = new CustomerOrder(breakfastWaiterSpy, dinnerWaiterSpy);

        List<String> expectedDinner = Arrays.asList("Calamari", "Roast Chicken", "Sticky toffee pudding");
        List<String> actualDinner = customerOrder1.meatDinner();
        assertThat(expectedDinner).isEqualTo(actualDinner);
    }
}