package solvd.training.student.employees;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {

    private static List<OfficeEmployee> employees;

    public EmployeeRepository() {
        employees = new ArrayList<>();
    }

    public void addEmployee(OfficeEmployee employee) {
        employees.add(employee);
    }

    public boolean removeEmployee(OfficeEmployee employee) {
        return employees.remove(employee);
    }

    public static OfficeEmployee findEmployeeById(int employeeId) {
        for (OfficeEmployee employee : employees) {
            if (employee.getIdOfEmployee() == employeeId) {
                return employee;
            }
        }
        return null;
    }


}
