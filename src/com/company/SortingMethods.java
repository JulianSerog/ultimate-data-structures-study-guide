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
                arr[min] = temp;
            }
        }//for
        return arr;
    }//selectionSort

    public static int[] quickSort(int[] arr) {
        return quickSort(arr, 0, arr.length-1);
    }

    public static int[] quickSort(int[] arr, int lo, int hi) {
        if(lo < hi)
        {
            int partitionPos = partition(arr, lo, hi);
            quickSort(arr, lo, partitionPos -1);
            quickSort(arr, partitionPos + 1, hi);
        }
        return arr;
    }

    private static int partition(int[] arr, int lo, int hi) {
        int pivot =  arr[hi]; //the pivot item could be any item in the array
        int swapIndex = lo;
        for(int index = swapIndex; index < hi; index++)
        {
            if(arr[index] <= pivot)
            {
                swap(arr, index, swapIndex);
                swapIndex++;
            }
        }
        swap(arr, swapIndex, hi);
        return swapIndex;
    }

    private static void swap(int[] arr, int pos1, int pos2 )
    {
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }

    public static int[] mergeSort(int[] arr) {
        return arr;
    }

}//class
