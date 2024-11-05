package problem_solving.ReverseWordsInAString;

import java.util.ArrayList;

public class Solution {


    /**
     * 1. Separate the given words by checking space ' ' and store into the ArrayList
     * 2. Reverse on the ArrayList
     */
    public static String reverseWords(String s) {
        //Can use built-in function s.split(" ") to split words from String s
        ArrayList<String> words = new ArrayList<>();
        char[] charArrays = s.toCharArray();
        StringBuilder word = new StringBuilder();
        for (char character : charArrays) {
            if (character != ' ') {
                word.append(character);
            } else if (!word.isEmpty()) {
                words.add(word.toString());
                word = new StringBuilder();
            }
        }
        words.add(word.toString());
        StringBuilder finalStringBuilder = new StringBuilder();
        for (int i = words.size() - 1; i >= 0; i--) {
            finalStringBuilder.append(words.get(i)).append(" ");
        }
        return finalStringBuilder.toString().trim();
    }

}