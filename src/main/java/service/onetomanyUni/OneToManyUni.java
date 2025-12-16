package service.onetomanyUni;

import entity.onetomanyUni.Book;
import entity.onetomanyUni.Student;
import lombok.SneakyThrows;
import repository.onetomanyUni.TestDelete;
import repository.onetomanyUni.TestFind;
import repository.onetomanyUni.TestSave;
import repository.onetomanyUni.TestUpdate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static repository.onetomanyUni.TestFind.*;
import static repository.onetomanyUni.TestSave.*;

public class OneToManyUni {
    private static final BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
   @SneakyThrows
    private static void crud(){
        boolean bool=true;
        while(bool){
            System.out.println("::::::::::Options::::::");
            System.out.print(
                    "1 to save new data\n" +
                            "2 to find Book by BookId\n" +
                            "3 to find Student by StudentId\n" +
                            "4 to find StudentBooks by studentId\n" +
                            "5 to update StudentBook\n" +
                            "6 to delete Book from Student\n" +
                            "7 to delete Book data by BookName\n" +
                            "8 to display all Book data\n" +
                            "9 to display all Student data\n" +
                            "0 to Exit\n" +
                            "Enter option: "
            );
            try{
                int option=Integer.parseInt(br.readLine());

                System.out.println();
                switch (option){
                    case 1:saveNewDataWithExceptionHandeling();
                        break;
                    case 2:findBookById();
                        break;
                    case 3:findStudentById();
                        break;
                    case 4:findStudentBookByStudentId();
                        break;
                    case 5:updateStudentBook();
                        break;
                    case 6:deleteBooKFromStudent();
                        break;
                    case 7:deleteBookDataByBookName();
                        break;
                    case 8:displayAllBookData();
                        break;
                    case 9:displayAllStudentData();
                        break;


                    case 0:
                        System.out.println("Okk we'll meet soon.....Bye ): ");
                        bool=false;
                        break;
                    default:
                        System.out.println("please choose correct option!");

                }
            }
            catch (NumberFormatException e){
                System.out.println("!!!!!!!Enter a vailid number!!!!!!!");
            }


        }


    }
    @SneakyThrows
    private static void saveNewData(){
        Student student=new Student();
        System.out.print("Enter newStudent id:");
        student.setRollNo(Integer.parseInt(br.readLine()));
        System.out.print("\nEnter Student name: ");
        student.setSName(br.readLine());
        List<Book> bookList=new ArrayList<>();

        System.out.print("\n How many books you want to assigned: ");
        int count=Integer.parseInt(br.readLine());
        for(int i=0;i<count;i++){
            Book book=new Book();
            System.out.print("Enter Book Id: ");
            book.setBookId(Integer.parseInt(br.readLine()));
            System.out.print("\nEnter Book name: ");
            book.setBookName(br.readLine());
            bookList.add(book);
        }
        student.setBookList(bookList);

        TestSave.saveNewData(student);
        System.out.println("Successfully Saved.");
    }

    private static void saveNewDataWithExceptionHandeling(){
        try {
                saveNewData();
        } catch (Exception e) {
            System.out.println("---------Book already exists in DB! Cannot insert duplicate.--------");
            entityTransaction.rollback();

                // Optionally fetch the existing book and link to student

                e.printStackTrace();

        }
    }

    @SneakyThrows
    private static void findStudentById(){
        System.out.print("Enter studentId: ");
        System.out.println(findStudentDetailsById(Integer.parseInt(br.readLine())));
    }


    @SneakyThrows
    private static void findBookById(){
        System.out.print("Enter BookId: ");
        System.out.println(findBookDetailsById(Integer.parseInt(br.readLine())));
    }

    @SneakyThrows
    private static void findStudentBookByStudentId(){
        System.out.print("Enter StudentId: ");
        findStudentBooks(Integer.parseInt(br.readLine())).forEach(System.out::println);
    }

    @SneakyThrows
    private static void updateStudentBook(){
        System.out.print("Enter studentId: ");
        int sId=Integer.parseInt(br.readLine());
        System.out.print("\nEnter the bookName which get update :");
        String bookToUpdate=br.readLine();
        System.out.print("\nEnter the bookName to update with :");
        String updatedBookName= br.readLine();
        TestUpdate.updateStudentBook(sId,bookToUpdate,updatedBookName);
    }
    @SneakyThrows
    private static void deleteBookDataByBookName(){
        System.out.print("Enter the book name to delete: ");
        TestDelete.deleteBookDataByBookName(br.readLine());
    }
    @SneakyThrows
    private static void  deleteBooKFromStudent(){
        System.out.print("Enter studentId: ");
        int sId=Integer.parseInt(br.readLine());
        System.out.print("\nEnter bookName: ");
        String bookName= br.readLine();
        TestDelete.deleteBooKFromStudent(sId,bookName);
    }

    private static void displayAllStudentData(){
       TestFind.displayAllStudentData().forEach(System.out::println);
    }

    public static void displayAllBookData(){
       TestFind.displayAllBookData().forEach(System.out::println);
    }

    public static void oneToManyUniCRUD(){
            crud();
    }

}
