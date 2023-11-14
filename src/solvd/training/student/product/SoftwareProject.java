package solvd.training.student.product;

public class SoftwareProject extends Project {

    public SoftwareProject(String name, String description) {
        super(name, description);
    }

    public final void specificProjectDescription() {
        System.out.println("Description for SoftwareProject.");
    }
}
