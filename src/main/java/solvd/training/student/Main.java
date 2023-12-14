package solvd.training.student;

import static solvd.training.student.utils.LoggerUtil.log;
import solvd.training.student.clients.Client;
import solvd.training.student.company.Department;
import solvd.training.student.employees.*;
import solvd.training.student.enums.*;
import solvd.training.student.exceptions.DuplicateEmployeeException;
import solvd.training.student.exceptions.EmployeeNotFoundException;
import solvd.training.student.exceptions.ProjectNotFoundException;
import solvd.training.student.product.Project;
import solvd.training.student.product.SoftwareProject;
import solvd.training.student.product.Task;
import solvd.training.student.services.EmployeeService;
import solvd.training.student.services.ProjectService;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws DuplicateEmployeeException, EmployeeNotFoundException, ProjectNotFoundException, ClassNotFoundException {

        Department itDepartment = new Department("IT", "");
        Department accountingDepartment = new Department("Finance", "");
        Client client = new Client("Andrew", "Kowalski", "andrew.kowalski@gmail.com");

        OfficeEmployee employee1 = new OfficeEmployee(
                "Franziska",
                "Waltraud",
                itDepartment,
                JobTitle.SOFTWARE_ENGINEER,
                EmploymentStatus.FULL_TIME,
                LeaveType.NO_LEAVE,
                5000);

        OfficeEmployee employee2 = new OfficeEmployee(
                "Hubertus",
                "Andrea",
                itDepartment,
                JobTitle.SOFTWARE_ENGINEER,
                EmploymentStatus.PART_TIME,
                LeaveType.SICK_LEAVE,
                7000);

        OfficeEmployee employee3 = new OfficeEmployee(
                "Julia",
                "Waltraud",
                itDepartment,
                JobTitle.SOFTWARE_ENGINEER,
                EmploymentStatus.PART_TIME,
                LeaveType.SICK_LEAVE,
                3000);

        Manager manager = new Manager(
                "Thomas",
                "Smith",
                itDepartment,
                JobTitle.MANAGER,
                EmploymentStatus.FULL_TIME,
                LeaveType.NO_LEAVE,
                10000);

        Accountant accountant = new Accountant(
                "Maria",
                "Doe",
                accountingDepartment,
                JobTitle.ACCOUNTANT,
                EmploymentStatus.FULL_TIME,
                LeaveType.VACATION_LEAVE,
                8000);

        Task task1 = new Task(
                "Add button",
                "Adding button to interface",
                TaskPriority.LOW);

        Task task2 = new Task(
                "Add login system",
                "Adding login system",
                TaskPriority.HIGH);

        SoftwareProject projectTicketApp = new SoftwareProject(
                "TicketApp",
                "App for buying tickets.",
                ProjectStatus.IN_PROGRESS);

        SoftwareProject projectWeatherApp = new SoftwareProject(
                "WeatherApp",
                "App for displaying weather info.",
                ProjectStatus.COMPLETED);

        EmployeeRepository<Employee> employeeRepository = new EmployeeRepository<>();
        EmployeeService employeeService = new EmployeeService(employeeRepository);

        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(manager);
        employees.add(accountant);

        employeeService.addEmployees(employees);
        Employee foundEmployee = employeeService.displayEmployeeInfo(employee1);
        log.info(foundEmployee);

        ProjectService projectService = new ProjectService(projectTicketApp);
        projectService.addEmployeeToProject(employee1);
        projectService.addEmployeeToProject(employee2);
        projectService.addEmployeeToProject(manager);
        projectService.addTaskToProject(task1);
        projectService.addTaskToProject(task2);
        projectService.assignTaskToEmployee(employee1, task1);
        Project foundProject = projectService.displayProjectInfo(projectTicketApp);
        log.info(foundProject);

        Map<Client, List<Project>> clientProjects = new HashMap<>();
        List<Project> clientListOfProjects = new ArrayList<>();
        clientListOfProjects.add(projectTicketApp);
        clientListOfProjects.add(projectWeatherApp);

        clientProjects.put(client, clientListOfProjects);
        itDepartment.setClientProjects(clientProjects);

        // lambdas
        employeeService.giveRaise.giveRaise(employee1);

        boolean isEmployeeOnVacation = employeeService.checkIfEmployeeIsOnVacation.checkIfEmployeeIsOnVacation(employee1);
        log.info(isEmployeeOnVacation ? "Employee is on vacation" : "Employee is not on vacation");

        boolean isManagerPresentInProject = projectService.hasManager.hasManager(projectTicketApp, manager);
        log.info(isManagerPresentInProject ? "Project has a manager" : "Project does not have a manager");

        Supplier<SoftwareProject> addSoftwareProject = () -> new SoftwareProject(
                "FoodApp",
                "App for searching food recipes",
                ProjectStatus.IN_PLANNING);
        SoftwareProject newProject = addSoftwareProject.get();
        log.info("New project created");

        Predicate<SoftwareProject> checkIsProjectInProgress = project -> projectTicketApp
                .getStatus()
                .equals(ProjectStatus.IN_PROGRESS);
        boolean isInProgress = checkIsProjectInProgress.test(projectWeatherApp);
        log.info("Is project in progress: " + isInProgress);

        Consumer<Employee> displayEmployeeSalary = employee ->  log.info("The Salary of "
                + employee.getFirstName() + " "
                + employee.getLastName() + "is "
                + employee.getSalary());
        displayEmployeeSalary.accept(employee1);

        Function<Task, Employee> getAssignedEmployee = Task::getAssignedEmployee;
        Employee assignedEmployee = getAssignedEmployee.apply(task1);
        log.info("Assigned employee: " + assignedEmployee.getFirstName() + " " + assignedEmployee.getLastName());

        Consumer<SoftwareProject> getTasksAndPrint = project -> {
            List<Task> tasks = project.getTasks();
            for (Task task : tasks) {
                log.info(task);
            }
        };
        getTasksAndPrint.accept(projectTicketApp);

        // streams
        List<Employee> allEmployees = employeeRepository.getAllEmployees();
        List<Task> allTasks = projectTicketApp.getTasks();

        double averageSalary = allEmployees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .getAsDouble();
        log.info(averageSalary);

        List<String> employeeFullNames = employees.stream()
                .map(employee -> employee.getFirstName() + " " + employee.getLastName())
                .toList();
        log.info(employeeFullNames);

        Map<Client, Stream<Project>> completedProjectsStreams = itDepartment.getCompletedProjectsAsStream();
        for (Map.Entry<Client, Stream<Project>> entry : completedProjectsStreams.entrySet()) {
            Client foundClient = entry.getKey();
            Stream<Project> completedProjects = entry.getValue();

            log.info("Completed projects for client " + foundClient.getFirstName() + " " + foundClient.getLastName());
            completedProjects.forEach(project -> log.info(project.getName()));
        }

        List<Employee> filteredEmployees = allEmployees.stream()
                .filter(employee -> employee.getSalary() < 6000)
                .toList();
        log.info(employeeFullNames);

        boolean hasHighPriorityTask = allTasks.stream()
                .anyMatch(task -> task.getTaskPriority() == TaskPriority.HIGH);
        log.info(hasHighPriorityTask);

        Employee firstSickEmployee = allEmployees.stream()
                .filter(employee -> employee.getType() != LeaveType.SICK_LEAVE)
                .findFirst()
                .orElse(null);
        log.info(firstSickEmployee);

        List<Task> assignedTasks = allTasks.stream()
                .filter(task -> task.getAssignedEmployee() != null)
                .toList();
        log.info(assignedTasks);
    }
}