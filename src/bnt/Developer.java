package bnt;

public class Developer extends Employee {

    public Developer(double ratePerHour, int workdays) {
        super(ratePerHour, workdays);
    }

    public double getSalary(double bonus) {
        return super.getSalary() + bonus;
    }
}
