package bnt.entity.employee;

import java.util.Objects;

public abstract class Employee {

    private String name;
    private double ratePerHour;
    private int workdays;
    private double bankAccount; //TODO

    public Employee(String name, double ratePerHour, int workdays) {
        this.name = name;
        this.ratePerHour = ratePerHour;
        this.workdays = workdays;
    }

    public double getSalary() {
        return ratePerHour * workdays * 8;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", ratePerHour=" + ratePerHour +
                ", workdays=" + workdays +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.ratePerHour, ratePerHour) == 0 &&
                workdays == employee.workdays &&
                name.equals(employee.name);
    }

    @Override
    public int hashCode() {         //TODO
        return Objects.hash(name, ratePerHour, workdays);
    }

    public double getBankAccount() { //TODO
        return bankAccount;
    }

    public void setBankAccount(double bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
