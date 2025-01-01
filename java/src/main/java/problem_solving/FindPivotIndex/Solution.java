package problem_solving.FindPivotIndex;

public class Solution {

    /**
     * 1. Calculate sum of the array, set it as rightSum (sum of all elements on the right side of pivot index)
     * 2. Loop through each element on the array:
     *  2.1. leftSum start from 0 and increase sum over the iteration
     *  2.2. rightSum is sum of array eliminate the current element
     *  2.3. if leftSum is equal rightSum, then return the current index. Otherwise, return -1
     */
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int leftSum = 0;
        int rightSum = sum;
        int pivotIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if ( i > 0) {
                leftSum = leftSum + nums[i-1];
            }
            rightSum = rightSum - nums[i];
            if (leftSum == rightSum) {
                pivotIndex = i;
                break;
            }
        }
        return pivotIndex;
    }
}
