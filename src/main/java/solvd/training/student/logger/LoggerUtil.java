package solvd.training.student.logger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtil {

    public static final Logger logger = LogManager.getLogger(LoggerUtil.class.getName());

    public static Logger getLogger() {
        return logger;
    }
}
