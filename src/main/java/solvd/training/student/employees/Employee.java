package solvd.training.student.employees;

import solvd.training.student.company.Department;
import solvd.training.student.enums.EmploymentStatus;
import solvd.training.student.enums.JobTitle;
import solvd.training.student.enums.LeaveType;

import java.util.Objects;

public abstract class Employee {

    private static int nextEmployeeId;
    private int idOfEmployee;
    private final String firstName;
    private final String lastName;
    private final Department department;
    private final JobTitle title;
    private final EmploymentStatus status;
    private final LeaveType type;

    static {
        nextEmployeeId = 1;
    }

    public Employee(String firstName, String lastName, Department department, JobTitle title, EmploymentStatus status, LeaveType type) {
        this.idOfEmployee = nextEmployeeId++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.title = title;
        this.status = status;
        this.type = type;
    }

    public int getIdOfEmployee() {
        return idOfEmployee;
    }

    public void setIdOfEmployee(int idOfEmployee) {
        this.idOfEmployee = idOfEmployee;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "idOfEmployee=" + idOfEmployee +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department=" + department +
                ", title='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return idOfEmployee == employee.idOfEmployee && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(department, employee.department) && Objects.equals(title, employee.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOfEmployee, firstName, lastName, department, title);
    }
}
