/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mvcDemo1.view;

import java.awt.HeadlessException;
import javax.swing.JFrame;
import mvcDemo1.model.Model;

/**
 *
 * @author jose.villagrana
 */
public class View extends JFrame{

    private Model model;
    
    public View(Model model) throws HeadlessException {
        super("MVC Demo");
        this.model = model;
    }
    
    
    
}
