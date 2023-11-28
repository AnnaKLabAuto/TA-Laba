package solvd.training.student.lambdas;

import solvd.training.student.employees.Employee;

@FunctionalInterface
public interface CheckEmployeeStatus<T extends Employee> {
    boolean checkIfEmployeeIsOnVacation(T employee);
}
