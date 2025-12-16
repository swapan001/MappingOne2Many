package entity.onetomanyBi;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString(exclude = "employees")
@EqualsAndHashCode
@Entity

public class Manager {
    @Id
    private int mgrId;
    private String mgrName;
    @OneToMany(mappedBy = "manager")
    private List<Employee> employees;
    public  void addEmployee(Employee... newEmployees) {
        if (employees == null) {
            employees = new ArrayList<>();
        }

        for (Employee emp : newEmployees) {
            employees.add(emp);
        }
    }
}
