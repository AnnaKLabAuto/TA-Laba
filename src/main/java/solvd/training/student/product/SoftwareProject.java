package solvd.training.student.product;

import static solvd.training.student.utils.LoggerUtil.log;
import solvd.training.student.enums.ProjectStatus;

public class SoftwareProject extends Project{

    public SoftwareProject(String name, String description, ProjectStatus status) {
        super(name, description, status);
    }

    public final void specificProjectDescription() {
        log.info("Description for SoftwareProject.");
    }
}
