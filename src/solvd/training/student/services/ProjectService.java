package solvd.training.student.services;

import solvd.training.student.employees.OfficeEmployee;
import solvd.training.student.product.Project;
import solvd.training.student.product.SoftwareProject;
import solvd.training.student.product.Task;


public class ProjectService {

    private SoftwareProject project;

    public ProjectService(SoftwareProject project) {
        this.project = project;
    }

    public void addTaskToProject(Task task) {
        project.addTask(task);
        System.out.println("Added task: " + task.getName() + " to project " + project.getName());
    }

    public void addEmployeeToProject(OfficeEmployee employee){
        project.addEmployee(employee);
    }

    public void addTaskToEmployee(OfficeEmployee employee, Task task) {
        task.assignToEmployee(employee);
        System.out.println("Added task: " + task.getName() + " to employee " + employee.getFirstName() + " " + employee.getLastName());
    }

    public void displayProjectInfo(){
        System.out.println("Project Information: \n - " + project.getName() + "\n - " + project.getDescription());
    }


}