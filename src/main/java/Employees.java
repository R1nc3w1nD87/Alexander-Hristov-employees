import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class Employees {
    public static void main(String[] args) {

        List<int[]> inputRecords = new ArrayList<>();

        try {
            FileInputStream inputStream = new FileInputStream("src/main/resources/Input.txt");
            Scanner scan = new Scanner(inputStream);
            parseInputData(inputRecords, scan);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        Credentials crds = new Credentials();

        Map<Credentials, Integer> projectData = new HashMap<>();
        mapData(inputRecords, crds, projectData);
        int[] oldestPair = findMax(projectData);
        System.out.println(Arrays.toString(oldestPair));
    }

    private static int[] findMax(Map<Credentials, Integer> projectData) {
        int[] oldestPair = new int[2];
        int highestValue = 0;
        for (Map.Entry<Credentials, Integer> entry : projectData.entrySet()) {
            Credentials currentKey = entry.getKey();
            int currentValue = entry.getValue();
            if (currentValue > highestValue){
                oldestPair[0] = currentKey.getEmployeeOne();
                oldestPair[1] = currentKey.getEmployeeTwo();
                highestValue = currentValue;
            }

        }
        return oldestPair;
    }

    private static void mapData(List<int[]> inputRecords,Credentials crds, Map<Credentials, Integer> totalProjectsMaxSums) {
        for (int i = 0; i < inputRecords.size(); i++) {
            int currentEmployee = inputRecords.get(i)[0];
            int currentProject = inputRecords.get(i)[1];
            int currentDateSum = inputRecords.get(i)[2];
            int longestProjectSum = 0;
            for (int[] inputRecord : inputRecords) {
                if (inputRecord[0] != currentEmployee
                        && inputRecord[1] == currentProject) {
                    crds.setEmployeeOne(currentEmployee);
                    crds.setEmployeeTwo(inputRecord[0]);
                    int currentLongestSum = currentDateSum + inputRecord[2];
                    totalProjectsMaxSums.put(crds, currentLongestSum);
                    longestProjectSum += currentLongestSum;
                }
            }

        }
    }

    private static void parseInputData(List<int[]> employeeProjects, Scanner scan) {
        while (scan.hasNext()){
            String[] line = scan.nextLine().split(",\\s+");
            if ("NULL".equals(line[3])){
                line[3] = LocalDate.now().toString();
            }
            LocalDate dateFrom = LocalDate.parse(line[2]);
            LocalDate dateTo = LocalDate.parse(line[3]);
            int currentDateSum = dateTo.compareTo(dateFrom);
            int currentEmployee = Integer.parseInt(line[0]);
            int currentProject = Integer.parseInt(line[1]);
            int[] currentEmpProj = new int[3];
            currentEmpProj[0] = currentEmployee;
            currentEmpProj[1] = currentProject;
            currentEmpProj[2] = currentDateSum;

            employeeProjects.add(currentEmpProj);

        }
    }
}