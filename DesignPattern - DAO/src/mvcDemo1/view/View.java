/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvcDemo1.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import mvcDemo1.controller.Controller;
import mvcDemo1.model.Model;

/**
 *
 * @author jose.villagrana
 */
public class View extends JFrame implements ActionListener {

    private Model model;
    private JButton okButton;
    private JLabel nameLabel;
    private JLabel passwordLabel;
    private JTextField nameTxtField;
    private JTextField passwordTxtField;
    private LogInListener logInListener;

    public View(Model model) {
        super("OBSERVER MVC PATTERN");
        this.model = model;

        okButton = new JButton("ok");
        nameLabel = new JLabel("NAME: ");
        passwordLabel = new JLabel("PASSWORD: ");
        nameTxtField = new JTextField(10);
        passwordTxtField = new JPasswordField(10);

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();
        gc.anchor = GridBagConstraints.LAST_LINE_END;
        gc.gridx = 1;
        gc.gridy = 1;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.insets = new Insets(100, 0, 0, 10);
        gc.fill = GridBagConstraints.NONE;
        add(nameLabel, gc);

        gc.anchor = GridBagConstraints.LAST_LINE_START;
        gc.gridx = 2;
        gc.gridy = 1;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.insets = new Insets(100, 0, 0, 0);
        gc.fill = GridBagConstraints.NONE;
        add(nameTxtField, gc);

        gc.anchor = GridBagConstraints.LINE_END;
        gc.gridx = 1;
        gc.gridy = 2;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.insets = new Insets(0, 0, 0, 10);
        gc.fill = GridBagConstraints.NONE;
        add(passwordLabel, gc);

        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridx = 2;
        gc.gridy = 2;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.fill = GridBagConstraints.NONE;
        add(passwordTxtField, gc);

        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.gridx = 2;
        gc.gridy = 3;
        gc.weightx = 1;
        gc.weighty = 100;
        gc.fill = GridBagConstraints.NONE;
        add(okButton, gc);

        okButton.addActionListener(this);
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String password = passwordTxtField.getText();
        String name = nameTxtField.getText();
//        System.out.println("hello " + name +"!!");
        if (logInListener != null) {
            logInListener.logInPerformed(new LogInFormedEvent(name, password));
        }
    }

    public void setLogInListener(LogInListener logInListener) {
        this.logInListener = logInListener;
    }

}
