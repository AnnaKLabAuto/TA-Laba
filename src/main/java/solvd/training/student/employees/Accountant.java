package solvd.training.student.employees;

import solvd.training.student.company.Department;
import solvd.training.student.enums.EmploymentStatus;
import solvd.training.student.enums.JobTitle;
import solvd.training.student.enums.LeaveType;

public class Accountant extends Employee{
    public Accountant(String firstName, String lastName, Department department, JobTitle title, EmploymentStatus status,
                      LeaveType type, int salary) {
        super(firstName, lastName, department, title, status, type, salary);
    }
}
