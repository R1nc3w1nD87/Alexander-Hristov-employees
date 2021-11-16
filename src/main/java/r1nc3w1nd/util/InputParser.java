package r1nc3w1nd.util;

import r1nc3w1nd.data.Record;
import java.io.FileInputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputParser {

    FileInputStream input;
    List<Record> data = new ArrayList<>();

    public InputParser(FileInputStream input) {
        this.input = input;
    }

    public List<Record> parseInput() {

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
}