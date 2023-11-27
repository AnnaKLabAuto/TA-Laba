package solvd.training.student.product;

import solvd.training.student.enums.ProjectStatus;

public class SoftwareProject extends Project{

    public SoftwareProject(String name, String description, ProjectStatus status) {
        super(name, description, status);
    }

    public final void specificProjectDescription() {
        System.out.println("Description for SoftwareProject.");
    }
}
