package solvd.training.student.enums;

public enum TaskPriority {
    HIGH(1),
    MEDIUM(2),
    LOW(3);

    private final int priorityLevel;

    static {
        System.out.println("Initializing task priority...");
    }

    TaskPriority(int priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    public int getPriorityLevel() {
        return priorityLevel;
    }
}
