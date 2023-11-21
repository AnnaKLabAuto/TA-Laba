package solvd.training.student.product;

import solvd.training.student.employees.OfficeEmployee;

import java.util.Objects;

public class Task {

    private String name;
    private String description;
    private OfficeEmployee assignedEmployee;

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
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
        this.assignedEmployee = employee;
    }

    public void unassignFromEmployee() {
        this.assignedEmployee = null;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(name, task.name) && Objects.equals(description, task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description);
    }
}
