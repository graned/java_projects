/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.texttocsv.exceptions;

/**
 *
 * @author j.anaya.villagrana
 */
public class IncorrectConvertionException extends RuntimeException{
    public IncorrectConvertionException(String message){
        super(message);
    }
}
