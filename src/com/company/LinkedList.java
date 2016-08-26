package com.company;

/**
 * Created by Esa on 8/26/2016.
 * a class implementation of a doubly linked list
 */
public class LinkedList {



    public Node start;
    public Node end;


    public void add(int value) {
        if (this.start == null) {
            //set variables for start and end nodes
            this.start = new Node(value);
            this.end = this.start;

            //set variables for pointers
            this.end.left = start;
            this.end.right = this.start;
            this.start.right = this.end;
            this.start.left = this.end;
        } else {
            Node current = this.start;
            while(current.right != this.start) {
                current = current.right;
            }




            if (this.start.right == this.start) {
                this.start.right = new Node(value);
                this.end = this.start.right;
                //set pointers
                this.end.left = this.start;
                this.end.right = this.start;
            }
        }//else
    }//addNode



    public void print() {
        Node current = this.start;
        if (current == null)
            System.out.println("No data in DLL!");
        else {
            System.out.print(current.data + " ");
            current = current.right;
            while(current.right != this.start) {
                System.out.print(current.data + " ");
            }//while
        }//else

    }//print


}//DLL
