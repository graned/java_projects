/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.texttocsv.controllers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 *
 * @author j.anaya.villagrana
 */
public class FileActions {

    public String createFile(String valuesToSave, String path) {
        Writer writer = null;
        try {
            File file = new File(path);
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            writer.write(valuesToSave);
            writer.close();
            return "FILE CREATED SUCCESSFULLY";
        } catch (FileNotFoundException e) {
            EmailActions.sendEmail(e);
            return "FILE NOT FOUND";
        } catch (IOException e) {
            EmailActions.sendEmail(e);
            return "ERROR WHILE READING FILE";
        } catch (Exception e) {
            EmailActions.sendEmail(e);
            return "UNEXPECTED ERROR!: PLEASE TRY YOUR ACTION AGAIN";
        }
    }

    public String readFile(String path, StringBuilder fileBuilder) {
        BufferedReader buffer = null;
        try {
            File file = new File(path);
            buffer = new BufferedReader(new FileReader(file));
            String line;
            while ((line = buffer.readLine()) != null) {
                fileBuilder.append(line);
                fileBuilder.append("\n");
            }
            buffer.close();
            return "FILE READ SUCCESSFULLY";
        } catch (FileNotFoundException e) {
            EmailActions.sendEmail(e);
            return "FILE NOT FOUND";
        } catch (IOException e) {
            EmailActions.sendEmail(e);
            return "ERROR WHILE READING FILE";
        }catch (Exception e) {
            EmailActions.sendEmail(e);
            return "UNEXPECTED ERROR!: PLEASE TRY YOUR ACTION AGAIN";
        }
    }
}
