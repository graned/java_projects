/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repaso;

import chapter19.Moderate;
import chapter2.excercises.TestClass;
import datastructures.linkedlist.MyLinkedList;
import datastructures.linkedlist.TestRotation;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 *
 * @author jose.villagrana
 */
public class Repaso {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        TestRotation r = new TestRotation();
        
        System.out.println(r.isRotation("mytext", "tmytax"));
        
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("A");
        System.out.println(linkedList);
        
        TestClass tc = new TestClass();
        tc.removeDuplicates(linkedList);
        System.out.println(linkedList);
        
        int[][] board = new int[3][3];
        board[0][0]=1;
        board[0][1]=1;
        board[0][2]=0;
        Moderate m = new Moderate();
//        System.out.println(m.checkRow(board, 0, 3, 1));
        
//        MyLinkedList linkedList = new MyLinkedList();
//        linkedList.add("A");
//        
//        linkedList.add("B");
//        linkedList.add("C");
//        linkedList.add("D");
//        linkedList.add("E");
//        
//        System.out.println(linkedList.get("D"));
//       
        
//        System.out.println(linkedList);
//        System.out.println(linkedList.getSize());
//        LinkedList ll = new LinkedList();
//        System.out.println(ll.get(0));
    }
    
}
