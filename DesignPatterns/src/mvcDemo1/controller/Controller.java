/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mvcDemo1.controller;

import mvcDemo1.model.Model;
import mvcDemo1.view.View;

/**
 *
 * @author jose.villagrana
 */
public class Controller {

    private View view;
    private Model model;
    
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }
    
}
