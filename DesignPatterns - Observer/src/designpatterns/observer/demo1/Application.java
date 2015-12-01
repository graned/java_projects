/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns.observer.demo1;

import designpatterns.observer.demo1.controller.Controller;
import designpatterns.observer.demo1.model.Model;
import designpatterns.observer.demo1.view.View;
import javax.swing.SwingUtilities;

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

    public static void runApp() {
        Model model = new Model(); 
        View view = new View(model);
        Controller controller = new Controller(model, view);
    
    }
}
