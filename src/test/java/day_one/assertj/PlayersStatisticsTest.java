package day_one.assertj;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static day_one.assertj.PlayerAssert.assertThat;

class PlayersStatisticsTest {

    // AssertJ provides improved readability compared to JUnit assertions
    // Using standard matchers

    private Players playerPatrickUnderThirty;
    private PlayersStatistics statisticsOfPatrickUnderThirty;

    @BeforeEach
    public void setup() {
        System.out.println("setup");
        playerPatrickUnderThirty = new Players("Patrick", 27);
        statisticsOfPatrickUnderThirty = new PlayersStatistics(playerPatrickUnderThirty, 3, 3);
    }

    @Test
    public void playerNameEqual() {
        System.out.println("test 1");
        Players player2 = new Players("Patrick", 25);
        assertThat(player2.getName())
                .as("Players should have the same name")
                .isEqualTo(playerPatrickUnderThirty.getName());
    }

    @Disabled
    @Test
    public void playerNamesNotEqual() {
        System.out.println("test 2");
        Players player2 = new Players("Kalvin", 25);
        assertThat(player2).isNotEqualTo(playerPatrickUnderThirty);
    }

    @Test
    public void youngerPlayerSame() {
        System.out.println("test 3");
        Players player2 = new Players("Patrick", 25);
        assertThat(PlayersStatistics.getYoungerPlayer(playerPatrickUnderThirty, player2))
                .isSameAs(player2);
    }

    @Test
    public void underThirtyTrue() {
        System.out.println("test 4");
        assertThat(statisticsOfPatrickUnderThirty.underThirty()).isTrue();
    }

    @Test
    public void underThirtyFalse() {
        System.out.println("test 5");
        Players player1 = new Players("Patrick", 37);
        PlayersStatistics statistics = new PlayersStatistics(player1, 3, 3);
        assertThat(statistics.underThirty()).isFalse();
    }

    @Test
    public void csvReportNull() {
        System.out.println("test 6");
        PlayersStatistics statistics = new PlayersStatistics(playerPatrickUnderThirty, 0, 0);
        assertThat(statistics.createCsvRecord()).isNull();
    }

    @Test
    public void csvReportNotNull() {
        System.out.println("test 7");
        PlayersStatistics statistics = new PlayersStatistics(playerPatrickUnderThirty, 3, 3);
        assertThat(statistics.createCsvRecord()).isNotNull();
    }

    @Test
    public void getCsvStatsRecord() {
        System.out.println("test 8");
        PlayersStatistics statistics = new PlayersStatistics(playerPatrickUnderThirty, 4, 8);
        Double[] expectedArray = {2d, 0.5};
        assertThat(statistics.createCsvRecord()).isEqualTo(expectedArray);
    }

    @Test
    public void playerConstructorNameAssigned() {
        System.out.println("test 9");
        Players player1 = new Players("Stuart", 30);
        assertThat(player1.getAge()).isEqualTo(30);
    }

    // Using Custom AssertJ Matchers (hasName)

    @Test
    public void playerNameEqualCustom() {
        System.out.println("test 1");
        Players player2 = new Players("Patrick", 25);
        assertThat(player2).hasName(playerPatrickUnderThirty.getName());
    }

}