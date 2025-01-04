package problem_solving.MaxConsecutiveOnesIII;

public class Solution {

    /**
     *  Using two pointers (init with left=right=0)
     *  1. Loop on right index (move to the right side):
     *      if element of current right is 0, then decrease k (flipped bit)
     *      loop on k < 0:
     *          - we shrink the window by moving left
     *          - if element of current left is 0, then increase k (since we do not need to flip it, we passed it)
     *      max = length of the current window
     *          = right - left + 1 (including left element)
     */
    public int longestOnesOptimizedTime(int[] nums, int k) {
        int leftIndex = 0;
        int maxNumOfConsecutive = 0;
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
            maxNumOfConsecutive = Math.max(maxNumOfConsecutive, rightIndex - leftIndex + 1);
        }
        return maxNumOfConsecutive;
    }

    /**
     * It's O(n^2) due to reset startIndex and endIndex
     */
    public int longestOnes(int[] nums, int k) {
        int startIndex = 0;
        int endIndex = 0;
        int maxNumOfConsecutive = 0;
        int counter = 0;
        int originalK = k;
        while (endIndex <= nums.length - 1) {
            if (nums[endIndex] == 1) {
                counter++;
                endIndex++;
                maxNumOfConsecutive = Math.max(counter, maxNumOfConsecutive);
            } else if (k > 0) {
                counter++;
                k--;
                endIndex++;
                maxNumOfConsecutive = Math.max(counter, maxNumOfConsecutive);
            } else {
                startIndex++;
                endIndex = startIndex;
                counter = 0;
                k = originalK;
            }
        }
        return maxNumOfConsecutive;
    }

    public static void main(String[] args) {
        Solution x = new Solution();
        int rs = x.longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2);
        int rs2 = x.longestOnesOptimizedTime(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2);
        System.out.println(rs);
        System.out.println(rs2);
    }
}
