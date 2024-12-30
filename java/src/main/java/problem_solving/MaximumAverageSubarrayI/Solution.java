package problem_solving.MaximumAverageSubarrayI;

public class Solution {

    /**
     *  1. Calculate the sum of first group (from 0 -> k)
     *  2. Loop from index of k to the end of array:
     *      2.1 sum = current_sum + next value (right side of window) - left side of window
     *      2.2 Find max between two values
     */
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i=0; i < k; i++) {
            sum += sum;
        }

        double maxAvg = (double) sum / k;
        for (int i = k; i < nums.length; i++) {
            sum = sum + nums[i] - nums[i-k];
            maxAvg = Math.max(maxAvg, (double) sum/k);
        }

        return maxAvg;
    }

}
