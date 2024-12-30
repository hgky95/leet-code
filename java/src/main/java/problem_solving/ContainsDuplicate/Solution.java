package problem_solving.ContainsDuplicate;

import java.util.HashSet;

public class Solution {

    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.size() < nums.length;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean result = solution.hasDuplicate(new int[] {1, 2, 3, 3});
        System.out.println(result);
    }
}
