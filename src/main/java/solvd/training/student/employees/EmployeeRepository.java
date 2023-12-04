package solvd.training.student.employees;

import solvd.training.student.customlinkedlist.CustomLinkedList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

public class EmployeeRepository<T extends Employee> {

    private final CustomLinkedList<T> employees = new CustomLinkedList<>();

    public void addEmployee(T employee) {
        employees.add(employee);
    }

    public void removeEmployee(T employee) {
        if (employees.contains(employee)) {
            employees.remove(employee);
        }
    }

    public List<T> getAllEmployees() {
        List<T> allEmployeesCopy = new ArrayList<>();
        for (T employee : employees) {
            allEmployeesCopy.add(employee);
        }
        return allEmployeesCopy;
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