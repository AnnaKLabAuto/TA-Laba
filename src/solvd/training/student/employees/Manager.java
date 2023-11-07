package solvd.training.student.employees;



import solvd.training.student.company.Department;
import solvd.training.student.product.ProjectManagement;
import solvd.training.student.product.ProjectWork;

import java.util.List;

public class Manager extends Employee implements WorkFlow, TeamMember, ProjectManagement, ProjectWork {

    public Manager(String firstName, String lastName, Department department, String title, List<OfficeEmployee> employeeList) {
        super(firstName, lastName, department, title);
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

    @Override
    public void metingAboutProject() {}

    @Override
    public void addTaskToEmployee(OfficeEmployee employee) {
        System.out.println("Add task to " + employee.getFirstName() + " " + employee.getLastName());
    }

    @Override
    public void workOnTask() {}

}
