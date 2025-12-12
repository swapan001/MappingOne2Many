package entity.manytooneUni;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data


@Entity
//@Table(name = "pl")
public class PL {
    @Id
    private String PLName;
    private String description;
}
