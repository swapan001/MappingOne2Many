package entity.onetomanyUni;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Student {
    @Id
    private int rollNo;
    private String sName;
    // @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST) 
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)      //using EAGER for access the object after changes
    private List<Book> bookList;


    /* This is a helper method, that will usage when manually Book objects are added inside bookList */
    public void addBook(Book... newBooks){
        if(bookList == null){
            bookList=new ArrayList<>();
            for (Book book: newBooks) {
                bookList.add(book);
            }
        }
    }

}
