package repository.onetomanyUni;

import entity.onetomanyUni.Book;
import entity.onetomanyUni.Student;

import java.util.List;

import static repository.onetomanyUni.TestSave.entityManager;
import static repository.onetomanyUni.TestSave.entityTransaction;

public class TestUpdate {

    public static void updateStudentBook(int sId,String bookName,String newBookName){
        Student student=entityManager.find(Student.class,sId);
        if(student != null){
            List<Book> bookList=student.getBookList();
            bookList.stream()
                    .filter(b -> b.getBookName().equals(bookName))
                    .findFirst()
                    .ifPresentOrElse(book -> {
                        entityTransaction.begin();
                        book.setBookName(newBookName);
                        entityManager.merge(book);
                        entityTransaction.commit();
                        System.out.println("Successfully updated");
                    }, () -> System.out.println("Not updated"));
        }else {
            System.out.println("Id is not registered in our System.");
        }

    }

    /*
    public static void main(String[] args) {
          int sId=1;
          String bookName="Java";
        Student student=entityManager.find(Student.class,sId);
        if(student != null){
            List<Book> bookList=student.getBookList();

            for(Book book:bookList){
                if(book.getBookName().equals(bookName)){
                    book.setBookName("Math");
                    entityTransaction.begin();
                    entityManager.merge(book);
                    entityTransaction.commit();
                    System.out.println("Successfully updated");
                }else{
                    System.out.println("Not updated");
                }
            }
    }
           */
}
