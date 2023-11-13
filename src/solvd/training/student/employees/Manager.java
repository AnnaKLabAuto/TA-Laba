package solvd.training.student.employees;

import solvd.training.student.company.Department;

import java.util.List;
import java.util.Objects;


public class Manager extends Employee{

    private List<Employee> employeeList;

    public Manager(String firstName, String lastName, Department department, String title, List<Employee> employeeList) {
        super(firstName, lastName, department, title);
        this.employeeList = employeeList;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "employeeList=" + employeeList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Manager manager = (Manager) o;
        return Objects.equals(employeeList, manager.employeeList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), employeeList);
    }
}
