package problem_solving.ProductOfArrayExceptSelf;

public class Solution {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // Step 1: Calculate left products and store in answer array
        answer[0] = 1; // There are no elements to the left of the first element
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Step 2: Calculate right products and multiply to answer array
        int rightProduct = 1; // Initialize right product as 1 for the last element
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= rightProduct;
            rightProduct *= nums[i]; // Update the right product for the next element
        }

        return answer;
    }

}
