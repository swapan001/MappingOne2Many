package entity.onetomanyUni;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class Student {
    @Id
    private int rollNo;
    private String sName;
    @OneToMany
    private List<Book> bookList;

}
