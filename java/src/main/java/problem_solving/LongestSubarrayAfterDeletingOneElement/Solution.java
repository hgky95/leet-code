package problem_solving.LongestSubarrayAfterDeletingOneElement;

public class Solution {

    /**
     *  Using Sliding Window
     *  1. Init the window with leftIndex = rightIndex = 0; k = 1 is the number of times can remove element
     *  2. Sliding the window to right side until it reach the max right side
     *      2.1 Decrease k if the current element on the right is 0
     *      2.2 If k < 0:
     *         - Move to left index of window to the right
     *         - If the current left element is 0, we increase k by 1 since we do not remove it anymore
     *  3. Compare the longest each time with (rightIndex - leftIndex)
     */
    public int longestSubarray(int[] nums) {
        int leftIndex = 0;
        int k = 1;
        int longest = 0;

        for (int rightIndex = 0; rightIndex < nums.length; rightIndex++) {
            if (nums[rightIndex] == 0) {
                k--;
            }
            while (k < 0) {
                if (nums[leftIndex] == 0) {
                    k++;
                }
                leftIndex++;
            }

            longest = Math.max(longest, rightIndex - leftIndex);
        }
        return longest;
    }
}
