package solvd.training.student.product;

import solvd.training.student.employees.OfficeEmployee;

public interface ProjectManagement {
    void planProject();
    void scheduleProject();
    void monitorProject();
    void addEmployeeToProject(OfficeEmployee employee);

}
