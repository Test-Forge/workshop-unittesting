package day_one.write_to_file_testing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CsvLineCounter {

    public static Long countLinesFromFile(Path filePath) {
        try (var lines = Files.lines(filePath)) {
            return lines.count();
        } catch (IOException e) {
            e.printStackTrace();
            return -1L;
        }
    }
}
