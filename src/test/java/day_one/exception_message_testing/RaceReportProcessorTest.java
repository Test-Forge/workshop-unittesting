package day_one.exception_message_testing;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static com.googlecode.catchexception.CatchException.catchException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RaceReportProcessorTest {

    // Assert just that an exception is thrown
    @Test
    void generateReport() {

        RaceReportProcessor raceReportProcessor = new RaceReportProcessor();
        String driverFile = "src/main/resources/exception_testing_data/driver/drivers.csv";
        String raceFile = "src/main/resources/exception_testing_data/racePerformance/race.csv";
        assertThrows(FileNotFoundException.class, () -> raceReportProcessor.generateReport(driverFile, raceFile));

    }

    // Assert the error message thrown
    @Test
    void generateReportDriverFileThrowsFileNotFoundException() {

        RaceReportProcessor raceReportProcessor = new RaceReportProcessor();
        String driverFile = "src/main/resources/exception_testing_data/drivers/drivers.csv";
        String raceFile = "src/main/resources/exception_testing_data/racePerformance/race.csv";

        Exception exception = assertThrows(FileNotFoundException.class,
                () -> raceReportProcessor.generateReport(driverFile, raceFile));

        assertEquals("src\\main\\resources\\exception_testing_data\\drivers\\drivers.csv (The system cannot find the file specified)", exception.getMessage());
    }

}