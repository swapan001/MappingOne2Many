package repository.onetomanyUni;

import entity.onetomanyUni.Book;
import entity.onetomanyUni.Student;

import java.util.List;

import static repository.onetomanyUni.TestSave.entityManager;
import static repository.onetomanyUni.TestSave.entityTransaction;

public class TestDelete {
    public static void main(String[] args) {
        String bookName="Bengali";
        int id=1;
        Student student=entityManager.find(Student.class,id);
        if(student!=null){
            List<Book> bookList=student.getBookList();
            if(!bookList.isEmpty()){
                for(Book book:bookList){
                    if(book.getBookName().equals(bookName)){
                        bookList.remove(book);
                        student.getBookList().remove(book);
                        entityTransaction.begin();
                        entityManager.merge(student);
                        entityManager.remove(book);
                        entityTransaction.commit();
                        System.out.println(" successfully Deleted");
                        break;
                    }else{
                        System.out.println("Books is not associated with this student");
                    }
                }


            }else{
                System.out.println("No book is associated with student: "+student.getSName());
            }

        }

    }
}
