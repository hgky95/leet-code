package problem_solving.CanPlaceFlowers;

public class Solution {

    /**
     * Only one loop instead of two as below solution.
     * This approach also using left, current, right position but if the condition is match (left, current and right is empty) then place the flower
     * and also reduce n.
     * At the end, if n <= 0 it means we place all the flowers.
     */
    public static boolean canPlaceFlowersOptimized(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {
            boolean left = i == 0 || i == flowerbed[i - 1];
            boolean right = i == flowerbed.length - 1 || flowerbed[i + 1] == 0;
            if (left && flowerbed[i] == 0 && right) {
                flowerbed[i] = 1;
                n--;
            }
        }
        return n <= 0;
    }

    /**
     * Use three pointer (previous plot, current plot and next plot). If all there pointers are empty, then add new flower into the current plot
     * In the final, compare the number of added flowers vs the given flowers. If it is equal, return true. Otherwise, return false.
     */
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        boolean isPossibleToPlan = false;
        int addedFlowers = 0;
        for (int i = 1; i <= n; i++) {
            int previousPlot = 0;
            for (int j = 0; j < flowerbed.length; j++) {
                int currentPlot = flowerbed[j];
                int nextPlot = 0;
                if (j != flowerbed.length - 1) {
                    nextPlot = flowerbed[j+1];
                }
                if (previousPlot == 0 && currentPlot == 0 && nextPlot == 0) {
                    flowerbed[j] = 1;
                    addedFlowers++;
                    break;
                }
                previousPlot = flowerbed[j];
            }
        }
        if (addedFlowers == n) {
            isPossibleToPlan = true;
        }
        return isPossibleToPlan;
    }

}
