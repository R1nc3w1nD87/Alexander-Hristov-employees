import r1nc3w1nd.data.Record;
import r1nc3w1nd.data.Tuple;
import r1nc3w1nd.util.DataMapper;
import r1nc3w1nd.util.InputParser;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        FileInputStream input = new FileInputStream("src/main/resources/Input.txt");

        InputParser parser = new InputParser(input);

        List<Record> data = parser.parseInput();

        DataMapper mapper = new DataMapper(data);

        Map<Tuple, Long> mappedData = mapper.mapData();


        printResult(mappedData);

    }

    private static void printResult(Map<Tuple, Long> mappedData) {
        Map.Entry<Tuple, Long> maxEntry = null;

        for (Map.Entry<Tuple, Long> entry : mappedData.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }
        assert maxEntry != null;
        Tuple result = maxEntry.getKey();
        System.out.println("The ID's of the two employees who have worked together on different projects the longest are " + result.getFirstId() + " and " + result.getSecondId());
    }

}