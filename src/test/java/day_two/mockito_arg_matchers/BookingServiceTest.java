package day_two.mockito_arg_matchers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookingServiceTest {

    @Spy
    BookingRepository bookingRepository;

    @InjectMocks
    BookingService bookingService;

    @Test
    void testBuyTicket() {
        BookingService bookingServiceSpy = spy(bookingService);
        bookingServiceSpy.buyTicket("ABC123");

        verify(bookingServiceSpy).bookSeat(any(Ticket.class)); // any() - is the arg matcher
    }

    @Test
    void testBookSeat() {
        String ticketShowId = "TICKET:ID_1";
        Ticket ticket = new Ticket(ticketShowId);

        List<String> availableTickets = new ArrayList<>();
        availableTickets.add(ticketShowId);
        when(bookingRepository.getSeats(anyString())).thenReturn(availableTickets); // anyString() - is the arg matcher

        assertTrue(bookingService.bookSeat(ticket));
    }
}