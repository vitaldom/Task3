package bnt.service;

import bnt.entity.Company;
import bnt.entity.employee.Developer;
import bnt.entity.employee.Employee;

public class SalaryService {

    private static final String INSUFFICIENT_BUDGET_MESSAGE = "Current budget is not sufficient to pay salary.";

    public void pay(Company company, double bonusForDevelopers) {          //version with bonus to developers

        if (!checkBudgetAvailability(company, bonusForDevelopers)) {
            throw new IllegalArgumentException(INSUFFICIENT_BUDGET_MESSAGE);
        }

        //Here goes exact logic for salary payment according to business requirements. For naive implementation, we
        //could define instance field "double bankAccount" in Employee and emulate transfers from company's budget:

        for (Employee employee : company.getEmployees()) {

            double employeeSalary = 0;

            if (employee instanceof Developer) {
                employeeSalary = ((Developer) employee).getSalary(bonusForDevelopers);
            } else {
                employeeSalary = employee.getSalary();
            }

            company.setBudget(company.getBudget() - employeeSalary);
            employee.setBankAccount(employee.getBankAccount() + employeeSalary);
        }
    }

    public void pay(Company company) {                                      //without bonus to developers

        if (!checkBudgetAvailability(company, 0)) {
            throw new IllegalArgumentException(INSUFFICIENT_BUDGET_MESSAGE);
        }

        for (Employee employee : company.getEmployees()) {

            double salary = employee.getSalary();
            company.setBudget(company.getBudget() - salary);
            employee.setBankAccount(employee.getBankAccount() + salary);
        }
    }

    private boolean checkBudgetAvailability(Company company, double bonusForDevelopers) {   //checks if budget is sufficient before payment

        double requiredBudget = 0;

        for (Employee employee : company.getEmployees()) {

            double employeeSalary = 0;

            if (employee instanceof Developer) {
                employeeSalary = ((Developer) employee).getSalary(bonusForDevelopers);
            } else {
                employeeSalary = employee.getSalary();
            }
            requiredBudget += employeeSalary;
        }

        return requiredBudget >= company.getBudget();
    }
}