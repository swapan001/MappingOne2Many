package entity.onetomanyBi;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Getter
@Setter
@EqualsAndHashCode
@ToString(exclude = "manager")
@Entity
public class Employee {
    @Id
    private int empId;
    private String empName;
    @ManyToOne
    private Manager manager;
}
