package day_two.mockito_then_vs_do;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

class CarShopTest {

    @Test
    public void testCarsInShop() {
        CarShop carShopSpy = spy(CarShop.class);
        Map<String, Integer> carsInStock = new HashMap<>();
        carsInStock.put("Jaguar", 10);

//        when(carShopSpy.getCarsInStock()).thenReturn(carsInStock); //thenReturn() - has a compile time check on data type; also, method behavior is run in background
        doReturn(carsInStock).when(carShopSpy).getCarsInStock(); //doReturn() - checks for data type at runtime;

        assertEquals(10, carShopSpy.getStockForBrand("Jaguar"));

        //exceptions / side effects can influence test code with thenReturn()
    }


}