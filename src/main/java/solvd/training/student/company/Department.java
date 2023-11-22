package solvd.training.student.company;

import solvd.training.student.clients.Client;
import solvd.training.student.employees.Manager;
import solvd.training.student.product.Project;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Department {

    private final String name;

    private String description;

    private Map<Client, List<Project>> clientProjects;

    private Map<Manager, List<Project>> managerProjects;

    public Department(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(clientProjects, that.clientProjects) && Objects.equals(managerProjects, that.managerProjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, clientProjects, managerProjects);
    }
}
