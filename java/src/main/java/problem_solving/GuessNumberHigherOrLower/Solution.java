package problem_solving.GuessNumberHigherOrLower;

public class Solution {

    /**
     * Apply binary search
     * Find middleValue = low + (high - low) / 2
     * Compare it with the guess() from the challenge
     */
    public int guessNumber(int n) {
        int guessResult = -1;
        int low = 1;
        int high = n;
        while (guessResult == 1 || guessResult == -1) {
//            int middleValue = (high + low) / 2; this one could cause overflow it high + low > Integer.MAX_VALUE
            int middleValue = low + (high - low) / 2; // avoid overflow, both producing the same result
            guessResult = guess(middleValue);
            if (guessResult == 0) {
                return middleValue;
            } else if (guessResult == -1) {
                high = middleValue - 1;
            } else if (guessResult == 1) {
                low = middleValue + 1;
            }
        }
        return -1;
    }

    public int guess(int number) {
        int picked = 1702766719;
        if (number == picked) {
            return 0;
        } else if (number > picked) {
            return -1;
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        Solution x = new Solution();
        int rs = x.guessNumber(2126753390);
        System.out.println(rs);
    }

}
