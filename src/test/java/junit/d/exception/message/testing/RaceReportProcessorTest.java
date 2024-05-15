package junit.d.exception.message.testing;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

// test class to test RaceReportProcessor.class methods
class RaceReportProcessorTest {

    // write a test for generateReport() method to validate FileNotFoundException is thrown
    // Assert just that an exception is thrown
    @Test
    void generateReport() {
        // create an instance of the class under test
        RaceReportProcessor raceReportProcessor = new RaceReportProcessor();
        // set the file paths (with a typo, so an exception will be thrown)
        String driverFile = "src/main/resources/exception_testing_data/driver/drivers.csv";
        String raceFile = "src/main/resources/exception_testing_data/racePerformance/race.csv";
        // write an assertThrows() assertion with expected FileNotFoundException
        assertThrows(FileNotFoundException.class,
                () -> raceReportProcessor.generateReport(driverFile, raceFile));
    }

    // write a test for generateReport() method to validate thrown FileNotFoundExceptions text
    // Assert the thrown error message
    @Test
    void generateReportDriverFileThrowsFileNotFoundException() {
        // create an instance of the class under test
        RaceReportProcessor raceReportProcessor = new RaceReportProcessor();
        // set the file paths (with a typo, so an exception will be thrown)
        String driverFile = "src/main/resources/exception_testing_data/drivers/drivers.csv";
        String raceFile = "src/main/resources/exception_testing_data/racePerformance/race.csv";
        // extract the thrown exception
        Exception exception = assertThrows(FileNotFoundException.class,
                () -> raceReportProcessor.generateReport(driverFile, raceFile));
        // write an assertEquals() assertion on exception's message
        assertEquals("src\\main\\resources\\exception_testing_data\\drivers\\drivers.csv (The system cannot find the file specified)", exception.getMessage());
    }

}