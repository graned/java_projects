/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mvcDemo1.model;

/**
 *
 * @author jose.villagrana
 */
public class Person {

    /**
     * this are the values that will be persisted on DB, here, sometimes, we will have some annotations 
     */
    private String id;
    private String name;
    private String password;
    /**
     * A BEAN CLASS WILL HAVE A NO ARGUMENT CONSTRUCTOR
     */
    public Person() {
    }

    /**
     * A BEAN CLASS WILL ALSO HAVE THE GETTERS AND SETTERS
     * @return 
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    
    
}
