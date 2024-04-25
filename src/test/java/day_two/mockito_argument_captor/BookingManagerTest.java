package day_two.mockito_argument_captor;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

class BookingManagerTest {

    @Test
    void addReservation() {
        BookingPersister bookingPersisterSpy = spy(BookingPersister.class);
        BookingManager bookingManager = new BookingManager(bookingPersisterSpy);

        // ArgumentCaptor
        ArgumentCaptor<Booking> capturedBooking = ArgumentCaptor.forClass(Booking.class);

        bookingManager.addReservation("Anthony", 2, 19);

        verify(bookingPersisterSpy).persistToDatabase(capturedBooking.capture());
        Booking captureBookingValue = capturedBooking.getValue();

        assertEquals("Anthosny", captureBookingValue.getTable().getName());
        assertEquals(2, captureBookingValue.getTable().getNumber());
        assertEquals(19, captureBookingValue.getTable().getTime());
    }
}