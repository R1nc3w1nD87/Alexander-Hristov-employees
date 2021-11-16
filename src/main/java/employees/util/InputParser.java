package employees.util;

import employees.data.Record;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputParser {

    private Scanner scan;

    public List<Record> parseInput(FileInputStream input) {

        List<Record> data = new ArrayList<>();
        scan = new Scanner(input);

        while (scan.hasNext()) {
            Record record = parseRecord();

            data.add(record);
        }
        return data;
    }

    private Record parseRecord() {
        String[] line = scan.nextLine().split(",\\s+");

        return new Record(Integer.parseInt(line[0]), Integer.parseInt(line[1]),
                LocalDate.parse(line[2]),"NULL".equals(line[3]) ? LocalDate.now() : LocalDate.parse(line[3]));
    }

    public List<Record> parseInput(String src) throws IOException {
        return parseInput(new FileInputStream(src));
    }
}