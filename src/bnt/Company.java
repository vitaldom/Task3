package bnt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Company {

    private static final String NO_BUDGET_MESSAGE = "No available budget to hire new employee";

    private String name;
    private double budget;
    private Employee[] employees;

    public Company(String name, double budget) {
        this.name = name;
        this.budget = budget;
    }

    public void addEmployee(Employee newEmployee) {

        if (employees == null) {
            employees = new Employee[]{newEmployee};
        }

        if (getAvailableBudget() < newEmployee.getSalary()) {
            throw new IllegalArgumentException(NO_BUDGET_MESSAGE);

        } else {
            List<Employee> bufferList = new ArrayList<>(Arrays.asList(employees));
            bufferList.add(newEmployee);
            employees = bufferList.toArray(employees);
        }
    }

    private double getAvailableBudget() {               //checks available budget when adding a new employee

        double currentExpenses = 0;

        for(Employee e : employees) {
            currentExpenses += e.getSalary();
        }

        return budget - currentExpenses;
    }

    private boolean preparePayment(double bonusForDevelopers) {         //checks if budget is sufficient before payment

        double requiredBudget = 0;

        for (Employee employee : employees) {

            double employeeSalary = 0;

            if (employee instanceof Developer) {
                employeeSalary = ((Developer) employee).getSalary(bonusForDevelopers);
            } else {
                employeeSalary = employee.getSalary();
            }
            requiredBudget += employeeSalary;
        }

        return requiredBudget >= budget;
    }

    public SalaryService getSalaryService() {
        return new SalaryService();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }
}
