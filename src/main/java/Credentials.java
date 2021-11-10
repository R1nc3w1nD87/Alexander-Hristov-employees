public class Credentials {
     private int employeeOne;
     private int employeeTwo;

    public Credentials(){}

    public Credentials(int employeeOne, int employeeTwo) {
        this.employeeOne = employeeOne;
        this.employeeTwo = employeeTwo;
    }

    public int getEmployeeOne() {
        return employeeOne;
    }

    public void setEmployeeOne(int employeeOne) {
        this.employeeOne = employeeOne;
    }

    public int getEmployeeTwo() {
        return employeeTwo;
    }

    public void setEmployeeTwo(int employeeTwo) {
        this.employeeTwo = employeeTwo;
    }
}
