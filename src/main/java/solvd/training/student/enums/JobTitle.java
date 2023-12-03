package solvd.training.student.enums;

public enum JobTitle {
    SOFTWARE_ENGINEER("Software Engineer"),
    MANAGER("Manager"),
    ACCOUNTANT("Accountant");

    private final String title;

    JobTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
