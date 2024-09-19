package com.dsa.compression;

import java.util.HashMap;
import java.util.Map;
import java.lang.*;
import java.util.PriorityQueue;
import com.dsa.util.LeafNode;

public class HuffmanCompression implements Compression{


    @Override
    public String compress(String inputString) {

        //build the huffman tree
        root  = huffmanBuildTree(inputString);
    }

    private void huffmanBuildTree(String inputString) {
        //build frequency table
        Map<String, Integer> table = buildFrequencyTable(inputString);

        //create priotity queue of nodes
        PriorityQueue<Object> nodes = new PriorityQueue<>();

        for(Map.Entry<String, Integer> entry : table.entrySet()) {
            LeafNode newLeaf = new LeafNode(entry.getKey(), entry.getValue());
            nodes.add(newLeaf);
        }

        //make parent nodes up to the root
        while(!nodes.isEmpty()) {
            //dequeue the lowest-priority nodes

            Object left, right;

            left = nodes.poll();
            right = nodes.poll();

            //make a parent for the two nodes
            frequencySum = left.frequency + right.frequency;
        }
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
