package solvd.training.student.company;

import solvd.training.student.client.Client;
import solvd.training.student.product.Project;

import java.util.List;
import java.util.Map;

public class Department {

    private final String name;

    private String description;

    Map<Client, List<Project>> clientProjects;

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
}
