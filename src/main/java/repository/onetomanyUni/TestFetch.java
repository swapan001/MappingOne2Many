package repository.onetomanyUni;

import entity.onetomanyUni.Book;
import entity.onetomanyUni.Student;

import java.util.List;

import static repository.onetomanyUni.TestSave.entityManager;
import static repository.onetomanyUni.TestSave.entityTransaction;

public class TestFetch {
    public static void main(String[] args) {
        int sId=2;
        Student student=entityManager.find(Student.class,sId);
//        List<Book> books=student.getBookList();
        List<Book>tempBooks=student.getBookList();
        student.setBookList(null);

        entityTransaction.begin();
        entityManager.merge(student);
        entityTransaction.commit();

//        System.out.println(tempBooks);
        System.out.println(tempBooks);
        System.out.println(student.getBookList());

    }
}
