package bnt;

public class Employee {

    private double ratePerHour;
    private int workdays;

    public Employee(double ratePerHour, int workdays) {
        this.ratePerHour = ratePerHour;
        this.workdays = workdays;
    }

    public double getSalary() {
        return ratePerHour * workdays * 8;
    }
}
