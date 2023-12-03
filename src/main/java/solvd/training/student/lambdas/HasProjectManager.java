package solvd.training.student.lambdas;

import solvd.training.student.employees.Employee;

@FunctionalInterface
public interface HasProjectManager<Project, E extends Employee> {
    boolean hasManager(Project project, E employee);
}
