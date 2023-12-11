package solvd.training.student.employees;

import static solvd.training.student.logger.LoggerUtil.logger;
import solvd.training.student.company.Department;
import solvd.training.student.enums.EmploymentStatus;
import solvd.training.student.enums.JobTitle;
import solvd.training.student.enums.LeaveType;
import solvd.training.student.product.Project;
import solvd.training.student.product.ProjectManageable;
import solvd.training.student.product.ProjectWorkable;

import java.util.HashSet;
import java.util.Set;

public class Manager extends Employee implements Workable, Communicatable, ProjectManageable, ProjectWorkable {

    private final Set<OfficeEmployee> projectTeam;

    public Manager(String firstName, String lastName, Department department, JobTitle title, EmploymentStatus status,
                   LeaveType type, int salary) {
        super(firstName, lastName, department, title, status, type, salary);
        this.projectTeam = new HashSet<>();
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
    public void communicateWith(Employee employee) {
        logger.info("Communicating with " + employee.getFirstName() + " " + employee.getLastName());
    }

    @Override
    public void planProject() {
        logger.info("Planning the project.");
    }

    @Override
    public void scheduleProject() {
        logger.info("Scheduling the project.");
    }

    @Override
    public void monitorProject() {
        logger.info("Monitoring the project.");
    }

    public void addEmployeeToTeam(OfficeEmployee employee) {
        projectTeam.add(employee);
    }

    @Override
    public void meetingAboutProject(Project project) {
        logger.info("Meeting about " + project.getName());
    }

    @Override
    public void workOnTask() {
        logger.info("Working on task.");
    }

}
