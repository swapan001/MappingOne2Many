package repository.manytooneBi;

import entity.onetomanyBi.Employee;
import entity.onetomanyBi.Manager;

import java.util.ArrayList;
import java.util.List;

import static repository.onetomanyUni.TestSave.entityManager;
import static repository.onetomanyUni.TestSave.entityTransaction;

public class TestSave {
    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<>();

        Employee emp1 = new Employee();
        emp1.setEmpId(4);
        emp1.setEmpName("Moulik K");
        emp1.setManager(null);

        Employee emp2 = new Employee();
        emp2.setEmpId(5);
        emp2.setEmpName("Surya Raj");
        emp2.setManager(null);

        Employee emp3 = new Employee();
        emp3.setEmpId(6);
        emp3.setEmpName("N Bose");
        emp3.setManager(null);

        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);

        Manager mgr = new Manager();
        mgr.setMgrId(201);
        mgr.setMgrName("Raajkumar M");
        mgr.setEmployees(employeeList);

        // Set manager reference on each employee (owning side)
        emp1.setManager(mgr);
        emp2.setManager(mgr);
        emp3.setManager(mgr);

        entityTransaction.begin();

        //  no cascade:  so persist manager and employees manually
        entityManager.persist(mgr);
        entityManager.persist(emp1);
        entityManager.persist(emp2);
        entityManager.persist(emp3);

        entityTransaction.commit();

        System.out.println("Success");
    }
}

