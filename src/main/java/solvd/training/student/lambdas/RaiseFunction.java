package solvd.training.student.lambdas;

import solvd.training.student.employees.Employee;

@FunctionalInterface
public interface RaiseFunction<E extends Employee> {
    void giveRaise(E employee);
}