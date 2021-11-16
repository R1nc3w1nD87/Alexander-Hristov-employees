package employees.util;

import employees.data.Record;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputParser {

    public InputParser() {}

    public List<Record> parseInput(FileInputStream input) {

        List<Record> data = new ArrayList<>();
        Scanner scan = new Scanner(input);

        while (scan.hasNext()) {
            String[] line = scan.nextLine().split(",\\s+");
            if ("NULL".equals(line[3])) {
                line[3] = LocalDate.now().toString();
            }

            Record record = new Record(Integer.parseInt(line[0]), Integer.parseInt(line[1]),
                    LocalDate.parse(line[2]), LocalDate.parse(line[3]));

            data.add(record);
        }
        return data;
    }

    public List<Record> parseInput(String src) throws IOException {
        return parseInput(new FileInputStream(src));
    }
}