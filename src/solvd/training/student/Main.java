package solvd.training.student;

import solvd.training.student.client.Client;
import solvd.training.student.company.Department;
import solvd.training.student.employees.EmployeeRepository;
import solvd.training.student.employees.Manager;
import solvd.training.student.employees.OfficeEmployee;
import solvd.training.student.exceptions.DuplicateEmployeeException;
import solvd.training.student.exceptions.EmployeeNotFoundException;
import solvd.training.student.exceptions.ProjectNotFoundException;
import solvd.training.student.exceptions.TaskAssignmentException;
import solvd.training.student.product.SoftwareProject;
import solvd.training.student.product.Task;
import solvd.training.student.services.EmployeeService;
import solvd.training.student.services.ProjectService;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws DuplicateEmployeeException, EmployeeNotFoundException, ProjectNotFoundException, TaskAssignmentException {

        Department department = new Department("IT", "Information Technology Department");

        OfficeEmployee employee1 = new OfficeEmployee("Franziska" , "Waltraud", department, "Developer");
        OfficeEmployee employee2 = new OfficeEmployee("Hubertus", "Andrea", department, "Software Engineer");

        List<OfficeEmployee> employeeList = new ArrayList<>();
        employeeList.add(employee1);
        employeeList.add(employee2);

        Task task1 = new Task("Add button", "Adding button to interface");
        Task task2 = new Task("Add login system", "Adding login system");

        EmployeeRepository employeeRepository = new EmployeeRepository();
        EmployeeService employeeService = new EmployeeService(employeeRepository);

        employeeService.addEmployee(employee1);

        //TODO:EmployeeNotFoundException
        //employeeService.displayEmployeeInfo(employee2);

        Manager manager = new Manager("Tomas", "Andrea", department, "Team Leader", employeeList);
        Client client = new Client("Adam", "Kowalski", "adam.kowalski@gmail.com");

        SoftwareProject projectTicketApp = new SoftwareProject ("TicketApp", "App for buying tickets.", new ArrayList<>());
        SoftwareProject projectWeatherApp = new SoftwareProject ("WeatherApp", "App for displaying weather info.", new ArrayList<>());

        ProjectService projectService = new ProjectService(projectTicketApp);

        projectService.addTaskToProject(task1);
        projectService.addEmployeeToProject(employee1);

        //TODO: DuplicateEmployeeException - checked
        //projectService.addEmployeeToProject(employee1);

        //TODO: ProjectNotFoundException
        //projectService.displayProjectInfo(projectWeatherApp);

        //TODO:DuplicateTaskException
        //TODO:TaskAssignmentException
        projectService.addTaskToEmployee(employee2, task1);
        projectService.addTaskToEmployee(employee1, task1);

    }
}