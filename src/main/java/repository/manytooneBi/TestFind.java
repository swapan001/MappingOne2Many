package repository.manytooneBi;

import entity.onetomanyBi.Employee;
import entity.onetomanyBi.Manager;

import javax.persistence.Query;
import java.util.List;
import java.util.Queue;

import static repository.onetomanyUni.TestSave.entityManager;

public class TestFind {

    public static List<Employee> findEmployeesAssignWithManager(int mgrId){
        Manager manager=entityManager.find(Manager.class,mgrId);
        if(manager != null){
            List<Employee> employeeList=manager.getEmployees();
            if(!employeeList.isEmpty()){
//                employeeList.forEach(System.out::println);
                return employeeList;
            }else{
                System.out.println("No employee is assigned with the manager...");
            }
        }else{
            System.out.println("No manager is assigned with the id: "+mgrId);
        }
        return null;
    }


    public static Employee findEmployeeById(int empId){
        return entityManager.find(Employee.class,empId);
    }

    public static Manager findManagerDetailsAssignWithEmployeeById(int empId){

        Employee employee=findEmployeeById(empId);
        if(employee!=null){
            if(employee.getManager() != null){
                return employee.getManager();
            }else{
                System.out.println("Manager is not assigned with this employee.");
            }
        }else{
            System.out.println("Employee is not found with this id: "+empId);
        }

        return null;

    }

    public static void displayManagerAssignedWithEmployeeByEmpName(String empName){
       List<Employee>employeeList=findEmployeeDetailsByEmpName(empName);
        employeeList.forEach(emp -> {
            if(emp != null){
                System.out.println(emp.getEmpName()+" assigned with "+emp.getManager());
            }else{
                System.out.println(emp.getEmpName()+" assigned with "+emp.getManager()+"i.e not assigned with any manager");
            }

        }
        );

    }

    public static List<Employee> findEmployeeDetailsByEmpName(String empName){
        String jpql="select emp from Employee emp where emp.empName=:empName";
        Query query=entityManager.createQuery(jpql);
        query.setParameter("empName",empName);

        return query.getResultList();
    }
    public static void main(String[] args) {
        //program to find all employee details of a manager
        int id=201;
        Manager manager=entityManager.find(Manager.class,id);
        if(manager != null){
            List<Employee> employeeList=manager.getEmployees();
            if(!employeeList.isEmpty()){
                employeeList.forEach(System.out::println);
            }else{
                System.out.println("No employee is assigned with the manager...");
            }
        }else{
            System.out.println("No manager is assigned with the id: "+id);
        }

        System.out.println("The manager details of empId: "+5+" is => "+findManagerDetailsAssignWithEmployeeById(5));

        displayManagerAssignedWithEmployeeByEmpName("Sahil Mallik");


    }
}
