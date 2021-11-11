public class Tuple {
    private int firstEmployeeId;
    private int secondEmployeeId;

    public Tuple(){}

    public Tuple(int firstEmployeeId, int secondEmployeeId) {
        this.firstEmployeeId = firstEmployeeId;
        this.secondEmployeeId = secondEmployeeId;
    }

    public int getFirstEmployeeId() {
        return firstEmployeeId;
    }

    public void setFirstEmployeeId(int firstEmployeeId) {
        this.firstEmployeeId = firstEmployeeId;
    }

    public int getSecondEmployeeId() {
        return secondEmployeeId;
    }

    public void setSecondEmployeeId(int secondEmployeeId) {
        this.secondEmployeeId = secondEmployeeId;
    }
}
