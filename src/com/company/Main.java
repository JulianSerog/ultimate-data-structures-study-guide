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


        System.out.println(); //white space for better readability in terminal
        //linked lists
        LinkedList list = new LinkedList();
        list.add(4);
        System.out.print("list: ");
        list.print();
        System.out.println(); //white space for better readability in terminal


        //BST methods
        BST tree = new BST();
        tree.addNode(5, tree.root);
        tree.addNode(3, tree.root);
        tree.addNode(10, tree.root);

        //printing methods
        System.out.println("\ninOrder");
        tree.inOrder(tree.root);
        System.out.println("\npreorder");
        tree.preOrder(tree.root);
        System.out.println("\npostorder");
        tree.postOrder(tree.root);

    }//main method
}//Main Class

