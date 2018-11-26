package com.company;

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;

public class DuplicateStringOccurrences {
    public static void main(String[] args) {
        System.out.println(findDuplicateStringOccurrences("I am am learning java Java am you america am Java"));
    }

    public static LinkedList<String> findDuplicateStringOccurrences(String inputString) {
        String[] inputWordArray = inputString.split(" ");
        HashMap<String, Integer> dictionary = new HashMap<>();
        LinkedList<String> duplicates = new LinkedList<>();
        for (String inputWord : inputWordArray) {
            int newFreq = 1;
            Integer currFreq = dictionary.get(inputWord);
            if (currFreq != null) {
                newFreq += currFreq;
            }
            dictionary.put(inputWord, newFreq);
        }
        for (Map.Entry<String, Integer> dictionaryEntry : dictionary.entrySet()) {
            if (dictionaryEntry.getValue() > 1) {
                duplicates.add(dictionaryEntry.getKey());
            }
        }
        return duplicates;
    }
}
