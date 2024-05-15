package mockito.mockito_inject_mocks;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerOrder {

    @Autowired
    private BreakfastWaiter breakfastWaiter;

    @Autowired
    private DinnerWaiter dinnerWaiter;

    public CustomerOrder(BreakfastWaiter breakfastWaiter, DinnerWaiter dinnerWaiter) {
        this.breakfastWaiter = breakfastWaiter;
        this.dinnerWaiter = dinnerWaiter;
    }

    public void setBreakfastWaiter(BreakfastWaiter breakfastWaiter) {
        this.breakfastWaiter = breakfastWaiter;
    }

    public void setDinnerWaiter(DinnerWaiter dinnerWaiter) {
        this.dinnerWaiter = dinnerWaiter;
    }

    public List<String> vegetarianBreakfast() {
        return breakfastWaiter.getVegetarianMenu();
    }

    public List<String> meatBreakfast() {
        return breakfastWaiter.getMeatMenu();
    }

    public List<String> vegetarianDinner() {
        return dinnerWaiter.getVegetarianMenu();
    }

    public List<String> meatDinner() {
        return dinnerWaiter.getMeatMenu();
    }
}
