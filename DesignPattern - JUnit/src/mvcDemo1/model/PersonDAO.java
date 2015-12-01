/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mvcDemo1.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jose.villagrana
 */
/**
 * ONE DAO class per table or view
 * CRUD
 * @author jose.villagrana
 */
public class PersonDAO {
    private static List<Person> personList = new ArrayList<Person>();
    private static int counter = 0;
    public void createPerson(Person person){
        person.setId(counter++);
        personList.add(person);
    }
    
    public Person getPerson(Person person){
        return personList.get(personList.indexOf(person));
    }
    
    public List<Person> getPeople(){
        return personList;
    }
    
    public void updatePerson(Person person){
        personList.set(personList.indexOf(person), person);
    }
    
    public void deletePerson(Person person){
        personList.remove(person);
    }
}
