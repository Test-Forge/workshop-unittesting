package day_two.mockito_mocking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookingManagerTest {

    private HotelDao hotelDaoMock;
    private BookingManager bookingManager;

    @BeforeEach
    public void setup() throws SQLException {
        hotelDaoMock = mock(HotelDao.class);
        bookingManager = new BookingManager(hotelDaoMock);

        List<String> availableRooms = Arrays.asList("A");
        when(hotelDaoMock.fetchAvailableRooms()).thenReturn(availableRooms);
    }

    @Test
    public void checkAvailableRoomsTrue() throws SQLException {
        Assertions.assertTrue(bookingManager.checkRoomAvailability("A"));
    }

    @Test
    public void checkAvailableRoomsFalse() throws SQLException {
        Assertions.assertFalse(bookingManager.checkRoomAvailability("B"));
    }

}
