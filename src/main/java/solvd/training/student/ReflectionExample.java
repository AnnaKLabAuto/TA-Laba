package solvd.training.student;

import static solvd.training.student.utils.LoggerUtil.log;
import solvd.training.student.company.Department;
import solvd.training.student.enums.EmploymentStatus;
import solvd.training.student.enums.JobTitle;
import solvd.training.student.enums.LeaveType;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionExample {
    public static void main(String[] args) {

        try {
        Class<?> managerClass = Class.forName("solvd.training.student.employees.Manager");

        for (Field field : managerClass.getDeclaredFields()) {
            log.info(field.getName());
        }

        for (Constructor<?> constructor : managerClass.getDeclaredConstructors()) {
            log.info(constructor.getName());
            for (Class<?> parameterType : constructor.getParameterTypes()) {
                log.info("  " + parameterType.getName());
            }
        }

        for (Method method : managerClass.getDeclaredMethods()) {
            log.info(method.getName());
            log.info("  " + method.getReturnType().getName());
            for (Class<?> parameterType : method.getParameterTypes()) {
                log.info("  " + parameterType.getName());
            }
        }

        Department itDepartment = new Department("IT", "Example of description");
        Constructor<?> constructor = managerClass.getConstructor(String.class, String.class, Department.class, JobTitle.class,
                EmploymentStatus.class, LeaveType.class, int.class);

        Object managerObject = constructor.newInstance("John", "Smith", itDepartment, JobTitle.MANAGER, EmploymentStatus.FULL_TIME, LeaveType.NO_LEAVE, 10000);
        Method getNameMethod = managerClass.getMethod("getFirstName");
        String name = (String) getNameMethod.invoke(managerObject);
        log.info("Manager's name: " + name);
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            log.error("An error occurred while reflecting on the Manager class:", e);
        } catch (InstantiationException e) {
            log.error("Failed to instantiate Manager object due to InstantiationException:", e);
        }
    }
}
