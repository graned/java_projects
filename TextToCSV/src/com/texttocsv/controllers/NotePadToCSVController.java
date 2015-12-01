/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.texttocsv.controllers;

import com.texttocsv.exceptions.IncorrectConvertionException;
import com.texttocsv.models.ExtractionMethod;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author j.anaya.villagrana
 */
public class NotePadToCSVController {

    FileActions fa;

    public NotePadToCSVController(FileActions fa) {
        this.fa = fa;
    }

    public String extractionMethod(ExtractionMethod eMethod, String readFile) {
        String returnVal = "";
        switch (eMethod) {
            case VPN:
                returnVal = extractValues(readFile.toString());  
                break;
            case CLEAR_QUEST:
                Map<String, String> map = new HashMap<>();
                boolean isActive = false;
                String userKey = null;
                Matcher m = Pattern.compile("(USER.*|is.active.*|email.*|is.superuser.*).?").matcher(readFile);
                while (m.find()) {
                    if (m.group().contains("USER")) {
                        userKey = m.group().split("\\s")[1];
                    }
                    if (m.group().contains("is_active") && m.group().contains("TRUE")) {
                        isActive = true;
                        continue;
                    }
                    if (isActive) {
                        String s = m.group().split("=")[1];
                        if (!s.trim().isEmpty()) {
                            map.put(userKey, s.trim());
                        }
                        isActive = false;
                    }
                }
                StringBuilder sb = new StringBuilder("Username, Email Address");
                if(map.isEmpty()){
                    throw new IncorrectConvertionException("No matches were found");
                }
                for (String keys : map.keySet()) {
                    sb.append(keys + "," + map.get(keys) + ",");
                    sb.append("\n");
                }
                returnVal = sb.toString();
                break;
        }
        return returnVal;
    }

    public static String extractValues(String text) {
        StringBuilder csvBuilder = new StringBuilder("Username,Policy\n");
        StringBuilder results = new StringBuilder();
        Pattern p = Pattern.compile("((?<=username\\s).*.(?=\\sattributes)|(?<=vpn-group-policy\\s).*)");
        Matcher m = p.matcher(text);
        while (m.find()) {
            String foundString = m.group();
            results.append(foundString);
            results.append(",");
            if (foundString.contains("POLICY")) {
                results.append("\n");
            }
        }
        if(results.toString().isEmpty()){
            throw new IncorrectConvertionException("No matches were found");
        }else{
            csvBuilder.append(results);
        }
        return csvBuilder.toString();
    }

    public static String extractEmail(String val) {
        Matcher m = Pattern.compile("[[\\w|-].*]*@[[\\w|-].*]*").matcher(val);
        while (m.find()) {
            return m.group();
        }
        return null;
    }
}
