package repository.onetomanyUni;

import entity.onetomanyUni.Book;
import entity.onetomanyUni.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class TestSave {
    public static EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("one2many");
    public  static EntityManager entityManager=entityManagerFactory.createEntityManager();
    public static EntityTransaction entityTransaction=entityManager.getTransaction();

    public static void saveNewData(Student student){
        entityTransaction.begin();

        /*
        * since we are using CascadeType.PERSIST
        * explicitly not necessary to persist the non-owning entities
        *
        * So I just commented this persist Book object , it's not necessary now.
        *
        *
        * */

//        student.getBookList().forEach(book -> entityManager.persist(book));
        entityManager.persist(student);
        entityTransaction.commit();
    }


    /*
    public static void main(String[] args) {

        Student student=new Student();

        student.setSName("Swapan Samanta");
        student.setRollNo(1);
        List<Book> booksList=new ArrayList<>();

        //create book objects
        Book book1=new Book();
        book1.setBookId(101);
        book1.setBookName("Science");

        Book book2=new Book();
        book2.setBookName("Bengali");
        book2.setBookId(102);

        booksList.add(book1);
        booksList.add(book2);

        student.setBookList(booksList);

        entityTransaction.begin();
        entityManager.persist(book1);
        entityManager.persist(book2);
        entityManager.persist(student);
        entityTransaction.commit();

        System.out.println("Success");


    }
    */

}
