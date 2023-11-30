package solvd.training.student.employees;

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
        System.out.println("Working");
    }

    @Override
    public void finishWork() {
        System.out.println("Finished working");
    }

    @Override
    public void takeBreak() {
        System.out.println("Need a break.");
    }

    @Override
    public void communicateWith(Employee employee) {
        System.out.println("Communicating with " + employee.getFirstName() + " " + employee.getLastName());
    }

    @Override
    public void planProject() {
        System.out.println("Planning the project.");
    }

    @Override
    public void scheduleProject() {
        System.out.println("Scheduling the project.");
    }

    @Override
    public void monitorProject() {
        System.out.println("Monitoring the project.");
    }


    public void addEmployeeToTeam(OfficeEmployee employee) {
        projectTeam.add(employee);
    }

    @Override
    public void meetingAboutProject(Project project) {
        System.out.println("Meeting about " + project.getName());
    }

    @Override
    public void workOnTask() {
        System.out.println("Working on task.");
    }

}
