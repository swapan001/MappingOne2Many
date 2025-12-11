package entity.onetomanyUni;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Book {
    @Id
    private int bookId;
    private String bookName;
}
