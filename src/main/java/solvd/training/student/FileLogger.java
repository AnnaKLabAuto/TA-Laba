package solvd.training.student;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.FileAppender;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.LoggerConfig;
import org.apache.logging.log4j.core.layout.PatternLayout;

public class FileLogger {

    private static final Logger logger = LogManager.getLogger(FileLogger.class);

    public static void main(String[] args) {
        Appender appender = FileAppender.newBuilder()
                .withFileName("logs/output.log")
                .withLayout(PatternLayout.newBuilder().withPattern("%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n").build())
                .setName("File")
                .build();

        try {
            appender.start();
            LoggerContext context = (LoggerContext) LogManager.getContext(false);
            Configuration config = context.getConfiguration();
            LoggerConfig loggerConfig = config.getRootLogger();
            loggerConfig.addAppender(appender, Level.INFO, null);
            context.updateLoggers();
            logger.info("This is an info message");
            logger.debug("This is a debug message");
        } finally {
            appender.stop();
        }
    }
}