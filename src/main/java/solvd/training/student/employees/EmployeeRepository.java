package solvd.training.student.employees;

import solvd.training.student.customlinkedlist.CustomLinkedList;

import java.util.NoSuchElementException;

public class EmployeeRepository<T extends Employee>{

    private CustomLinkedList<T> employees = new CustomLinkedList<>();

    public void addEmployee(T employee) {
        employees.add(employee);
    }

    public void removeEmployee(T employee) {
        if (employees.contains(employee)) {
            employees.remove(employee);
        }
    }

    public Employee findEmployeeById(int employeeId) {
        for (T employee : employees) {
            if (employee.getIdOfEmployee() == employeeId) {
                return employee;
            }
        }
        throw new NoSuchElementException("Employee with ID " + employeeId + " not found");
    }
}
