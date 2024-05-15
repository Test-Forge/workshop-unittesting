package mockito.a_mockito_mocking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

// test class to test BookingManager.class methods
public class BookingManagerTest {

    // declaring the objects we will be working with
    // HotelDao object should be a "mock", and its name must reflect this
    private HotelDao hotelDaoMock;
    // BookingManager object
    private BookingManager bookingManager;

    // As we have more than 1 test, it is a good practice to write a "setup()" method using @BeforeEach annotation
    @BeforeEach
    public void setup() throws SQLException {
        // instantiating the HotelDao mocked object
        hotelDaoMock = mock();
        // instantiating the BookingManager object
        bookingManager = new BookingManager(hotelDaoMock);

        // creating test data, that will be used as an instruction (stub) for the mocked object
        List<String> availableRooms = List.of("A");
        // instruct "fetchAvailableRooms()" mocked method to return the created test data "availableRooms" when called
        when(hotelDaoMock.fetchAvailableRooms()).thenReturn(availableRooms);
    }

    @Tag("mocking")
    // test the "checkRoomAvailability(roomName)" method with expected result = true
    @Test
    public void checkAvailableRoomsTrue() throws SQLException {
        // write an assertionTrue assertion
        assertTrue(bookingManager.checkRoomAvailability("A"));
    }

    // test the "checkRoomAvailability(roomName)" method with expected result = false
    @Test
    public void checkAvailableRoomsFalse() throws SQLException {
        // write an assertionFalse assertion
        assertFalse(bookingManager.checkRoomAvailability("B"));
    }

}
