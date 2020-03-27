package bnt.entity.employee;

public class Developer extends Employee {

    public Developer(String name, double ratePerHour, int workdays) {
        super(name, ratePerHour, workdays);
    }

    public double getSalary(double bonus) {
        return super.getSalary() + bonus;
    }
}
