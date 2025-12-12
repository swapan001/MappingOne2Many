package repository.manytooneUni;

import entity.manytooneUni.Developer;
import entity.manytooneUni.PL;

import javax.persistence.Query;

import static repository.onetomanyUni.TestSave.entityManager;
import static repository.onetomanyUni.TestSave.entityTransaction;

public class TestUpdate {
    public static void main(String[] args) {
        String name="Yogii M";
        String jpql="select d from Developer d where d.name=:name";
        Query query=entityManager.createQuery(jpql);
        query.setParameter("name",name);

        Developer dev=(Developer) query.getSingleResult();

        String isExistPL="";
        PL pl=new PL();
        pl.setPLName("Python");
        pl.setDescription("AI_ML,WEB_DEVELOPMENT,OOPS");

        dev.setPl(pl);

        entityTransaction.begin();
        entityManager.merge(dev);
        entityManager.persist(pl);
        entityTransaction.commit();

        System.out.println("Successfully updated");
    }
}
