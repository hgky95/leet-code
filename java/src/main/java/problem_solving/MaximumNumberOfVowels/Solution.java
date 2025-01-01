package problem_solving.MaximumNumberOfVowels;

import java.util.Set;

public class Solution {

    /**
     * LC1456 - https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/?envType=study-plan-v2&envId=leetcode-75
     * Using Sliding Window
     * 1. The first window start from index 0 to k
     * 2. Calculate the current vowels in this window -> set as maxVowels
     * 3. Slide the window to the right side:
     *      3.1 If character at index (i-k) contains vowel, then we remove it since it belongs to the previous window
     *      3.2 If character at index (k) contains vowel, then we increase counter bc it belongs to the new window
     *      3.3 Use max function to find max value between the maxVowel and current counter
     */
    public int maxVowels(String s, int k) {
        int counter = 0;
        Set<Character> vowels = Set.of('a', 'e', 'o', 'i', 'u');
        for (int i = 0; i < k; i++) {
            if (vowels.contains(s.charAt(i))) {
                counter++;
            }
        }
        int maxVowel = counter;

        for (int i = k; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i))) {
                counter++;
            }
            if (vowels.contains(s.charAt(i - k))) {
                counter--;
            }
            maxVowel = Math.max(maxVowel, counter);
        }
        return maxVowel;
    }

}
