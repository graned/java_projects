/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chapter2.excercises;

import datastructures.linkedlist.MyLinkedList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author jose.villagrana
 */
public class TestClass {
    
    //REMOVE DUPLICATES OF AN UNSORTED LINKED LIST
    public void removeDuplicates(LinkedList linkedList){
        if(linkedList != null && linkedList.size() > 1){
            List list = new ArrayList();
            for (Object object : linkedList) {
                if(list.contains(object)){
                    linkedList.remove(object);
                }else
                    list.add(object);
            }
        }
    }
    //ADD 2 LINKED LIST WHICH ARE STORED BACKWORDS
}
