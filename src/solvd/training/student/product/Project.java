package solvd.training.student.product;

import solvd.training.student.employees.OfficeEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Project {
    private static int nextProjectId = 1;
    private int idOfProject;
    private String name;
    private String description;
    private List<Task> tasks;
    private List<OfficeEmployee> employeeList;

    public Project(String name, String description) {
        this.idOfProject = nextProjectId++;
        this.name = name;
        this.description = description;
        this.tasks = new ArrayList<>();
        this.employeeList = new ArrayList<>();
    }

    public int getIdOfProject() {
        return idOfProject;
    }

    public void setIdOfProject(int idOfProject) {
        this.idOfProject = idOfProject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<OfficeEmployee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<OfficeEmployee> employeeList) {
        this.employeeList = employeeList;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void addEmployee(OfficeEmployee employee) {
        employeeList.add(employee);
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
        return Objects.equals(name, project.name) && Objects.equals(description, project.description) && Objects.equals(tasks, project.tasks) && Objects.equals(employeeList, project.employeeList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, tasks, employeeList);
    }
}
