package solvd.training.student.employees;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class EmployeeRepository {

    private final LinkedList<Employee> employees = new LinkedList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    public Employee findEmployeeById(int employeeId) {
        for (Employee employee : employees) {
            if (employee.getIdOfEmployee() == employeeId) {
                return employee;
            }
        }
        throw new NoSuchElementException("Employee with ID " + employeeId + " not found");
    }
}
