package repository.onetomanyUni;

import entity.onetomanyUni.Book;
import entity.onetomanyUni.Student;

import java.util.List;

import static repository.onetomanyUni.TestSave.entityManager;
import static repository.onetomanyUni.TestSave.entityTransaction;

public class TestUpdate {
    public static void main(String[] args) {
        int id=1;
        Student student=entityManager.find(Student.class,id);
        if(student != null){
            List<Book> bookList=student.getBookList();
            String bookName="Math";
          /*
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

            */

            bookList.stream()
                    .filter(b -> b.getBookName().equals(bookName))
                    .findFirst()
                    .ifPresentOrElse(book -> {
                        entityTransaction.begin();
                        book.setBookName("Physics");
                        entityManager.merge(book);
                        entityTransaction.commit();
                        System.out.println("Successfully updated");
                    }, () -> System.out.println("Not updated"));
        }else {
            System.out.println("Id is not registered in our System.");
        }
    }
}
