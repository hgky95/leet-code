package problem_solving.ContainerWithMostWater;

public class Solution {

    /**
     *  Using two pointers (left & right pointer)
     *  Container = width x min(left_height, right_height)
     *      width = right_index - left_index
     *  Loop on the height[] until leftIndex > rightIndex:
     *      - Calculate new width
     *      - Calculate min height
     *      - Set new max amount of water
     *      - Update the index on left or right
     *          if leftValue <= rightValue:
     *              increase left index (because the current left value is small, we need to find the new one to maximum the height)
     *          else
     *              decrease right index
     */
    public int maxArea(int[] height) {
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        int maxAmountOfWater = 0;
        while (leftIndex < rightIndex) {
            int minHeight = Math.min(height[leftIndex], height[rightIndex]);
            int width = rightIndex - leftIndex;
            int currentAmountOfWater = minHeight * width;
            maxAmountOfWater = Math.max(currentAmountOfWater, maxAmountOfWater);
            if (height[leftIndex] <= height[rightIndex]) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }
        return maxAmountOfWater;
    }
}
