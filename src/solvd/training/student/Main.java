package solvd.training.student;

import solvd.training.student.company.Department;
import solvd.training.student.employees.EmployeeRepository;
import solvd.training.student.employees.Manager;
import solvd.training.student.employees.OfficeEmployee;
import solvd.training.student.exceptions.DuplicateEmployeeException;
import solvd.training.student.exceptions.EmployeeNotFoundException;
import solvd.training.student.exceptions.ProjectNotFoundException;
import solvd.training.student.product.SoftwareProject;
import solvd.training.student.product.Task;
import solvd.training.student.services.EmployeeService;
import solvd.training.student.services.ProjectService;

public class Main {
    public static void main(String[] args) throws DuplicateEmployeeException, EmployeeNotFoundException, ProjectNotFoundException {

        Department itDepartment = new Department("IT", "Information Technology Department");

        OfficeEmployee employee1 = new OfficeEmployee("Franziska" , "Waltraud", itDepartment, "Developer");
        OfficeEmployee employee2 = new OfficeEmployee("Hubertus", "Andrea", itDepartment, "Software Engineer");

        Manager manager = new Manager("Thomas", "Smith", itDepartment, "Manager");

        Task task1 = new Task("Add button", "Adding button to interface");
        Task task2 = new Task("Add login system", "Adding login system");

        EmployeeRepository<OfficeEmployee> employeeRepository = new EmployeeRepository<>();
        EmployeeService employeeService = new EmployeeService(employeeRepository);

        employeeService.addEmployee(employee1);
        employeeService.displayEmployeeInfo(employee2); //EmployeeNotFoundException

        SoftwareProject projectTicketApp = new SoftwareProject ("TicketApp", "App for buying tickets.");
        SoftwareProject projectWeatherApp = new SoftwareProject ("WeatherApp", "App for displaying weather info.");

        ProjectService projectService = new ProjectService(projectTicketApp);

        projectService.addTaskToProject(task1);
        projectService.addEmployeeToProject(employee1);

        projectService.addEmployeeToProject(employee1); //DuplicateEmployeeException
        projectService.displayProjectInfo(projectWeatherApp); //ProjectNotFoundException

        projectService.addTaskToEmployee(employee2, task1);
        projectService.addTaskToEmployee(employee1, task1); //DuplicateTaskException
        projectService.addTaskToEmployee(employee1, task2); //TaskAssignmentException

    }
}