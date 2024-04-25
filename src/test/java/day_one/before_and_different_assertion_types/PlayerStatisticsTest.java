package day_one.before_and_different_assertion_types;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerStatisticsTest {

    private Player playerPatrickUnderThirty;
    private PlayerStatistics statisticsOfPatrickUnderThirty;

    @BeforeEach
    public void setup() {
        System.out.println("setup");
        playerPatrickUnderThirty = new Player("Parick", 27);
        statisticsOfPatrickUnderThirty = new PlayerStatistics(playerPatrickUnderThirty, 3, 3);
    }

    @Test
    public void playerNameEqual(){
        System.out.println("test 1");
        Player player2 = new Player("Patrick", 25);
        assertEquals(player2.getName(), playerPatrickUnderThirty.getName(), "Players should have the same name");
    }

    @Disabled
    @Test
    public void playerNamesNotEqual(){
        System.out.println("test 2");
        Player player2 = new Player("Kalvin", 25);
        assertNotEquals(player2.getName(), playerPatrickUnderThirty.getName());
    }

    @Test
    public void youngerPlayerSame(){
        System.out.println("test 3");
        Player player2 = new Player("Patrick", 25);
        assertEquals(PlayerStatistics.getYoungerPlayer(playerPatrickUnderThirty, player2), player2);
    }

    @Test
    public void underThirtyTrue(){
        System.out.println("test 4");
        assertTrue(statisticsOfPatrickUnderThirty.underThirty());
    }

    @Test
    public void underThirtyFalse(){
        System.out.println("test 5");
        Player player1 = new Player("Patrick", 37);
        PlayerStatistics statistics = new PlayerStatistics(player1, 3, 3);
        assertFalse(statistics.underThirty());
    }

    @Test
    public void csvReportNull(){
        System.out.println("test 6");
        PlayerStatistics statistics = new PlayerStatistics(playerPatrickUnderThirty, 0, 0);
        assertNull(statistics.createCsvRecord());
    }

    @Test
    public void csvReportNotNull(){
        System.out.println("test 7");
        PlayerStatistics statistics = new PlayerStatistics(playerPatrickUnderThirty, 3, 3);
        assertNotNull(statistics.createCsvRecord());
    }

    @Test
    public void getCsvStatsRecord(){
        System.out.println("test 8");
        PlayerStatistics statistics = new PlayerStatistics(playerPatrickUnderThirty, 4, 8);
        Double[] expectedArray = {2d, 0.5};
        assertArrayEquals(expectedArray, statistics.createCsvRecord());
    }

    @Test
    public void playerConstructorNameAssigned(){
        System.out.println("test 9");
        Player player1 = new Player("Stuart", 30);
        assertEquals(30, player1.getAge());
    }

}