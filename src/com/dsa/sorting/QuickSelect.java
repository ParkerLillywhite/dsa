package com.dsa.sorting;

public class QuickSelect {

    public static int quickSelect(int kthIndex, int leftIndex, int rightIndex, int[] array) {

        int pivotIndex;


//        if base case is reached meaning the subarray has one cell, we know we've found what we're looking for
        if(rightIndex - leftIndex <= 0) {
            return array[leftIndex];
        }

//        partition the array and grab the index of the pivot
        pivotIndex = partition(array, leftIndex, rightIndex);

        //if what we're looking for is to the left of the pivot

        if(kthIndex < pivotIndex) {
            //recursively perform quickselect on the left side of the array
            return quickSelect(kthIndex, leftIndex, pivotIndex - 1, array);
            //if what we're looking for is to the right of the index
        } else if(kthIndex > pivotIndex) {
            //recursively perform quickselect on the right side of the array
            return quickSelect(kthIndex, pivotIndex + 1, rightIndex, array);
        } else {
            //otherwise, if kth = pivotIndex
            //we have found what we are looking for

            return array[pivotIndex];
        }

    }


    private static int partition(int[] array, int leftIndex, int rightIndex) {
        int pivot = array[rightIndex];
        int i = leftIndex - 1;

        for(int j = leftIndex; j < rightIndex; j++) {
            //if the current element is less than or equal to pivot, swap array[j] with array[i]
            //this essentially keeps going through the array until it finds an element larger that should be on the right side.
            // i will stay locked on the first element that is bigger and should be on the right.
            //while j keeps moving until it finds a left side element


            if(array[j] <= pivot) {
                //elements are swapped
                i++;

                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;

            }
        }

        //now all elements though not completely sorted, are either on the larger side, or smaller side.
        //the pivot is then put in its correct position in the array.

        int temp = array[i + 1];
        array[i + 1] = array[rightIndex];
        array[rightIndex] = temp;

        return i + 1;


    }
}
