import employees.data.Record;
import employees.data.Tuple;
import employees.util.DataMapper;
import employees.util.InputParser;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        FileInputStream input = new FileInputStream("src/main/resources/Input.txt");

        InputParser parser = new InputParser();

        List<Record> data = parser.parseInput(input);

        DataMapper mapper = new DataMapper();

        Map<Tuple, Long> mappedData = mapper.mapData(data);

        Tuple result = findMax(mappedData);

        printResult(result);
    }

    private static void printResult(Tuple result) {
        System.out.println("The ID's of the two employees with the longest running collaboration on projects are "
                        + result.getFirstId() + " and " + result.getSecondId());
    }

    private static Tuple findMax(Map<Tuple, Long> mappedData) {
        Map.Entry<Tuple, Long> maxEntry = null;

        for (Map.Entry<Tuple, Long> entry : mappedData.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }
        assert maxEntry != null;

        return maxEntry.getKey();

    }

}