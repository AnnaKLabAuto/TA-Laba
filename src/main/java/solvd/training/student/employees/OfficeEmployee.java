package solvd.training.student.employees;


import solvd.training.student.company.Department;

public class OfficeEmployee extends Employee implements WorkFlow, TeamMember{

    public OfficeEmployee(String firstName, String lastName, Department department, String title) {
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
    public void communicateWith(Employee employee)  {
        System.out.println("Communicating with " + employee.getFirstName() + " " + employee.getLastName());
    }
}
