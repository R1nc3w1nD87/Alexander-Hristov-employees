package employees.data;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Record {
    private final int employeeId;
    private final int projectId;
    private final LocalDate dateFrom;
    private final LocalDate dateTo;

    public Record(int employeeId, int projectId, LocalDate dateFrom, LocalDate dateTo) {
        this.employeeId = employeeId;
        this.projectId = projectId;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public long daysOnProject(){
        return ChronoUnit.DAYS.between(dateFrom, dateTo);
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public int getProjectId() {
        return projectId;
    }

}
