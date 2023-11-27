package solvd.training.student.enums;

public enum JobTitle {
    SOFTWARE_ENGINEER("software Enginner"),
    PRODUCT_MANAGER("Product Manager"),
    ACCOUNTANT("Accountant");

    private String title;

    JobTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
