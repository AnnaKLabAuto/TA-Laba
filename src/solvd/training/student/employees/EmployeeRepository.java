package solvd.training.student.employees;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {

    private List<OfficeEmployee> employees;

    public EmployeeRepository() {
        employees = new ArrayList<>();
    }

    public void addEmployee(OfficeEmployee employee) {
        employees.add(employee);
    }

    public boolean removeEmployee(OfficeEmployee employee) {
        return employees.remove(employee);
    }

    public OfficeEmployee findEmployeeById(int employeeId) {
        return employees.stream()
                .filter(employee -> employee.getIdOfEmployee() == employeeId)
                .findFirst()
                .orElse(null);
    }

}
