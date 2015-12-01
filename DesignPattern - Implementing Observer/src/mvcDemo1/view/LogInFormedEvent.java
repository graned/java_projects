/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mvcDemo1.view;

/**
 *
 * @author jose.villagrana
 */
public class LogInFormedEvent {
    private String name;
    private String password;

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

    public LogInFormedEvent(String name, String password) {
        this.name = name;
        this.password = password;
    }
    
    
}
