package entity.onetomanyUni;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Student {
    @Id
    private int rollNo;
    private String sName;
    @OneToMany
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
