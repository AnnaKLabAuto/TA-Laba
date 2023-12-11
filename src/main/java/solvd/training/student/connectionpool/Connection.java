package solvd.training.student.connectionpool;
import static solvd.training.student.logger.LoggerUtil.logger;
public class Connection {
    public void executeQuery (String query) {
        logger.info("Executing query: " + query);
    }
}
