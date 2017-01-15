package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        //sort method testing
        int[] arr = {22, 1, 542, 33, 2, 11, 475, 67 ,32 ,64, 32, 15, 4, 2};
        System.out.println("original array: " + Arrays.toString(arr));

        //bubble sort
        System.out.println("bubble sort: " + Arrays.toString(SortingMethods.bubbleSort(arr)));

        //Selection sort
        System.out.println("selection sort" + Arrays.toString(SortingMethods.selectionSort(arr)));

        System.out.println("merge sort" + Arrays.toString(SortingMethods.mergeSort(arr)));


        System.out.println(); //white space for better readability in terminal
        //linked lists
        LinkedList list = new LinkedList();
        list.add(4);
        list.add(55);
        list.add(32);
        list.add(37);
        list.add(88);
        list.remove(3);
        //list.remove(4); //should cause out of index out of bounds error

        System.out.print("list: ");
        list.print();
        System.out.println("size: " + list.size());
        System.out.println(); //white space for better readability in terminal


        //BST methods
        BST tree = new BST();
        tree.addNode(5, tree.root);
        tree.addNode(3, tree.root);
        tree.addNode(10, tree.root);

        //printing methods
        System.out.println("inOrder");
        tree.inOrder(tree.root);
        System.out.println("\npreorder");
        tree.preOrder(tree.root);
        System.out.println("\npostorder");
        tree.postOrder(tree.root);



        //RANDOM THINGS YOU SHOULD KNOW HOW TO DO
        //reverse a string in place
        char[] string = new String("Hello World").toCharArray();
        System.out.println("\nbefore reverse: " + Arrays.toString(string));
        for (int i = 0, j = string.length-1; i < string.length/2; i++, j--) {
            char temp = string[i];
            string[i] = string[j];
            string[j] = temp;
        }//for
        System.out.println("after reverse: " + Arrays.toString(string));
    }//main method
}//Main Class

