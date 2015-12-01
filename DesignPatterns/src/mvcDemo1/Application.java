/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mvcDemo1;

import javax.swing.SwingUtilities;
import mvcDemo1.controller.Controller;
import mvcDemo1.model.Model;
import mvcDemo1.view.View;

/**
 *
 * @author jose.villagrana
 */
public class Application {
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                runApp();
            }
        });
    }
    
    public static void runApp(){
        /**
         * should never import anything form view packages or controller, is independent!!!
         * */
        Model model = new Model(); 
        /**
         * view import clases from model, is a representation of the model
         */
        View view = new View(model);
        /**
         * Controller, sends commands to the model, view and tells the model,view what to do, also may or may not
         * listen to the model
         */
        Controller controller = new Controller(model, view);
    }
}
