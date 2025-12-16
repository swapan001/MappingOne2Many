package entity.onetomanyBi;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString(exclude = "manager")
@Entity
public class Employee {
    @Id
    private int empId;
    private String empName;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn
    private Manager manager;
}
