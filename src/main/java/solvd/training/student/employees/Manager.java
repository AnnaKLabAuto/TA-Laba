package solvd.training.student.employees;

import static solvd.training.student.utils.LoggerUtil.log;
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
        log.info("Working");
    }

    @Override
    public void finishWork() {
        log.info("Finished working");
    }

    @Override
    public void takeBreak() {
        log.info("Need a break.");
    }

    @Override
    public void communicateWith(Employee employee) {
        log.info("Communicating with " + employee.getFirstName() + " " + employee.getLastName());
    }

    @Override
    public void planProject() {
        log.info("Planning the project.");
    }

    @Override
    public void scheduleProject() {
        log.info("Scheduling the project.");
    }

    @Override
    public void monitorProject() {
        log.info("Monitoring the project.");
    }

    public void addEmployeeToTeam(OfficeEmployee employee) {
        projectTeam.add(employee);
    }

    @Override
    public void meetingAboutProject(Project project) {
        log.info("Meeting about " + project.getName());
    }

    @Override
    public void workOnTask() {
        log.info("Working on task.");
    }

}
