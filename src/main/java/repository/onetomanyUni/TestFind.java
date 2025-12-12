package repository.onetomanyUni;

import entity.onetomanyUni.Book;
import entity.onetomanyUni.Student;

import java.util.List;

import static repository.onetomanyUni.TestSave.entityManager;

public class TestFind {

    public static Student findStudentDetailsById(int studentId){
        return entityManager.find(Student.class,studentId);
    }

    public static Book findBookDetailsById(int bookId){
        return entityManager.find(Book.class,bookId);
    }


    public static List<Book> findStudentBooks(int studentId){

        Student student=findStudentDetailsById(studentId);

        if(student!=null){
            if(!student.getBookList().isEmpty()){

                return student.getBookList();
//                student.getBookList().forEach(System.out::println);
            }
            else{
                System.out.println("No books is there");
            }
        }else{
            System.out.println("StudentID is Not Registered");
        }
        return null;
    }

}
