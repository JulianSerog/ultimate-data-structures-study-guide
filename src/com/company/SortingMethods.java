package com.company;

/**
 * Created by Esa Julian Serog on 8/26/2016.
 */
public class SortingMethods {

    //O(n^2)
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

    //O(n^2)
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

    //O(n^2) -- Average = n * log(n)
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

    //O(n*log(n))
    public static int[] mergeSort(int[] arr) {
        if (arr.length <= 1)
            return arr;

        //split array in half into two parts
        int[] first = new int[arr.length/2];
        int[] second = new int[arr.length - first.length];
        System.arraycopy(arr, 0, first, 0, first.length);
        System.arraycopy(arr, first.length, second, 0, second.length);

        mergeSort(first);
        mergeSort(second);

        merge(first, second, arr);
        return arr;

    }//mergeSort

    private static void merge(int[] first, int[] second, int[] result) {

        //index pos in first array - starting with first element
        int iFirst = 0;
        //index position in second array - starting with first element
        int iSecond = 0;
        //index position in merged array - starting with first position
        int iMerged = 0;


        while(iFirst < first.length && iSecond < second.length) {
            if (first[iFirst] < second[iSecond]) {
                result[iMerged] = first[iFirst];
                iFirst++;
            } else {
                result[iMerged] = second[iSecond];
                iSecond++;
            }//else
            iMerged++;
        }//while
        //copy remaining elements from both halves - each half willalready have sorted elements
        System.arraycopy(first, iFirst, result, iMerged, first.length - iFirst);
        System.arraycopy(second, iSecond, result, iMerged, second.length - iSecond);
    }//merge
}//class
