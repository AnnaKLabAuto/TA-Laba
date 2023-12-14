package solvd.training.student.services;


import solvd.training.student.employees.Employee;
import solvd.training.student.employees.Manager;
import solvd.training.student.employees.OfficeEmployee;
import solvd.training.student.enums.JobTitle;
import solvd.training.student.exceptions.DuplicateEmployeeException;
import solvd.training.student.exceptions.DuplicateTaskException;
import solvd.training.student.exceptions.ProjectNotFoundException;
import solvd.training.student.exceptions.TaskAssignmentException;
import solvd.training.student.lambdas.HasProjectManager;
import solvd.training.student.product.Project;
import solvd.training.student.product.SoftwareProject;
import solvd.training.student.product.Task;
import static solvd.training.student.utils.LoggerUtil.log;

public class ProjectService {


    private final SoftwareProject project;

    public ProjectService(SoftwareProject project) {
        this.project = project;
    }

    public void addTaskToProject(Task task) {
        if (task != null) {
            project.addTask(task);
            log.info("Added task: " + task.getName() + " to project " + project.getName());
        }
        log.error("Task is null");
    }

    public <T extends Employee> void addEmployeeToProject(T employee) throws DuplicateEmployeeException {
        int employeeId = employee.getIdOfEmployee();
        for (Employee existingEmployee : project.getEmployeeList()) {
            if (existingEmployee.getIdOfEmployee() == employeeId) {
                throw new DuplicateEmployeeException("Employee with ID " + employeeId + " already exists in the project");
            }
        }
        project.addEmployee(employee);
    }

    public void assignTaskToEmployee(OfficeEmployee employee, Task task) {
        try {
            if (!project.getTasks().contains(task)) {
                throw new TaskAssignmentException("Task cannot be assigned, because it's not part of the project");
            }
            if (task.getAssignedEmployee() == null) {
                task.assignToEmployee(employee);
                log.info("Added task: " + task.getName() + " to employee " + employee.getFirstName() + " "
                        + employee.getLastName());
            } throw new DuplicateTaskException("Task is already assigned to " + task.getAssignedEmployee().getFirstName()
                    + " " + task.getAssignedEmployee().getLastName());
        } catch (TaskAssignmentException | DuplicateTaskException e) {
            log.error(e);
        }
    }

    public HasProjectManager<Project, Manager> hasManager = (project, manager ) -> {
        for (Employee employee : project.getEmployeeList()) {
            if (employee instanceof Manager && employee.getTitle().equals(JobTitle.MANAGER)) return true;
        }
        return false;
    };

    public Project displayProjectInfo(Project projectToDisplay) throws ProjectNotFoundException {
        if (projectToDisplay.getIdOfProject() != project.getIdOfProject()) {
            throw new ProjectNotFoundException("Project not found");
        }
        return projectToDisplay;
    }
}