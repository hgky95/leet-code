package problem_solving.DetermineIfTwoStringsAreClose;

import java.util.*;

public class Solution {

    /**
     *  Define two fixed array to store frequencies of character in each word (1)
     *  Define two fixed array to store the existing status (boolean) of each character in each word (2)
     *  Loop through the word:
     *      Increase the frequency of character by index 'character' - 'a':
     *          In ASCII, 'a' start with 97. Eg: first character is a => index = 0; if character is b => index = 1
     *      Set true to the specific index by character (a: index 0 => true; b:index 1 => true...)
     *  They are close word if:
     *      - The key of each map (character) are the same
     *      - The sorted frequency values are the same
     *  Time Complexity:
     *      Creating frequency arrays: O(n): n is length of string
     *      Creating character presence: O(n): u is the number of unique characters
     *      Arrays.sort(): O(1)
     *      Overall: O(n)
     *      Space Complexity:
     *          O(1) for sorting
     */
    public boolean closeStringsOptimize(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

       int[] frequencies1 = new int[26];
       int[] frequencies2 = new int[26];
       boolean[] characters1 = new boolean[26];
       boolean[] characters2 = new boolean[26];

       for (Character c : word1.toCharArray()) {
           frequencies1[c - 'a']++;
           characters1[c - 'a'] = true;
       }

        for (Character c : word2.toCharArray()) {
            frequencies2[c - 'a']++;
            characters2[c - 'a'] = true;
        }

        if (!Arrays.equals(characters1, characters2)) {
            return false;
        }

        Arrays.sort(frequencies1);
        Arrays.sort(frequencies2);

        return Arrays.equals(frequencies1, frequencies2);
    }

    /**
     * Put each character of each word into the HashMap by character - frequency
     * They are close word if:
     *  - The key of each map (character) are the same
     *  - The sorted frequency values are the same
     *  Time Complexity:
     *      Build HashMap: O(n): n is length of string
     *      Comparing Keyset: O(u): u is the number of unique characters
     *      Sorting Frequencies: O(u log u)
     *      Overall: O(n + u log u), where u <= 26
     *  Space Complexity:
     *      O(u) for sorting
     */
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < word1.length(); i++) {
            Character key = word1.charAt(i);
            map1.put(key, map1.getOrDefault(key, 0) + 1);
        }

        for (int i = 0; i < word2.length(); i++) {
            Character key = word2.charAt(i);
            map2.put(key, map2.getOrDefault(key, 0) + 1);
        }

        if (!map1.keySet().equals(map2.keySet())) {
            return false;
        }

        // Compare sorted frequency values
        List<Integer> freq1 = new ArrayList<>(map1.values());
        List<Integer> freq2 = new ArrayList<>(map2.values());

        Collections.sort(freq1);
        Collections.sort(freq2);

        return freq1.equals(freq2);
    }

}
