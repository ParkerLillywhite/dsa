package com.dsa.compression;

import java.util.HashMap;
import java.util.Map;

public class HuffmanCompression implements Compression{


    @Override
    public String compress(String inputString) {

        //build the huffman tree
        root  = huffmanBuildTree(inputString);
    }

    private void huffmanBuildTree(String inputString) {
        //build frequency table
        Map<String, Integer> table = buildFrequencyTable(inputString);
    }

    private Map<String, Integer> buildFrequencyTable(String inputString) {
        Map<String, Integer> table = new HashMap<>();

        String[] splitString = inputString.split("");

        //populate map with string values and occurrences
        for(int i = 0; i < inputString.length(); i++) {
            table.put(splitString[i], table.getOrDefault(splitString[i], 0) + 1);
        }

        return table;
    }

    @Override
    public String deCompress(String inputString) {
        return inputString;
    }


}
