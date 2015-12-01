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
public class Node {
    private Object content;
    private Node nextNode;
    
    public Node(Object content){
        this.content = content;
        this.nextNode = null;
    }
    public Node(Node nextNode, Object content){
        this.nextNode = nextNode;
        this.content = content;
    } 
    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return "NODE["+this.content+"] --> "+this.nextNode;
    }
    
    
    
    
}
