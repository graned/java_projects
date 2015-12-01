/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package okcupid;

import com.okcupid.controller.JsonReader;
import com.okcupid.controller.OkCupidWSClient;
import com.okcupid.controller.ProcessProfiles;
import com.okcupid.model.Answer;
import com.okcupid.model.UserProfile;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 *
 * @author j.anaya.villagrana
 */
public class OkCupid {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JsonReader jr = new JsonReader();
        OkCupidWSClient client = new OkCupidWSClient();
        ArrayList<UserProfile> users = jr.jsonToObject(client.getServiceResponse());
        ProcessProfiles pp = new ProcessProfiles();
        pp.calculateMatches(users);
        jr.generateJSONresult(users);
    }
}
