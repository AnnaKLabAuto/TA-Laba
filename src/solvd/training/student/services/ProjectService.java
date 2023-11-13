package solvd.training.student.services;

import solvd.training.student.employees.Employee;
import solvd.training.student.product.Project;
import solvd.training.student.product.Task;

public class ProjectService {

    private Project project;

    public ProjectService(Project project) {
        this.project = project;
    }

    public void addTaskToProject(Task task) {
        project.addTask(task);
        System.out.println("Added task to project: " + project.getName());
    }

    public void addEmployeeToProject(Employee employee) {
        project.addEmployee(employee);
        System.out.println("Added employee to project: " + employee.getFirstName() + " " + employee.getLastName());
    }

    public void displayProjectInfo() {
        System.out.println("Project Information: " + project);
    }
}