package solvd.training.student.employees;

import java.util.LinkedList;

public class EmployeeRepository<T extends Employee>{

    private LinkedList<T> employees = new LinkedList<>();

    public void addEmployee(T employee) {
        employees.add(employee);
    }

    public void removeEmployee(T employee) {
        employees.remove(employee);
    }

    public T findEmployeeById(int employeeId) {
        for (T employee : employees) {
            if (employee.getIdOfEmployee() == employeeId) {
                return employee;
            }
        }
        return null;
    }
}
