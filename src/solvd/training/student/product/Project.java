package solvd.training.student.product;

import solvd.training.student.employees.Employee;

import java.util.List;
import java.util.Objects;

public class Project {

    private String name;
    private String description;
    private List<Task> tasks;
    private List<Employee> employeeList;

    public Project(String name, String description, List<Task> tasks, List<Employee> employeeList) {
        this.name = name;
        this.description = description;
        this.tasks = tasks;
        this.employeeList = employeeList;
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

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    @Override
    public String toString() {
        return "product.Project{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", tasks=" + tasks +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(name, project.name) && Objects.equals(description, project.description) && Objects.equals(tasks, project.tasks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, tasks);
    }
}