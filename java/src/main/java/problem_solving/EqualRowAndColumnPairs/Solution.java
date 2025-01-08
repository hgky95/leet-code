package problem_solving.EqualRowAndColumnPairs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    /**
     * 1. Transpose the current grid
     *      e.g: [[3, 2, 1],
     *            [1, 7, 6],
     *            [2, 7, 7]]
     *   to     [[3, 1, 2],
     *           [2, 7, 7],
     *           [1, 6, 7]]
     *  2. Compare each element from original grid vs transposed grid. If it is equals, then increase the counter
     *  Time complexity: O(n^3)
     *      Transposing the Grid: O(n^2)
     *      Comparing Rows and Columns: O(n^3), every row is compared with every column
     *  Space complexity:
     *      Transposing the Grid: O(n^2)
     */
    public int equalPairs(int[][] grid) {
        int[][] transposed = new int[grid.length][grid.length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                transposed[j][i] = grid[i][j]; //swap rows and columns
            }
        }

        int equalPairCounter = 0;
        for (int[] gridElement : grid) {
            for (int[] transposedElement : transposed) {
                if (Arrays.equals(gridElement, transposedElement)) {
                    equalPairCounter++;
                }
            }
        }
        return equalPairCounter;
    }
}
