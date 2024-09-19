package com.dsa.misc;

import java.util.Arrays;

public class Sums {
    public static int findMaxSumOfThree(int[] array) {
        Arrays.sort(array);

        int length = array.length - 1;

        return array[length] + array[length - 1] + array[length - 2];
    }
}
