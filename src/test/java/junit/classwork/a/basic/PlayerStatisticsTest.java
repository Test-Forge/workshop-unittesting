package junit.classwork.a.basic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
// test class to test PlayerStatistics.class methods
class PlayerStatisticsTest {

    // declare the instance of external dependency
    private Player playerPatrickUnderThirty;
    // declare the instance of class under test
    private PlayerStatistics statisticsOfPatrickUnderThirty;

    // initialize the external dependency and the class under test
    @BeforeEach
    public void setup() {
        System.out.println("setup");
        playerPatrickUnderThirty = new Player("Parick", 27);
        statisticsOfPatrickUnderThirty = new PlayerStatistics(playerPatrickUnderThirty, 3, 3);
    }

    // create a test object of the Player.class with the same name as already initialized
    // write an assertEquals assertion for the 2 objects names
    @Test
    public void playerNameEqual(){
        System.out.println("test 1");
        // create a test object
        Player player2 = new Player("Patrick", 25);
        // assertEquals - checks if two objects are equal in terms of their content.
        assertEquals(player2.getName(), playerPatrickUnderThirty.getName(), "Players should have the same name");
    }

    //TODO create a test object of the Player.class
    // with a different name to already initialized one
    // write an assertNotEquals() assertion for the 2 objects names
    @Test
    public void playerNamesNotEqual(){
        System.out.println("test 2");
        // create a test object
        Player player2 = new Player("Kalvin", 25);
        // write an 'assertNotEquals' assertion
        assertNotEquals(player2.getName(), playerPatrickUnderThirty.getName());
    }


    // test the "getYoungerPlayer()" method with an "asserSame()" assertion
    @Test
    public void youngerPlayerSame(){
        System.out.println("test 3");
        // create a test object of Player
        Player player2 = new Player("Patrick", 25);
        // assertSame - checks if two object references point to the exact same object instance in memory
        // write assertSame assertion for 2 similar objects
        assertSame(PlayerStatistics.getYoungerPlayer(playerPatrickUnderThirty, player2), player2);
    }

    //TODO write a test with an "assertNotSame()" assertion
    @Test
    public void youngerPlayerNotSame(){
        System.out.println("test 3");
        // create a test object of Player
        Player player2 = new Player("Parick", 27);
        // assertSame - checks if two object references point to the exact same object instance in memory
        // write assertSame assertion for 2 different objects but with equal data
        assertEquals(playerPatrickUnderThirty, player2);
        assertNotSame(playerPatrickUnderThirty, player2);
    }


    // write a test for underThirty() method with initialized class instance (the return true path)
    // using the @RepeatedTest annotation,
    // customize it with number of runs and accepted fails count
    @RepeatedTest(value = 8, failureThreshold = 2)
    public void underThirtyTrue(){
        System.out.println("test 4");
        // write an "assertTrue()" assertion
        assertTrue(statisticsOfPatrickUnderThirty.underThirty());
    }

    //TODO write a test for underThirty() method for return false path
    // create a test object of the Player.class
    @Test
    public void underThirtyFalse(){
        System.out.println("test 5");
        // create a test object of Player with age over 30
        Player player1 = new Player("Patrick", 37);
        // create a test object
        PlayerStatistics statistics = new PlayerStatistics(player1, 3, 3);
        // write an "assertFalse()" assertion
        assertFalse(statistics.underThirty());
    }


    // write a test for "createCsvRecord()" method for return null path
    @Test
    public void csvReportNull(){
        System.out.println("test 6");
        // create a test object of the PlayerStatistics.class with a player with 0 games played
        PlayerStatistics statistics = new PlayerStatistics(playerPatrickUnderThirty, 0, 0);
        // write an "assertNull()" assertion
        assertNull(statistics.createCsvRecord());
    }

    //TODO write a test for "createCsvRecord()" method for return NOT null path
    @Test
    public void csvReportNotNull(){
        System.out.println("test 7");
        // create a test object of the PlayerStatistics.class with a player with at least 1 game played
        PlayerStatistics statistics = new PlayerStatistics(playerPatrickUnderThirty, 3, 3);
        // write an "assertNotNull()" assertion
        assertNotNull(statistics.createCsvRecord());
    }


    // write a test for "createCsvRecord()" method for return NOT null path, validating the return
    @Test
    public void getCsvStatsRecord(){
        System.out.println("test 8");
        // create a test object of the PlayerStatistics.class with a player with at least 1 game played
        PlayerStatistics statistics = new PlayerStatistics(playerPatrickUnderThirty, 4, 8);
        // create test expected result (an array of type Double with expected values)
        Double[] expectedArray = {2d, 0.5};
        // write an "assertArrayEquals()" assertion on "createCsvRecord()"s return
        assertArrayEquals(expectedArray, statistics.createCsvRecord());
    }

    //TODO write a test on Player's "getAge()" method with "assertEquals()"
    @Test
    public void playerConstructorAgeAssigned(){
        System.out.println("test 9");
        // create a test object of the Player.class
        Player player1 = new Player("Stuart", 30);
        // write an "assertEquals()" assertion on the assigned age
        assertEquals(30, player1.getAge());
    }

}