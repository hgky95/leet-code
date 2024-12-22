package problem_solving.IncreasingTripletSubsequence;

public class Solution {

    /**
     * 1. Initialize two variables with infinity
     * 2. Iterate through the array once
     * 3. Update the variables based on the current number
     * 4. If we find a number larger than both variables, return true
     * 5. If no such number is found after the iteration, return false
     */
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int smallestVal = Integer.MAX_VALUE;
        int secondSmallestVal = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= smallestVal) {
                smallestVal = num;
            } else if (num <= secondSmallestVal) {
                secondSmallestVal = num;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     *  Brute force works for test cases but failed for time exceed
     */
    public boolean increasingTripletBruteForce(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                for (int k = 2; k < nums.length; k++) {
                    if (i < j && j < k && nums[i] < nums[j] && nums[j] < nums[k]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
