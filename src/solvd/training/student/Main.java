package solvd.training.student;

import solvd.training.student.company.Department;
import solvd.training.student.employees.Employee;
import solvd.training.student.employees.Manager;
import solvd.training.student.product.Project;
import solvd.training.student.product.Task;
import solvd.training.student.services.EmployeeService;
import solvd.training.student.services.ProjectService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Department itDepartment = new Department("IT", "Information Technology Department");

        Employee employee1 = new Employee("Franziska" , "Waltraud", itDepartment, "Developer");
        Employee employee2 = new Employee("Hubertus", "Andrea", itDepartment, "Software Engineer");

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee1);
        employeeList.add(employee2);

        Manager manager1 = new Manager("Tomas", "Andrea", itDepartment, "Team Leader", employeeList);

        Task task1 = new Task("Add button", "Adding button to interface");
        Task task2 = new Task("Add button2", "Adding button2 to interface");

        List<Task> tasks = new ArrayList<>();
        tasks.add(task1);
        tasks.add(task2);

        Project project = new Project("TicketApp", "App for buying tickets.", tasks, employeeList);

        EmployeeService employeeService = new EmployeeService();
        employeeService.addEmployee(employee1);
        employeeService.displayEmployeeInfo();

        ProjectService projectService = new ProjectService(project);
        projectService.addTaskToProject(task1);
        projectService.addEmployeeToProject(employee1);
        projectService.displayProjectInfo();

    }
}