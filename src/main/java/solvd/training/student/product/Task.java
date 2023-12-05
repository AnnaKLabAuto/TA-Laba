package solvd.training.student.product;

import solvd.training.student.employees.OfficeEmployee;
import solvd.training.student.enums.TaskPriority;

import java.util.Objects;

public class Task {

    private String name;
    private String description;
    private OfficeEmployee assignedEmployee;
    private TaskPriority taskPriority;

    public Task(String name, String description, TaskPriority taskPriority) {
        this.name = name;
        this.description = description;
        this.taskPriority = taskPriority;
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

    public OfficeEmployee getAssignedEmployee() {
        return assignedEmployee;
    }

    public void assignToEmployee(OfficeEmployee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("Employee cannot be null");
        }
        this.assignedEmployee = employee;
    }

    public void unassignFromEmployee() {
        this.assignedEmployee = null;
    }

    public TaskPriority getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(TaskPriority taskPriority) {
        this.taskPriority = taskPriority;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", assignedEmployee=" + assignedEmployee +
                ", taskPriority=" + taskPriority +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(name, task.name) && Objects.equals(description, task.description) && Objects.equals(assignedEmployee, task.assignedEmployee) && taskPriority == task.taskPriority;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, assignedEmployee, taskPriority);
    }
}
