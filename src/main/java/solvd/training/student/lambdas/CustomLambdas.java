package solvd.training.student.lambdas;

import solvd.training.student.employees.Employee;
import solvd.training.student.product.Task;
import java.util.function.Predicate;

//public class CustomLambdas {
//
//        public <E extends Employee> Predicate<E> hasTaskEmployee(Task<E> task) {
//            return (employee) -> {
//                if (!task.getAssignedEmployee().equals(employee)) {
//                    return false;
//                }
//                return true;
//            };
//        }
//}


//    Consumer<Employee> giveRaise = (employee) -> {
//        double currentSalary = employee.getSalary();
//        double newSalary = currentSalary * 1.1;
//        employee.setSalary(newSalary);
//        System.out.println("Employee " + employee.getFirstName() + " " + employee.getLastName() + " has received a raise of 10%.");
//    };
//
//    Predicate<Employee> isEligibleForRaise(int minimumPerformanceRating) {
//        return (employee) -> employee.getPerformanceRating() >= minimumPerformanceRating;
//    }

    //Supplier<Employee> getEmployeeById(int id) ??
    //Function<Employee, String> generateEmployeeEmail(Employee employee)
    //BiFunction<Employee, Task, Boolean> canAssignTask(Employee employee, Task task) ??


//giveRaise.accept(employee);
