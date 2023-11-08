package solvd.training.student.employees;

import solvd.training.student.company.Department;
import solvd.training.student.product.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Employee {

    private static int nextEmployeeId;
    private int idOfEmployee;
    private String firstName;
    private String lastName;
    private Department department;
    private String title;
    private List<Task> listOfTask;

    static {
        nextEmployeeId = 1;
    }

    public Employee(String firstName, String lastName, Department department, String title) {
        this.idOfEmployee = nextEmployeeId++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.title = title;
        this.listOfTask = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Department getDepartment() {
        return department;
    }

    public String getTitle() {
        return title;
    }

    public int getIdOfEmployee() {
        return idOfEmployee;
    }

    public void setIdOfEmployee(int idOfEmployee) {
        this.idOfEmployee = idOfEmployee;
    }

    public void addTask(Task task) {
        listOfTask.add(task);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
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
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(department, employee.department) && Objects.equals(title, employee.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, department, title);
    }
}
