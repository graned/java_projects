/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okcupidservice.service;

import com.okcupidservice.utilites.FileUtility;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author j.anaya.villagrana
 */
@Path("/ws")
public class OkCupidService{
    @Path("/getUsers")
    @GET
    @Produces("application/json")
    public Response getUsers(){
        String jsonUsers = FileUtility.readFile("C:\\Users\\jose.villagrana\\Documents\\NetBeansProjects\\OKCuipidWS\\input.json");
        return Response.status(200).entity(jsonUsers).build();
    }
}
