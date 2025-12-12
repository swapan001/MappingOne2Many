package repository.manytooneUni;

import entity.manytooneUni.Developer;
import entity.manytooneUni.PL;

import javax.persistence.Query;

import static repository.onetomanyUni.TestSave.entityManager;
import static repository.onetomanyUni.TestSave.entityTransaction;

public class TestFind {
    static Developer findDeveloper(int id){
        return entityManager.find(Developer.class,id);
    }
}
