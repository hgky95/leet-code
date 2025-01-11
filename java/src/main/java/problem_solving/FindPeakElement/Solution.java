package problem_solving.FindPeakElement;

public class Solution {

    /**
     * Using Binary Search to achieve O(log n) that is better than Linear Scan O(n)
     * Start with low = 0; high = nums.length - 1
     * while loop if low <= high:
     *      1. Calculate the middle index and its value
     *          1.1 Handle some edge cases:
     *              if middle is index 0, check right neighbor
     *              if middle is index length - 1, check left neighbor
     *      2. if middle value > right side && middle value > left side -> return index directly
     *      3. else if middle value < right side, move low to middle + 1 (move to the right)
     *      4. else if middle value > right side, high = middle (move to the left)
     */
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        if (nums.length == 2) {
            if (nums[0] > nums[1]) return 0;
            if (nums[0] < nums[1]) return 1;
        }
        int low = 0;
        int high = nums.length - 1;
        int result = -1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            int middleValue = nums[middle];
            if (middle == 0 && middleValue > nums[middle + 1]) {
                return middle;
            }
            if (middle == nums.length - 1 && middleValue > nums[middle - 1]) {
                return nums.length - 1;
            }
            if (middleValue > nums[middle + 1] && middleValue > nums[middle - 1]) {
                result = middle;
                break;
            } else if (middleValue < nums[middle + 1]) {
                low = middle + 1;
            } else {
                high = middle;
            }
        }
        return result;
    }
}
