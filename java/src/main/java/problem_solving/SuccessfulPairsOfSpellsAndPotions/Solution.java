package problem_solving.SuccessfulPairsOfSpellsAndPotions;

import java.util.Arrays;

public class Solution {

    /**
     *  Using Binary Search
     *  1. Sorted the potions array
     *  2. Loop on each element of spells array
     *      2.1 Calculate the minPotion = (success + spell - 1) / spell
     *      2.2 Apply Binary Search on potions array to find first index where potion >= minPotion
     *      2.3 The result is length of potion minus the index in #2.2
     *   Time Complexity:
     *      Sorting: O( m log m) - m is length of potions
     *      Binary Search for each spell: O (n * log m)
     *      Total: O(m * log m + n * log m) better than brute-force O(n*m)
     *
     */
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] successfulPairs = new int[spells.length];
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++) {
            int spell = spells[i];
            int low = 0;
            int high = potions.length - 1;
            long minPotion = (success + spell - 1) / spell; // to avoid floating-point division
            while (low <= high) {
                int middleIndex = low + (high - low) /2; // to avoid overflow
                int middleValue = potions[middleIndex];
                if (middleValue >= minPotion) {
                    high = middleIndex - 1;
                } else {
                    low = middleIndex + 1;
                }
            }
            successfulPairs[i] = potions.length - low;
        }
        return successfulPairs;
    }

    public static void main(String[] args) {
        Solution x = new Solution();
        int[] spells = new int[] {5,1,3};
        int[] potions = new int[] {1,2,3,4,5};
        long success = 7;
        int[] rs = x.successfulPairs(spells, potions, success);
        for (int r : rs) {
            System.out.println(r);
        }
    }
}
