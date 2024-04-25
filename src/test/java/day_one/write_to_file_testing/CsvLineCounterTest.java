package day_one.write_to_file_testing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CsvLineCounterTest {

    @Test
    void countLinesFromFile() throws IOException {

        File file = new File("./test.csv");
        try {
            String csvData = "a,b,c\nd,e,f\ng";
            Files.write(file.toPath(), csvData.getBytes());

            long actualLines = CsvLineCounter.countLinesFromFile(file.toPath());

            assertEquals(3, actualLines);
        } finally {
            Files.delete(file.toPath());
        }
    }

    @Test
    void countLinesFromFileUsingTemporaryDir(@TempDir Path tempDir) throws IOException {

        Path tempFile = Files.createTempFile(tempDir, "test", ".txt");

        String csvData = "a,b,c\nd,e,f\ng";
        Files.write(tempFile, csvData.getBytes());

        long actualLines = CsvLineCounter.countLinesFromFile(tempFile);

        assertEquals(3, actualLines);
    }

}