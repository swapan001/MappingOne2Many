package repository.manytooneBi;

import entity.onetomanyBi.Employee;
import entity.onetomanyBi.Manager;

import static repository.onetomanyUni.TestSave.entityManager;
import static repository.onetomanyUni.TestSave.entityTransaction;

/*
*import static em
* import static et
* we will write  thw logic inside this
*
**/
public class TestSaveUsingCascade {

    public static void main(String[] args) {
        Employee emp1=new Employee();
        emp1.setEmpId(3);
        emp1.setEmpName("Dilip Pm");

        Employee emp2=new Employee();
        emp2.setEmpId(4);
        emp2.setEmpName("Sayan sr");

        Manager mgr=new Manager();

        mgr.setMgrId(303);
        mgr.setMgrName("Koyena");
        emp1.setManager(mgr);
        emp2.setManager(mgr);
        entityTransaction.begin();
        entityManager.persist(emp2);
        entityManager.persist(emp1);
        entityTransaction.commit();

        System.out.println("Success");

    }
}
