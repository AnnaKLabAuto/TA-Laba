package solvd.training.student;

import solvd.training.student.company.Department;
import solvd.training.student.employees.*;
import solvd.training.student.enums.*;
import solvd.training.student.exceptions.DuplicateEmployeeException;
import solvd.training.student.exceptions.EmployeeNotFoundException;
import solvd.training.student.exceptions.ProjectNotFoundException;
import solvd.training.student.product.SoftwareProject;
import solvd.training.student.product.Task;
import solvd.training.student.services.EmployeeService;
import solvd.training.student.services.ProjectService;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws DuplicateEmployeeException, EmployeeNotFoundException{

        Department itDepartment = new Department("IT", "");
        Department hrDepartment = new Department("HR", "");
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
                itDepartment,
                JobTitle.ACCOUNTANT,
                EmploymentStatus.FULL_TIME,
                LeaveType.VACATION_LEAVE);

        Task task1 = new Task("Add button", "Adding button to interface", TaskPriority.LOW);
        Task task2 = new Task("Add login system", "Adding login system", TaskPriority.HIGH);

        EmployeeRepository<Employee> employeeRepository = new EmployeeRepository<>();
        EmployeeService employeeService = new EmployeeService(employeeRepository);

        employeeService.addEmployee(employee1);
        employeeService.addEmployee(manager);
        employeeService.displayEmployeeInfo(employee1);

        SoftwareProject projectTicketApp = new SoftwareProject ("TicketApp", "App for buying tickets.", ProjectStatus.IN_PROGRESS);
        SoftwareProject projectWeatherApp = new SoftwareProject ("WeatherApp", "App for displaying weather info.", ProjectStatus.IN_PLANNING);

        ProjectService projectService = new ProjectService(projectTicketApp);

        projectService.addTaskToProject(task1);
        projectService.addEmployeeToProject(employee1);
        projectService.addTaskToEmployee(employee2, task1);


    }
}