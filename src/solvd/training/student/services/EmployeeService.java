package solvd.training.student.services;

import solvd.training.student.employees.Employee;


import java.util.ArrayList;

public class EmployeeService {

    private ArrayList<Employee> employeeList;

    public EmployeeService() {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void deleteEmployee(Employee employee) {
        employeeList.remove(employee);
    }

    public void displayEmployeeInfo() {
        for (Employee employee : employeeList) {
            System.out.println("Name: " + employee.getFirstName());
            System.out.println("Last Name: " + employee.getLastName());
            System.out.println("Title: " + employee.getTitle());
            System.out.println("In department: " + employee.getDepartment());
            System.out.println();
        }
    }
}