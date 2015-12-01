/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mvcDemo1.controller;

import mvcDemo1.model.Model;
import mvcDemo1.model.Person;
import mvcDemo1.model.PersonDAO;
import mvcDemo1.view.LogInFormedEvent;
import mvcDemo1.view.LogInListener;
import mvcDemo1.view.View;

/**
 *
 * @author jose.villagrana
 */
public class Controller implements LogInListener{

    private View view;
    private Model model;
    private PersonDAO personDAO = new PersonDAO();
    
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void logInPerformed(LogInFormedEvent logInFormedEvent) {
        
        System.out.println("Log In event Recieved. "+ logInFormedEvent.getName() + "; " + logInFormedEvent.getPassword());
        
        personDAO.createPerson(new Person(logInFormedEvent.getName(),logInFormedEvent.getPassword()));
    }
    
    
}
