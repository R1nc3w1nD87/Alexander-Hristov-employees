import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class Employees {
    public static void main(String[] args) {
        List<int[]> employeeProjects = new ArrayList<>();
        try {

            FileInputStream inputStream = new FileInputStream("src/main/InputFile/Input.txt");
            Scanner scan = new Scanner(inputStream);
            while (scan.hasNext()){
                String[] line = scan.nextLine().split(",\\s+");
                if (line[3].equals("NULL")){
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

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        int[] longestTeamUpEmployees = new int[2];
        Map<int[], Integer> totalProjectsMaxSums = new HashMap<>();
        for (int i = 0; i < employeeProjects.size(); i++) {
            int currentEmployee = employeeProjects.get(i)[0];
            int currentProject = employeeProjects.get(i)[1];
            int currentDateSum = employeeProjects.get(i)[2];
            int longestProjectSum = 0;
            for (int j = 0; j < employeeProjects.size(); j++) {
                if (employeeProjects.get(j)[0] != currentEmployee
                        && employeeProjects.get(j)[1] == currentProject){
                    longestTeamUpEmployees[0] = currentEmployee;
                    longestTeamUpEmployees[1] = employeeProjects.get(j)[0];
                    int  currentLongestSum = currentDateSum + employeeProjects.get(j)[2];
                    totalProjectsMaxSums.put(longestTeamUpEmployees, currentLongestSum);
                    longestProjectSum += currentLongestSum;
                }
            }

        }
        int[] oldestPair = new int[2];
        for (Map.Entry<int[], Integer> entry : totalProjectsMaxSums.entrySet()) {
            int highestValue = 0;
            int[] currentKey = entry.getKey();
            int currentValue = entry.getValue();
            if (currentValue > highestValue){
                oldestPair[0] = currentKey[0];
                oldestPair[1] = currentKey[1];
                highestValue = currentValue;
            }

        }
        System.out.println(Arrays.toString(oldestPair));
    }
}