public class Pairs {
    private Tuple employeePair;
    private int projectLength;

    public Pairs(){}

    public Pairs(Tuple employeePair, int projectLength) {
        this.employeePair = employeePair;
        this.projectLength = projectLength;
    }

    public Tuple getEmployeePair() {
        return employeePair;
    }

    public void setEmployeePair(Tuple employeePair) {
        this.employeePair = employeePair;
    }

    public int getProjectLength() {
        return projectLength;
    }

    public void setProjectLength(int projectLength) {
        this.projectLength = projectLength;
    }
}
