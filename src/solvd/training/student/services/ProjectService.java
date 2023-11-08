package solvd.training.student.services;

import solvd.training.student.employees.OfficeEmployee;
import solvd.training.student.exceptions.DuplicateEmployeeException;
import solvd.training.student.exceptions.DuplicateTaskException;
import solvd.training.student.exceptions.ProjectNotFoundException;
import solvd.training.student.exceptions.TaskAssignmentException;
import solvd.training.student.product.Project;
import solvd.training.student.product.Task;

public class ProjectService {

    private Project project;

    public ProjectService(Project project) {
        this.project = project;
    }

    public void addTaskToProject(Task task) {
        project.addTask(task);
        System.out.println("Added task: " + task.getName() + " to project " + project.getName());
    }

    public void addEmployeeToProject(OfficeEmployee employee) throws DuplicateEmployeeException {

        int employeeId = employee.getIdOfEmployee();

        for (OfficeEmployee existingEmployee : project.getEmployeeList()) {
            if (existingEmployee.getIdOfEmployee() == employeeId) {
                throw new DuplicateEmployeeException("Employee with ID " + employeeId + " already exists in the project");
            }
        }

        project.addEmployee(employee);
    }

    public void addTaskToEmployee(OfficeEmployee employee, Task task) {
        try {
            if (!project.getTasks().contains(task)) {
                throw new TaskAssignmentException("Task cannot be assigned, because it's not part of the project");
            }
            if (task.getAssignedEmployee() == null) {
                task.assignToEmployee(employee);
                employee.addTask(task);
                System.out.println("Added task: " + task.getName() + " to employee " + employee.getFirstName() + " " + employee.getLastName());
            } else {
                throw new DuplicateTaskException("Task is already assigned to " + task.getAssignedEmployee().getFirstName() + " " + task.getAssignedEmployee().getLastName());
            }
        } catch (TaskAssignmentException | DuplicateTaskException e) {
            System.out.println(e.getMessage());
        }
    }


    public void displayProjectInfo(Project projectToDisplay) throws ProjectNotFoundException {
        if (projectToDisplay.getIdOfProject() != project.getIdOfProject()) {
            throw new ProjectNotFoundException("Project not found");
        }
        System.out.println("Project Information: \n - " + projectToDisplay.getName() + "\n - " + projectToDisplay.getDescription());
    }


}