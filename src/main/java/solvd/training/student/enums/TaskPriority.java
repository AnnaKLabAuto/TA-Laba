package solvd.training.student.enums;

public enum TaskPriority {
    HIGH(1),
    MEDIUM(2),
    LOW(3);

    static {
        System.out.println("Initializing task priority...");
    }

    private final int priorityLevel;

    TaskPriority(int priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    public int getPriorityLevel() {
        return priorityLevel;
    }
}
