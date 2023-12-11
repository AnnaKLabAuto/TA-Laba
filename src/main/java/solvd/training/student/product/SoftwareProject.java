package solvd.training.student.product;

import static solvd.training.student.logger.LoggerUtil.logger;
import solvd.training.student.enums.ProjectStatus;

public class SoftwareProject extends Project{

    public SoftwareProject(String name, String description, ProjectStatus status) {
        super(name, description, status);
    }

    public final void specificProjectDescription() {
        logger.info("Description for SoftwareProject.");
    }
}
