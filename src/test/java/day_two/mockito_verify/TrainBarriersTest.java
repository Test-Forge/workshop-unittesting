package day_two.mockito_verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class TrainBarriersTest {

    @Mock
    PassengerRepository passengerRepositoryMock;

    @Mock
    EmailService emailServiceMock;

    @InjectMocks
    TrainBarriers trainBarriers;

    @Test
    void passengerEntry() {
        final int PASSENGER_ID = 3;

        trainBarriers.passengerEntry(PASSENGER_ID);
        verify(passengerRepositoryMock).registerPassengerOnTrain(PASSENGER_ID);
        verify(emailServiceMock).notifyPassenger(PASSENGER_ID);
    }

}