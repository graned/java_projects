/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okcupidservice.utilites;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

/**
 *
 * @author j.anaya.villagrana
 */
public class FileUtility {

    public static String readFile(String fileName) {
        FileReader fr = null;
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        String lineRead = "";
        try {
            System.out.println("reading file!");
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            while ((lineRead = br.readLine()) != null) {
                sb.append(lineRead);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File was not found: \n");
            sb.append("FILE NOT FOUND!");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null || br != null) {
                    fr.close();
                    br.close();
                }
            } catch (IOException e) {
                System.out.println("Error while closing connections: \n");
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
    
    public static boolean writeFile(String valuesToSave, String fileName){
        return false;
    }
}
