package solvd.training.student.product;

import solvd.training.student.company.Department;
import solvd.training.student.employees.Employee;
import solvd.training.student.employees.OfficeEmployee;
import solvd.training.student.enums.ProjectStatus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public abstract class Project {

    private static int nextProjectId;
    private final int idOfProject;
    private final String name;
    private final String description;
    private final ProjectStatus status;
    private final List<Task> tasks;
    private final List<Employee> employeeList;

    static {
        nextProjectId = 1;
    }

    public Project(String name, String description, ProjectStatus status) {
        this.idOfProject = nextProjectId++;
        this.name = name;
        this.description = description;
        this.status = status;
        this.tasks = new ArrayList<>();
        this.employeeList = new ArrayList<>();
    }

    public int getIdOfProject() {
        return idOfProject;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void addTask(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Task cannot be null");
        }
        tasks.add(task);
    }

    public void addEmployee(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("Employee cannot be null");
        }
        employeeList.add(employee);
    }

    public ProjectStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Project{" +
                "idOfProject=" + idOfProject +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", tasks=" + tasks +
                ", employeeList=" + employeeList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(name, project.name) && Objects.equals(description, project.description) &&
                Objects.equals(tasks, project.tasks) && Objects.equals(employeeList, project.employeeList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, tasks, employeeList);
    }

}
