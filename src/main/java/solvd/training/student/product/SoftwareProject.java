package solvd.training.student.product;

import org.apache.logging.log4j.Logger;
import solvd.training.student.logger.LoggerUtil;
import solvd.training.student.enums.ProjectStatus;

public class SoftwareProject extends Project{

    Logger logger = LoggerUtil.getLogger();
    public SoftwareProject(String name, String description, ProjectStatus status) {
        super(name, description, status);
    }

    public final void specificProjectDescription() {
        logger.info("Description for SoftwareProject.");
    }
}
