package entity.manytooneUni;
//in many to one there no required extra table
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
@ToString
@EqualsAndHashCode
@Getter
@NoArgsConstructor

@Entity
public class Developer {
    @Id
    private int devId;
    private String name;
    private int skillRating;
    @ManyToOne
    private PL pl;

    public void setDevId(int devId){
        if(devId>100 && devId<1000){
            this.devId=devId;
        }
    }

    public void setPl(PL pl) {
        this.pl = pl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSkillRating(int skillRating) {
        this.skillRating = skillRating;
    }
}
