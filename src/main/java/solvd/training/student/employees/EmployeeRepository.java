package solvd.training.student.employees;

import solvd.training.student.customlinkedlist.CustomLinkedList;

import java.util.NoSuchElementException;

public class EmployeeRepository<T extends Employee>{

    private final CustomLinkedList<T> employees = new CustomLinkedList<>();

    public void addEmployee(T employee) {
        employees.add(employee);
    }

    public void removeEmployee(T employee) {
        int index = employees.indexOf(employee);
        if (index != -1) {
            employees.remove(index);
        }
    }

    public T findEmployeeById(int employeeId) {
        for (int i = 0; i < employees.size(); i++) {
            T employee = employees.get(i);
            if (employee.getIdOfEmployee() == employeeId) {
                return employee;
            }
        }
        throw new NoSuchElementException("Employee with ID " + employeeId + " not found");
    }
}
