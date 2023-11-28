package solvd.training.student.lambdas;

import solvd.training.student.employees.Employee;

@FunctionalInterface
public interface GetEmployeeById<T extends Employee> {
    Employee getEmployeeById(int id);
}
