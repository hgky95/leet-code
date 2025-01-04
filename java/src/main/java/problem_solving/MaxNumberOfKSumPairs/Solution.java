package problem_solving.MaxNumberOfKSumPairs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {

    /**
     * Using HashMap to store the frequency of each number
     * 1. Loop through each element from the array int
     * 2. Calculate the complete = k - num
     * 3. If complement is exist in the map:
     *      - increase counter
     *      - decrease the frequency of the complement
     * 4. If complement is not exist in the map:
     *      - put the num to the map as key and value as the frequency of it
     */
    public int maxOperationsHashMap(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int counter = 0;
        for (int num: nums) {
            int complement = k - num; // it means k = num + complement
            if (map.getOrDefault(complement, 0) > 0) {
                counter++;
                map.put(complement, map.get(complement) - 1);
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        return counter;
    }

    /**
     *  Time Complexity: O(n logn + n) = O(n)
     *      - Sorting: O(n logn)
     *      - Two pointer traversal: O(n)
     *  Using Two Pointers (Left and right pointers)
     *  1. Sort array first
     *  2. Loop on it until leftIndex > rightIndex:
     *      - Calculate sum
     *      - If sum == k:
     *          increase numOfOperation;
     *          move both pointers
     *      - If sum > k:
     *          move right pointer (to reduce the value since we already sorted it)
     *      - If sum < k:
     *          move left pointer (to increase the pointer)
     */
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        int numOfOperation = 0;
        int sum;
        while (leftIndex < rightIndex) {
            int leftValue = nums[leftIndex];
            int rightValue = nums[rightIndex];
            sum = leftValue + rightValue;
            if (sum == k) {
                numOfOperation++;
                leftIndex++;
                rightIndex--;
            } else {
                if (sum > k) {
                    rightIndex--;
                } else {
                    leftIndex++;
                }
            }
        }
        return numOfOperation;
    }

    public static void main(String[] args) {
        Solution x = new Solution();
        int rs = x.maxOperations(new int[]{2,2,2,3,1,1,4,1}, 4);
//        int rs = x.maxOperations(new int[]{1,2,3,4}, 5);
        System.out.println(rs);
    }
}
