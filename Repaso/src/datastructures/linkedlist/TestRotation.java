/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.linkedlist;

/**
 *
 * @author jose.villagrana
 */
public class TestRotation {

    public boolean isRotation(String text, String rotation) {
        StringBuffer buffer = new StringBuffer();
        if (text.length() == rotation.length()) {

            buffer.append(text).append(text);
            return buffer.toString().contains(rotation);
        }
        return false;
    }
}
