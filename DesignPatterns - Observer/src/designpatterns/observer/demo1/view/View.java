/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns.observer.demo1.view;

import designpatterns.observer.demo1.model.Model;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author jose.villagrana
 */
public class View extends JFrame implements ActionListener {

    private Model model;
    private JButton helloButton;
    private JButton gbButton;

    public View(Model model) {
        super("OBSERVER MVC PATTERN");
        this.model = model;

        helloButton = new JButton("Hello!");
        gbButton = new JButton("GoodBye");
        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();
        gc.anchor = GridBagConstraints.CENTER;
        gc.gridx = 1;
        gc.gridy = 1;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;

        add(helloButton, gc);
        gc.anchor = GridBagConstraints.CENTER;
        gc.gridx = 1;
        gc.gridy = 2;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;

        add(gbButton,gc);
        
        helloButton.addActionListener(this);
        gbButton.addActionListener(this);
        
        gbButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("some other action");
            }
        });
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        if (source == helloButton) {
            System.out.println("hello there!");
        } else {
            System.out.println("other button");
        }
    }

}
