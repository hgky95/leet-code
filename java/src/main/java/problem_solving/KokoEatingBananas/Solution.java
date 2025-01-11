package problem_solving.KokoEatingBananas;

import java.util.Arrays;

public class Solution {

    /**
     *  Using Binary Search
     *  1. Define low = 1 (minimum banana eat in 1 hour)
     *  2. Define high = max(piles) (maximum banana eat in 1 hour)
     *  3. Apply Binary Search (low < high):
     *      3.1 middle = (low + high) /2
     *      3.2 Calculate the total time to eat all piles based on current middle
     *      3.3 If totalTime > h:
     *              Eat too slow, need to increase speed (low = middle + 1), since the current middle is not valid
     *      3.4 If totalTime <= h:
     *              Can complete the eating but we might miss the smaller value that also works
     *              high = middle
     *   4. Return low which is the minimum banana that can eat per hour
     */
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();

        while (low < high) {
            int middle = (low + high) / 2;
            int totalTime = 0;
            for (int pile : piles) {
                totalTime = totalTime + (pile + middle -1) / middle; // Ceil division
            }
            if (totalTime > h) {
                low = middle + 1; // increase eating speed
            } else {
                high = middle; // decrease eating speed
            }
        }
        return low;
    }

    public static void main(String[] args) {
        Solution x = new Solution();
        int rs = x.minEatingSpeed(new int[] {3,6,7,11}, 8);
        System.out.println(rs);
    }

}
