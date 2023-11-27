package solvd.training.student.enums;

public enum JobTitle {
    SOFTWARE_ENGINEER(80000),
    PRODUCT_MANAGER(90000),
    ACCOUNTANT(100000);

    private int baseSalary;

    JobTitle(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getBaseSalary() {
        return baseSalary;
    }
}
