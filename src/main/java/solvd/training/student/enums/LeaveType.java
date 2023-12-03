package solvd.training.student.enums;

import org.apache.logging.log4j.Logger;
import solvd.training.student.logger.LoggerUtil;

public enum LeaveType {
    NO_LEAVE(0),
    SICK_LEAVE(5),
    VACATION_LEAVE(10),
    PERSONAL_LEAVE(2);

    private final int maxDaysPerYear;

    LeaveType(int maxDaysPerYear) {
        this.maxDaysPerYear = maxDaysPerYear;
    }

    public int getMaxDaysPerYear() {
        return maxDaysPerYear;
    }
}
