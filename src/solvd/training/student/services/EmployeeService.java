package solvd.training.student.services;


import solvd.training.student.employees.EmployeeRepository;
import solvd.training.student.employees.OfficeEmployee;
import solvd.training.student.exceptions.EmployeeNotFoundException;

public final class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void addEmployee(OfficeEmployee employee) {
        System.out.println("Added employee: " + employee.getFirstName() + " " + employee.getLastName());
        System.out.println();
        employeeRepository.addEmployee(employee);
    }

    public void removeEmployee(OfficeEmployee employee) {
        System.out.println("Removed employee: "+ employee.getFirstName() + " " + employee.getLastName());
        System.out.println();
        employeeRepository.removeEmployee(employee);
    }

    public void displayEmployeeInfo(OfficeEmployee employee) throws EmployeeNotFoundException {

        int employeeId = employee.getIdOfEmployee();
        OfficeEmployee foundEmployee = employeeRepository.findEmployeeById(employeeId);

        if (foundEmployee == null) {
            throw new EmployeeNotFoundException("Employee with ID " + employeeId + " not found.");
        }

        System.out.println("Employee Information:");
        System.out.println("Name: " + foundEmployee.getFirstName());
        System.out.println("Last Name: " + foundEmployee.getLastName());
        System.out.println("Title: " + foundEmployee.getTitle());
        System.out.println("Department: " + foundEmployee.getDepartment().getName());
        System.out.println();
    }
}
