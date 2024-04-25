package day_two.mockito_bdd;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class TrainBarriersTest {

    @Mock
    EmailService emailServiceMock;

    final int PASSENGER_ID = 3;

    @Test
    void passengerEntry() {

        // given - setup for test
        TrainBarriers trainBarriers = new TrainBarriers(emailServiceMock);
        TrainBarriers trainBarriersSpy = spy(trainBarriers);
        when(trainBarriersSpy.passengerIsEligible(PASSENGER_ID)).thenReturn(true);

        // when - method invocation
        trainBarriersSpy.passengerEntry(PASSENGER_ID);

        // then - what we expect
        verify(emailServiceMock).notifyPassenger(PASSENGER_ID);
        assertTrue(trainBarriersSpy.getPassengersOnBoard().contains(PASSENGER_ID));
    }

    @Test
    void passengerEntryBDD() {

        // given
        TrainBarriers trainBarriers = new TrainBarriers(emailServiceMock);
        TrainBarriers trainBarriersSpy = spy(trainBarriers);
        given(trainBarriersSpy.passengerIsEligible(PASSENGER_ID))
                .willReturn(true);

        // when
        trainBarriersSpy.passengerEntry(PASSENGER_ID);

        // then
        then(emailServiceMock)
                .should()
                .notifyPassenger(PASSENGER_ID);

        assertTrue(trainBarriersSpy.getPassengersOnBoard().contains(PASSENGER_ID));
    }
}