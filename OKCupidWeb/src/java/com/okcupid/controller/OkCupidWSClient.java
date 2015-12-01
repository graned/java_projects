/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okcupid.controller;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;


/**
 *
 * @author j.anaya.villagrana
 */
public class OkCupidWSClient {
    
    public String getServiceResponse(){
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/OKCuipidWS/OkCupid/ws/getUsers");
        Builder builder = target.request();
        return builder.get(String.class);
    }
}
