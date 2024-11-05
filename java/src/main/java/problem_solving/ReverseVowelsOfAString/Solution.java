package problem_solving.ReverseVowelsOfAString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    /**
     * Main idea: Using two pointer and modify directly on the input
     * 1. Left pointer start with 0 and increase each step if the character is not vowel
     * 2. Right pointer start with (length - 1) and decrease each step if the character is not vowel
     * Once both pointers responsible to the vowels, then do the replacement between each.
     * Then increase left index and decrease right index
     */
    public static String reverseVowelsOptimal(String s) {
        char[] charArray = s.toCharArray();
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'o', 'u', 'i',
                'A', 'E', 'O', 'U', 'I'));
        int leftIndex = 0;
        int rightIndex = s.length() - 1;
        while (leftIndex < rightIndex) {
            while (leftIndex < rightIndex && !vowels.contains(charArray[leftIndex])) {
                leftIndex++;
            }
            while (leftIndex < rightIndex && !vowels.contains(charArray[rightIndex])) {
                rightIndex--;
            }

            char charLeftTemp = charArray[leftIndex];
            charArray[leftIndex] = charArray[rightIndex];
            charArray[rightIndex] = charLeftTemp;
            leftIndex++;
            rightIndex--;
        }

        return String.valueOf(charArray);
    }

    /**
     * Main idea: using two loops:
     * 1. Loop from the end to the beginning of the char array and store the existing vowels if the given string contains vowels.
     * 2. Loop from the beginning to the end, replacing the existing vowels in the given string with the reversed vowels from step 1.
     */
    public static String reverseVowels(String s) {
        char[] charArray = s.toCharArray();
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'o', 'u', 'i'));
        ArrayList<Character> reversedVowel = new ArrayList<>();
        for (int i = charArray.length - 1; i >= 0; i--) {
            char lowerChar = Character.toLowerCase(charArray[i]);
            if (vowels.contains(lowerChar)) {
                reversedVowel.add(charArray[i]);
            }
        }
        int index = 0;
        for (int i = 0; i < charArray.length; i++) {
            char lowerChar = Character.toLowerCase(charArray[i]);
            if (vowels.contains(lowerChar)) {
                charArray[i] = reversedVowel.get(index);
                index++;
            }
        }
        return String.valueOf(charArray);
    }

}
