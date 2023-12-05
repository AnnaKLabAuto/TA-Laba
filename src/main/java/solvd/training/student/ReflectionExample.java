package solvd.training.student;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solvd.training.student.company.Department;
import solvd.training.student.enums.EmploymentStatus;
import solvd.training.student.enums.JobTitle;
import solvd.training.student.enums.LeaveType;
import solvd.training.student.services.EmployeeService;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionExample {
    public static void main(String[] args) {

        Logger logger = LogManager.getLogger(EmployeeService.class);

        try {
        Class<?> managerClass = Class.forName("solvd.training.student.employees.Manager");

        for (Field field : managerClass.getDeclaredFields()) {
            logger.info(field.getName());
        }

        for (Constructor<?> constructor : managerClass.getDeclaredConstructors()) {
            logger.info(constructor.getName());
            for (Class<?> parameterType : constructor.getParameterTypes()) {
                logger.info("  " + parameterType.getName());
            }
        }

        for (Method method : managerClass.getDeclaredMethods()) {
            logger.info(method.getName());
            logger.info("  " + method.getReturnType().getName());
            for (Class<?> parameterType : method.getParameterTypes()) {
                logger.info("  " + parameterType.getName());
            }
        }

        Department itDepartment = new Department("IT", "Example of description");
        Constructor<?> constructor = managerClass.getConstructor(String.class, String.class, Department.class, JobTitle.class,
                EmploymentStatus.class, LeaveType.class, int.class);

        Object managerObject = constructor.newInstance("John", "Smith", itDepartment, JobTitle.MANAGER, EmploymentStatus.FULL_TIME, LeaveType.NO_LEAVE, 10000);
        Method getNameMethod = managerClass.getMethod("getFirstName");
        String name = (String) getNameMethod.invoke(managerObject);
        logger.info("Manager's name: " + name);
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            logger.error("An error occurred while reflecting on the Manager class:", e);
        } catch (InstantiationException e) {
            logger.error("Failed to instantiate Manager object due to InstantiationException:", e);
        }
    }
}
