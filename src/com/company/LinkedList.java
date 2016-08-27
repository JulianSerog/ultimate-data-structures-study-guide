package com.company;

/**
 * Created by Esa on 8/26/2016.
 * a class implementation of a doubly linked list
 */
public class LinkedList {



    public Node head;
    public Node tail;


    public void add(int value) {
        if (this.head == null) {
            if (tail != null)
                throw new AssertionError();


            //set variables for head and tail nodes
            this.head = new Node(value);
            this.tail = this.head;

            //set variables for pointers
            this.tail.right = this.head;
            this.head.left = this.tail;
        } else {
            this.tail.right = new Node(this.tail, this.head, value);
            this.tail = this.tail.right;
        }//else
    }//addNode



    public void print() {
        Node current = this.head;
        if (current == null)
            System.out.println("No data in DLL!");
        else {


            while(current.right != this.head) {
                System.out.print(current.data + " ");
                current = current.right;
            }//while
            System.out.println(current.data + " ");
        }//else

    }//print


}//DLL
