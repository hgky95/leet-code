package problem_solving.KidsWithGreatestNumberOfCandies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    /**
     *  1. Find the max candy in the candies array
     *  2. Compare the new array (current candy + extra candy) with max candy
     */
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandy = candies[0];
        for (int candy : candies) {
            if (candy >= maxCandy) {
                maxCandy = candy;
            }
        }
        List<Boolean> kidsWithGreatestCandies = new ArrayList<>(candies.length);
        for (int candy : candies) {
            kidsWithGreatestCandies.add(candy + extraCandies >= maxCandy);
        }
        return kidsWithGreatestCandies;
    }

    public static List<Boolean> kidsWithCandiesJava8(int[] candies, int extraCandies) {
        int maxCandy = Arrays.stream(candies).max().orElse(0);
        return Arrays.stream(candies).mapToObj(candy -> (candy + extraCandies) >= maxCandy)
                .collect(Collectors.toList());
    }
    
}
