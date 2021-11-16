package r1nc3w1nd.data;

public class Collaboration {
    private Tuple employeeIds;
    private long currentCollaborationDays;
    private long totalCollaborationDays;

    public Collaboration(Tuple employeeIds, long currentCollaborationDays){
        this.employeeIds = employeeIds;
        this.currentCollaborationDays = currentCollaborationDays;
    }

    public Collaboration(Tuple employeeIds, long currentCollaborationDays, long totalCollaborationDays) {
        this.employeeIds = employeeIds;
        this.currentCollaborationDays = currentCollaborationDays;
        this.totalCollaborationDays = totalCollaborationDays;
    }

    public Tuple getEmployeeIds() {
        return employeeIds;
    }

    public void setEmployeeIds(Tuple employeeIds) {
        this.employeeIds = employeeIds;
    }

    public long getCurrentCollaborationDays() {
        return currentCollaborationDays;
    }

    public void setCurrentCollaborationDays(long currentCollaborationDays) {
        this.currentCollaborationDays = currentCollaborationDays;
    }

    public long getTotalCollaborationDays() {
        return totalCollaborationDays;
    }

    public void setTotalCollaborationDays(long totalCollaborationDays) {
        this.totalCollaborationDays = totalCollaborationDays;
    }
}
