package junit.homework.parameterized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

// test class to test MarsExploration.class method
class MarsExplorationTest {

    // TODO write a parameterized test for marsExploration() method via "@CsvFileSource"
    @ParameterizedTest
    @CsvFileSource(resources = "/mars_exploration_test_data.csv", useHeadersInDisplayName = true)
    void marsExploration(String sentMessage, int changedLetters) {
        assertEquals(changedLetters, MarsExploration.marsExploration(sentMessage));
    }
}