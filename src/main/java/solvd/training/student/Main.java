package solvd.training.student;

import solvd.training.student.company.Department;
import solvd.training.student.employees.*;
import solvd.training.student.enums.*;
import solvd.training.student.exceptions.DuplicateEmployeeException;
import solvd.training.student.exceptions.EmployeeNotFoundException;
import solvd.training.student.product.SoftwareProject;
import solvd.training.student.product.Task;
import solvd.training.student.services.EmployeeService;
import solvd.training.student.services.ProjectService;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) throws DuplicateEmployeeException, EmployeeNotFoundException{

        Department itDepartment = new Department("IT", "");
        Department accountingDepartment = new Department("Finance", "");

        OfficeEmployee employee1 = new OfficeEmployee(
                "Franziska" ,
                "Waltraud",
                itDepartment,
                JobTitle.SOFTWARE_ENGINEER,
                EmploymentStatus.FULL_TIME,
                LeaveType.NO_LEAVE);

        OfficeEmployee employee2 = new OfficeEmployee(
                "Hubertus",
                "Andrea",
                itDepartment,
                JobTitle.SOFTWARE_ENGINEER,
                EmploymentStatus.PART_TIME,
                LeaveType.NO_LEAVE);

        Manager manager = new Manager(
                "Thomas",
                "Smith",
                itDepartment,
                JobTitle.PRODUCT_MANAGER,
                EmploymentStatus.FULL_TIME,
                LeaveType.NO_LEAVE);

        Accountant accountant = new Accountant(
                "Maria",
                "Doe",
                accountingDepartment,
                JobTitle.ACCOUNTANT,
                EmploymentStatus.FULL_TIME,
                LeaveType.VACATION_LEAVE);

        Task task1 = new Task(
                "Add button",
                "Adding button to interface",
                TaskPriority.LOW);

        Task task2 = new Task(
                "Add login system",
                "Adding login system",
                TaskPriority.HIGH);

        SoftwareProject projectTicketApp = new SoftwareProject (
                "TicketApp",
                "App for buying tickets.",
                ProjectStatus.IN_PROGRESS);

        SoftwareProject projectWeatherApp = new SoftwareProject (
                "WeatherApp",
                "App for displaying weather info.",
                ProjectStatus.IN_PLANNING);

        //Lambdas
        Supplier<SoftwareProject> addSoftwareProject = () -> new SoftwareProject("FoodApp", "App for searching food recipes", ProjectStatus.IN_PLANNING);
        SoftwareProject newProject = addSoftwareProject.get();
        System.out.println("New project created:");
        System.out.println(newProject);

        Predicate<SoftwareProject> checkIsProjectInProgress = project -> projectTicketApp.getStatus().equals(ProjectStatus.IN_PROGRESS);
        boolean isInProgress = checkIsProjectInProgress.test(projectWeatherApp);
        System.out.println("Is project in progress: " + isInProgress);


        EmployeeRepository<Employee> employeeRepository = new EmployeeRepository<>();
        EmployeeService employeeService = new EmployeeService(employeeRepository);

        //employeeService.addEmployee(employee1);
        //employeeService.addEmployee(manager);
        //employeeService.displayEmployeeInfo(employee1);

        ProjectService projectService = new ProjectService(projectTicketApp);

        //projectService.addTaskToProject(task1);
        //projectService.addEmployeeToProject(employee1);
        //projectService.addTaskToEmployee(employee1, task1);

    }
}