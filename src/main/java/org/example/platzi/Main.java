package org.example.platzi;

import org.example.platzi.Util.UtilEntity;
import org.example.platzi.entity.Employee;

import javax.persistence.EntityManager;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        EntityManager en = UtilEntity.getEntityManager();
        List<Employee> employees = en.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
        System.out.println("----- Listar todos -----");
        employees.forEach(System.out::println);

        System.out.println("--------- Buscar Uno ---------");
        int employeeId = 3;
        Employee employee = en.find(Employee.class, employeeId);
        System.out.println("Empleado encontrado" + employee);

        /*System.out.println("------- Creación de nuevo usuario --------");
        Employee newEmployee = new Employee();
        newEmployee.setFirstName("Carlitos");
        newEmployee.setPa_surname("Torres");
        newEmployee.setMa_surname("Perez");
        newEmployee.setEmail("carlitos@gmail.com");
        newEmployee.setSalary(1300F);


        en.getTransaction().begin();
        en.persist(newEmployee);
        en.getTransaction().commit();

        System.out.println("Nuevo empleado creado " + newEmployee);*/

        /*System.out.println("--------- Actualizar Usuario ---------");
        int employeeUpdateId = 2;
        Employee employeeToUpdate = en.find(Employee.class, employeeUpdateId);
        System.out.println("------ Empleado a modificar ------" + employeeToUpdate);

        employeeToUpdate.setFirstName("Mikhael");
        employeeToUpdate.setPa_surname("Torres");
        employeeToUpdate.setSalary(2200F);

        // Uso de las trasacciones
        en.getTransaction().begin();
        en.merge(employeeToUpdate);
        en.getTransaction().commit();

        System.out.println("Empleado actualizado " + employeeToUpdate);*/

        System.out.println("------- Eliminando Usuario -------");
        int employeeToDeleteId = 1;
        Employee employeeToDelete = en.find(Employee.class, employeeToDeleteId);

        System.out.println("------ Empleado a eliminar -----" + employeeToDelete);

        en.getTransaction().begin();
        en.remove(employeeToDelete);
        en.getTransaction().commit();
        en.close();
    }
}