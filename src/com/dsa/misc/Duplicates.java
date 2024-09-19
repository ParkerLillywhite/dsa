package com.dsa.misc;

import java.util.Arrays;

public class Duplicates {

    public static boolean hasDuplicateInt(int[] array){
        Arrays.sort(array);

        for(int i = 0; i < array.length; i++) {
            if(array[i] == array[i + 1]) return false;
        }
        return true;
    }
}
