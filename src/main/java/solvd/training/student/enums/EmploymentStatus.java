package solvd.training.student.enums;

public enum EmploymentStatus {
    FULL_TIME(40),
    PART_TIME(20),
    CONTRACTOR(0);

    private int workingHours;

    EmploymentStatus(int workingHours) {
        this.workingHours = workingHours;
    }

    public int getWorkingHours() {
        return workingHours;
    }
}
