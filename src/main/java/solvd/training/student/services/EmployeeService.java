package solvd.training.student.services;

import solvd.training.student.employees.Employee;
import solvd.training.student.employees.EmployeeRepository;
import solvd.training.student.employees.OfficeEmployee;
import solvd.training.student.enums.LeaveType;
import solvd.training.student.exceptions.EmployeeNotFoundException;
import solvd.training.student.lambdas.CheckEmployeeStatus;
import solvd.training.student.lambdas.RaiseFunction;

import java.util.List;

public class EmployeeService {

    private double raisePercentage = 0.30;
    private final EmployeeRepository<Employee> employeeRepository;

    public EmployeeService(EmployeeRepository<Employee> employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void addEmployees(List<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println("Added employee: " + employee.getFirstName() + " " + employee.getLastName());
            employeeRepository.addEmployee(employee);
        }
    }

    public void removeEmployee(Employee employee) {
        System.out.println("Removed employee: " + employee.getFirstName() + " " + employee.getLastName());
        employeeRepository.removeEmployee(employee);
    }

    public RaiseFunction<Employee> giveRaise = (employee) -> {
        int currentSalary = employee.getSalary();
        int raiseAmount = (int) (currentSalary * raisePercentage);
        employee.setSalary(currentSalary + raiseAmount);
        System.out.println("Employee " + employee.getFirstName() + " " + employee.getLastName()
                + " has received a raise");
    };

    public CheckEmployeeStatus<Employee> checkIfEmployeeIsOnVacation = (employee) ->
            employee.getStatus().equals(LeaveType.NO_LEAVE);

    public void displayEmployeeInfo(OfficeEmployee employee) throws EmployeeNotFoundException {
        int employeeId = employee.getIdOfEmployee();
        Employee foundEmployee = employeeRepository.findEmployeeById(employeeId);
        if (foundEmployee == null) throw new EmployeeNotFoundException("Employee with ID " + employeeId + " not found");

        System.out.printf("Employee Information: "
                        + "- Name: %s  "
                        + "- Last Name: %s  "
                        + "- Title: %s "
                        + "- Department: %s\n", foundEmployee.getFirstName(), foundEmployee.getLastName(),
                foundEmployee.getTitle(), foundEmployee.getDepartment().getName());
    }
}
