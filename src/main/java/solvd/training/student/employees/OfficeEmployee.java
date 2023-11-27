package solvd.training.student.employees;


import solvd.training.student.company.Department;
import solvd.training.student.employees.interfaces.Communicatable;
import solvd.training.student.employees.interfaces.Workable;
import solvd.training.student.enums.EmploymentStatus;
import solvd.training.student.enums.JobTitle;
import solvd.training.student.enums.LeaveType;

public class OfficeEmployee extends Employee implements Workable, Communicatable {

    public OfficeEmployee(String firstName, String lastName, Department department, JobTitle title, EmploymentStatus status, LeaveType type, int salary) {
        super(firstName, lastName, department, title, status, type, salary);
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
    public void communicateWith(Employee employee)  {
        System.out.println("Communicating with " + employee.getFirstName() + " " + employee.getLastName());
    }
}
