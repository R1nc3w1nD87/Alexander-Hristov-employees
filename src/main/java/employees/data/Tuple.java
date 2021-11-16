package employees.data;

public class Tuple {
   final private int firstId;
   final private int secondId;

    public Tuple(int firstId, int secondId) {
        this.firstId = firstId;
        this.secondId = secondId;
    }

    public int getFirstId() {
        return firstId;
    }

    public int getSecondId() {
        return secondId;
    }

}
