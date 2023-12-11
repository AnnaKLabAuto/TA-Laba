package solvd.training.student.employees;

import static solvd.training.student.logger.LoggerUtil.logger;
import solvd.training.student.company.Department;
import solvd.training.student.enums.EmploymentStatus;
import solvd.training.student.enums.JobTitle;
import solvd.training.student.enums.LeaveType;

public class OfficeEmployee extends Employee implements Workable, Communicatable {


    public OfficeEmployee(String firstName, String lastName, Department department, JobTitle title, EmploymentStatus status,
                          LeaveType type, int salary) {
        super(firstName, lastName, department, title, status, type, salary);
    }

    @Override
    public void startWork() {
        logger.info("Working");
    }

    @Override
    public void finishWork() {
        logger.info("Finished working");
    }

    @Override
    public void takeBreak() {
        logger.info("Need a break.");
    }

    @Override
    public void communicateWith(Employee employee)  {
        logger.info("Communicating with " + employee.getFirstName() + " " + employee.getLastName());
    }


}
