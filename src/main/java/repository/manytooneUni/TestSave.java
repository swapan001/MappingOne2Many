package repository.manytooneUni;

import entity.manytooneUni.Developer;
import entity.manytooneUni.PL;

import static repository.onetomanyUni.TestSave.entityManager;
import static repository.onetomanyUni.TestSave.entityTransaction;

public class TestSave {
    public static void main(String[] args) {
        //create Developer class Object
        Developer developer1=new Developer();
        developer1.setDevId(106);
        developer1.setName("Aryaan Bhattacharya");
        developer1.setSkillRating(8);

        Developer developer2=new Developer();
        developer2.setDevId(105);
        developer2.setName("Rama G");
        developer2.setSkillRating(8);

        Developer developer3=new Developer();
        developer3.setDevId(104);
        developer3.setName("Yogii M");
        developer3.setSkillRating(7);

        PL pl1=new PL();
        pl1.setPLName("C#");
        pl1.setDescription("OOPS, HLPL");
        developer1.setPl(pl1);
        developer2.setPl(pl1);
        developer3.setPl(pl1);

        entityTransaction.begin();
        entityManager.persist(pl1);
        entityManager.persist(developer1);
        entityManager.persist(developer2);
        entityManager.persist(developer3);

        entityTransaction.commit();

        System.out.println("Success");
    }
}
