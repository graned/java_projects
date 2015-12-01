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
public class MyLinkedList {

    private Node root;
    private int size;
    private Node lastNode;

    public MyLinkedList() {
        root = new Node(null, "");
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void add(Object element) {
        Node newNode = new Node(element);
        if (lastNode == null) {
            root = newNode;
            lastNode = root;
        } else {
            lastNode.setNextNode(newNode);
            lastNode = newNode;
        }
        size++;
    }

    public Node get(int index) {
        Node node = root;
        if (root != null) {
            for (int i = 1; i <= size; i++) {
                if(i==index){
                    break;
                }
                node=root.getNextNode();
            }
        }
        return node;
    }

    public Node get(Object element) {
        Node node = root;
        for (int i = 1; i <= size; i++) {
            if (node.getContent().equals(element)) {
                return node;
            }
            node = node.getNextNode();
        }
        return null;
    }

    @Override
    public String toString() {
        return "MyLinkedList{" + root + "}";
    }

}
