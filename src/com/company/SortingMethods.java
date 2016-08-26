package com.company;

/**
 * Created by Esa Julian Serog on 8/26/2016.
 */
public class SortingMethods {


    public static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }//if
            }//inner for
        }//outer for
        return arr;
    }//bubbleSort


    public static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min])
                    min = j;
            }
            if(i != min) {
                //swap
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = arr[i];
            }
        }//for
        return arr;
    }//selectionSort

    public static int[] quickSort(int[] arr) {
        return arr;
    }

    public static int[] mergeSort(int[] arr) {
        return arr;
    }

}//class
