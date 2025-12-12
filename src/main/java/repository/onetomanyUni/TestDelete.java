package repository.onetomanyUni;

import entity.onetomanyUni.Book;
import entity.onetomanyUni.Student;

import javax.persistence.Query;
import java.util.List;

import static repository.onetomanyUni.TestSave.entityManager;
import static repository.onetomanyUni.TestSave.entityTransaction;

public class TestDelete {

    public static void deleteBookDataByBookName(String bookName){
        //to delete book data first we need to remove the particular book  from student's bookList.
        //then update the students who associated with this book
        //then  delete book from database

        String findParticularBook="Select b from Book b where b.bookName=:bookName";
        Query query=entityManager.createQuery(findParticularBook);
        query.setParameter("bookName",bookName);
        Book bookToRemove=(Book) query.getSingleResult();

        String findParticularStudents="SELECT s FROM Student s WHERE :book MEMBER OF s.bookList";
        Query query1=entityManager.createQuery(findParticularStudents);
        query1.setParameter("book",bookToRemove);
        List<Student>studentList=query1.getResultList();

        entityTransaction.begin();
        // Remove the book from every student's bookList
        studentList.forEach(student -> {
            student.getBookList().removeIf(book -> book.getBookName().equals(bookName));
            entityManager.merge(student);
        });

        entityManager.remove(bookToRemove);
        entityTransaction.commit();

        System.out.println("Successfully removed the book from studentbookList and database ");

    }

    public static void deleteBooKFromStudent(int studentId,String bookName){
        Student student=entityManager.find(Student.class,studentId);
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
