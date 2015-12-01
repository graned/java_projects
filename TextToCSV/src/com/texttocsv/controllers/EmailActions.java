/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.texttocsv.controllers;

import java.io.IOException;
import java.util.Properties;


/**
 *
 * @author j.anaya.villagrana
 */
public class EmailActions {

    public static void sendEmail(Exception ex) {
        try {
            String stackTrace = getStackTrace(ex);
            Properties props = System.getProperties();
            String command = "cscript " + props.getProperty("user.dir") + "\\sendVPN.vbs \"" + stackTrace + "\"";
            Runtime.getRuntime().exec(command);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private static String getStackTrace(Exception ex) {
        StringBuilder sb = new StringBuilder();
        sb.append(ex.getMessage()+"\n");
        for (StackTraceElement se : ex.getStackTrace()) {
            sb.append(se.toString()+"\n");
        }
        return sb.toString();
    }
}
