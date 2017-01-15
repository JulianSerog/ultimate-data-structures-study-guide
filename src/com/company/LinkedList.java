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

    public void remove(int index) {
        if (index > this.size() - 1) throw new IndexOutOfBoundsException(); //throw error if out of bounds
        Node c = this.head;
        int counter = 0;
        while(counter != index) {
            c = c.right;
            counter++;
        }
        c.left.right = c.right;
        c = null;
    }

    public boolean isEmpty() {
        if (this.head == null) return true;
        else return false;
    }

    public int size() {
        int size = 0;
        if (this.isEmpty()) return 0;
        else {
            size++;
            Node c = this.head;
            while (c.right != this.head) {
                c = c.right;
                size++;
            }
            return size;
        }//else
    }



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
