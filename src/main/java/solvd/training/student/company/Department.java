package solvd.training.student.company;

import solvd.training.student.clients.Client;
import solvd.training.student.enums.ProjectStatus;
import solvd.training.student.product.Project;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Department {

    private final String name;

    private String description;

    private Map<Client, List<Project>> clientProjects;

    public Department(String name, String description) {
        this.name = name;
        this.description = description;
        this.clientProjects = new HashMap<>();
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

    public void setClientProjects(Map<Client, List<Project>> clientProjects) {
        this.clientProjects = clientProjects;
    }

    public Map<Client, Stream<Project>> getCompletedProjectsAsStream() {
        return clientProjects.entrySet().stream()
                .collect(Collectors.toMap(
                        entry -> Objects.requireNonNull(entry.getKey(), "Client cannot be null"),
                        entry -> entry.getValue().stream()
                                .filter(project -> project != null && project.getStatus().equals(ProjectStatus.COMPLETED))));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(name, that.name) && Objects.equals(description,
                that.description) && Objects.equals(clientProjects,
                that.clientProjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, clientProjects);
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", clientProjects=" + clientProjects +
                '}';
    }
}
