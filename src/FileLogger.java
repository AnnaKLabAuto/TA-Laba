import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FileLogger {

    private static final Logger logger = LogManager.getLogger(FileLogger.class);

    public static void main(String[] args) {
        logger.info("Hello!");
        logger.debug("Hello!");
    }

}
