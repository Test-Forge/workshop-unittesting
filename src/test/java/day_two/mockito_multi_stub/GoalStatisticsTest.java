package day_two.mockito_multi_stub;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GoalStatisticsTest {

    @Mock
    GoalsService goalsService;

    @InjectMocks
    GoalStatistics goalStatistics;


    @ParameterizedTest
    @MethodSource("inputData")
    void testGoalsPerGame(int totalGoals, int gamesPlayed, int goalsPerGame) throws Exception {
        String playerName = "Player";

        when(goalsService.getGoals(playerName)).thenReturn(totalGoals);

        Integer goalsAvg = goalStatistics.goalsPerGame(playerName, gamesPlayed);
        assertEquals(goalsPerGame, goalsAvg);

    }

    @Test
    void testGoalsPerGameException() {
        String playerName = "Player";

        when(goalsService.getGoals(playerName)).thenReturn(0);

        assertThrows(Exception.class, () -> goalStatistics.goalsPerGame(playerName, 10));
    }

    @Test
    void testGoalsPerGameWithMultiStub() throws Exception {
        String playerName = "Player";

        when(goalsService.getGoals(playerName)).thenReturn(100).thenReturn(10).thenReturn(0);
        Integer goalsHigh = goalStatistics.goalsPerGame(playerName, 10);
        assertEquals(goalsHigh, 10);

        Integer goalsLow = goalStatistics.goalsPerGame(playerName, 10);
        assertEquals(goalsLow, 1);

        assertThrows(Exception.class, () -> goalStatistics.goalsPerGame(playerName, 10));

    }

    private static Object[] inputData() {
        return new Object[] {
                new Object[] {100, 10, 10},
                new Object[] {10, 10, 1},
        };
    }
}