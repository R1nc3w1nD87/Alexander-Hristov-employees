import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Record> data = new ArrayList<>();
        Tuple tuple = new Tuple();
        List<Pairs> pairedProjects = new ArrayList<>();

        parseInputData(data);
        mapData(data, pairedProjects);

        int[] oldestPair = findMax(pairedProjects);

        System.out.println(Arrays.toString(oldestPair));
    }

    private static int[] findMax(List<Pairs> projectData) {
        int[] oldestPair = new int[2];
        int highestValue = 0;
        for (Pairs projectDatum : projectData) {
            Tuple currentPair = projectDatum.getEmployeePair();
            int currentValue = projectDatum.getProjectLength();
            if (currentValue > highestValue) {
                oldestPair[0] = currentPair.getFirstEmployeeId();
                oldestPair[1] = currentPair.getSecondEmployeeId();
                highestValue = currentValue;
            }

        }
        return oldestPair;
    }

    private static void mapData(List<Record> data, List<Pairs> pairs) {
        for (int i = 0; i < data.size(); i++) {
            int currentEmployee = data.get(i).getEmployeeId();
            int currentProject = data.get(i).getProjectId();
            int currentDateSum = data.get(i).getDateFrom().compareTo(data.get(i).getDateTo());
            int longestProjectSum = 0;
            for (Record datum : data) {
                Pairs pair = new Pairs();
                if (datum.getEmployeeId() != currentEmployee
                        && datum.getProjectId() == currentProject) {
                    Tuple tuple = new Tuple(currentEmployee, datum.getEmployeeId());
                    int currentLongestSum = currentDateSum + datum.getDateTo().compareTo(datum.getDateFrom());
                    pair.setEmployeePair(tuple);
                    pair.setProjectLength(currentLongestSum);
                    longestProjectSum += currentLongestSum;
                    pairs.add(pair);
                }
            }

        }
    }

    private static void parseInputData(List<Record> data) {
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/Input.txt");
            Scanner scan = new Scanner(fis);
            while (scan.hasNext()) {
                String[] line = scan.nextLine().split(",\\s+");
                if ("NULL".equals(line[3])) {
                    line[3] = LocalDate.now().toString();
                }
                Record record = new Record();
                record.setEmployeeId(Integer.parseInt(line[0]));
                record.setProjectId(Integer.parseInt(line[1]));
                record.setDateFrom(LocalDate.parse(line[2]));
                record.setDateTo(LocalDate.parse(line[3]));

                data.add(record);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}