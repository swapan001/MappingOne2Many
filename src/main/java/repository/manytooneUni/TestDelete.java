package repository.manytooneUni;

import entity.manytooneUni.Developer;
import entity.manytooneUni.PL;

import javax.persistence.Query;

import java.util.List;

import static repository.onetomanyUni.TestSave.entityManager;
import static repository.onetomanyUni.TestSave.entityTransaction;

public class TestDelete {
    public static void main(String[] args) {
        String pl="C#";
        String jpql="select d from Developer d where d.pl=:delete_pl";
        PL removePL=entityManager.find(PL.class,pl);
        Query query=entityManager.createQuery(jpql);
        query.setParameter("delete_pl",removePL);


        List<Developer> developerListHavindCShProgrammingLang=query.getResultList();
/*
        developerListHavindCShProgrammingLang.forEach(developer -> {developer.setPl(null)
            entityTransaction.begin();
            entityManager.merge(developer);
            entityTransaction.commit();

        } );
*/
        entityTransaction.begin();
        for (Developer dev: developerListHavindCShProgrammingLang
             ) {
            dev.setPl(null);
            entityManager.merge(dev);
        }
        entityManager.remove(removePL);
        entityTransaction.commit();

        System.out.println("Deleted Successfully");

    }
}
