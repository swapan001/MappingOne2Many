package repository.onetomanyUni;

import entity.onetomanyUni.Student;

import static repository.onetomanyUni.TestSave.entityManager;

public class TestFind {
    public static void main(String[] args) {
        int id=1;
        Student student=entityManager.find(Student.class,id);

        if(student!=null){
            if(!student.getBookList().isEmpty()){
                student.getBookList().forEach(System.out::println);
            }
            else{
                System.out.println("No books is there");
            }
        }else{
            System.out.println("Not found");
        }


    }
}
