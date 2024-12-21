package problem_solving.MoveZeroes;

import java.util.Arrays;

public class Solution {

    /**
     * Using two separate loops to reduce time complexity
     * 1. First loop: move all non-zero element to the left side
     * 2. Second loop: compare the current non-zero index with the length. If non-zero index < length, let's fill with 0
     */
    public void moveZeroesOptimal(int[] nums) {
        int nonZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nonZeroIndex] = nums[i];
                nonZeroIndex++;
            }
        }

        for (int i = nonZeroIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     *  Uses a nested loop approach:
     *  1. The outer loop iterates through all elements of the array.
     *  2. The inner loop handles non-zero elements:
     *    - If the current element is non-zero and the previous element is zero, they are swapped.
     *    - This process moves non-zero elements towards the front of the array.
     */
    public void moveZeroes(int[] nums) {
        for (int i=0; i < nums.length; i++) {
            for (int j=0; j < nums.length; j++) {
                if (nums[j] != 0 &&  (j-1) >= 0 && nums[j-1] == 0 ) {
                    int temp = nums[j];
                    nums[j-1] = temp;
                    nums[j] = 0;
                }
            }
        }
        Arrays.stream(nums).forEach(System.out::print);
        System.out.println("\n");
    }

    public static void main(String[] args) {
        Solution x = new Solution();
        int[] nums = new int[]{0,1,0,3,12};
        int[] nums1 = new int[]{2,0,1,0,3,12};
        int[] nums2= new int[]{-2,0,0,0,3,12};
        int[] nums3= new int[]{-2,9,0,0,3,0};
        int[] nums4= new int[]{0};
        x.moveZeroesOptimal(nums);
//        x.moveZeroesOptimal(nums1);
//        x.moveZeroesOptimal(nums2);
//        x.moveZeroesOptimal(nums3);
//        x.moveZeroesOptimal(nums4);
    }
}
