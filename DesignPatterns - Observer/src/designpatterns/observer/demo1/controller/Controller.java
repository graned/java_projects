/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package designpatterns.observer.demo1.controller;

import designpatterns.observer.demo1.model.Model;
import designpatterns.observer.demo1.view.View;

/**
 *
 * @author jose.villagrana
 */
public class Controller {

    private Model model;
    private View view;
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }
    
}
