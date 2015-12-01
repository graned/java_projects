/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okcupid.controller;

import com.okcupid.model.UserProfile;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author j.anaya.villagrana
 */
@Controller
@RequestMapping("/hello")
public class OkCupidWebController {
    
    @RequestMapping(value = "/greetings",method = RequestMethod.GET)
    public String printHello(ModelMap model){
        JsonReader jr = new JsonReader();
        OkCupidWSClient client = new OkCupidWSClient();
        ArrayList<UserProfile> users = jr.jsonToObject(client.getServiceResponse());
        ProcessProfiles pp = new ProcessProfiles();
        pp.calculateMatches(users);
        model.addAttribute("message", jr.generateJSONresult(users));
        return "other";
    }
}
