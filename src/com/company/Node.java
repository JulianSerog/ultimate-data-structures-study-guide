package com.company;

/**
 * Created by Esa on 8/26/2016.
 */
public class Node {

    public Node right;
    public Node left;
    public int data;


    public Node(int data) {
        this.data = data;
    }//constructor
    public Node(Node left, int data) {
        this.left = left;
        this.data = data;
    }//constructor

    public Node(Node left, Node right, int data) {
        this.left = left;
        this.right = right;
        this.data = data;
    }//constructor
}//class
