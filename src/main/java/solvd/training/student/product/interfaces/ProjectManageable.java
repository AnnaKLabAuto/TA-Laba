package solvd.training.student.product.interfaces;

import solvd.training.student.employees.OfficeEmployee;

public interface ProjectManageable {
    void planProject();
    void scheduleProject();
    void monitorProject();
    void addEmployeeToProject(OfficeEmployee employee);

}
