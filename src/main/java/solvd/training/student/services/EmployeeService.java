package solvd.training.student.services;

import solvd.training.student.employees.Employee;
import solvd.training.student.employees.EmployeeRepository;
import solvd.training.student.employees.OfficeEmployee;
import solvd.training.student.exceptions.DuplicateTaskException;
import solvd.training.student.exceptions.EmployeeNotFoundException;

import java.util.function.Supplier;

public class EmployeeService {

    private EmployeeRepository<Employee> employeeRepository;

    public EmployeeService(EmployeeRepository<Employee> employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void addEmployee(Employee employee) {
        System.out.println("Added employee: " + employee.getFirstName() + " " + employee.getLastName());
        employeeRepository.addEmployee(employee);
    }

    public void removeEmployee(Employee employee) {
        System.out.println("Removed employee: " + employee.getFirstName() + " " + employee.getLastName());
        employeeRepository.removeEmployee(employee);
    }

    public void displayEmployeeInfo(OfficeEmployee employee) throws EmployeeNotFoundException {
        int employeeId = employee.getIdOfEmployee();
        Employee foundEmployee = employeeRepository.findEmployeeById(employeeId);

        if (foundEmployee == null) {
            throw new EmployeeNotFoundException("Employee with ID " + employeeId + " not found.");
        }

        System.out.printf("Employee Information: "
                        + "- Name: %s  "
                        + "- Last Name: %s  "
                        + "- Title: %s "
                        + "- Department: %s\n", foundEmployee.getFirstName(), foundEmployee.getLastName(),
        foundEmployee.getTitle(), foundEmployee.getDepartment().getName());

    }
}
