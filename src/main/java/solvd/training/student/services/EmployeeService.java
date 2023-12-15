package solvd.training.student.services;

import solvd.training.student.employees.Employee;
import solvd.training.student.employees.EmployeeRepository;
import solvd.training.student.employees.OfficeEmployee;
import solvd.training.student.enums.LeaveType;
import solvd.training.student.exceptions.EmployeeNotFoundException;
import solvd.training.student.lambdas.CheckEmployeeStatus;
import solvd.training.student.lambdas.RaiseFunction;
import static solvd.training.student.utils.LoggerUtil.log;

import java.util.List;


public class EmployeeService {

    private final EmployeeRepository<Employee> employeeRepository;

    public EmployeeService(EmployeeRepository<Employee> employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void addEmployees(List<Employee> employees) {
        for (Employee employee : employees) {
            employeeRepository.addEmployee(employee);
            log.info("Added employee: " + employee.getFirstName() + " " + employee.getLastName());
        }
    }

    public void removeEmployee(Employee employee) {
        employeeRepository.removeEmployee(employee);
        log.info("Removed employee: " + employee.getFirstName() + " " + employee.getLastName());
    }

    public RaiseFunction<Employee> giveRaise = (employee) -> {
        int currentSalary = employee.getSalary();
        double raisePercentage = 0.30;
        int raiseAmount = (int) (currentSalary * raisePercentage);
        employee.setSalary(currentSalary + raiseAmount);
        log.info(employee.getFirstName() + " " + employee.getLastName() + " has received a raise");
    };

    public CheckEmployeeStatus<Employee> checkIfEmployeeIsOnVacation = (employee) ->
            employee.getStatus().equals(LeaveType.NO_LEAVE);

    public Employee displayEmployeeInfo(OfficeEmployee employee) throws EmployeeNotFoundException {
        int employeeId = employee.getIdOfEmployee();
        Employee foundEmployee = employeeRepository.findEmployeeById(employeeId);
        if (foundEmployee == null) throw new EmployeeNotFoundException("Employee with ID " + employeeId + " not found");
        return foundEmployee;
    }
}
