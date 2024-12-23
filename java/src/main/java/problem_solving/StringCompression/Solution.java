package problem_solving.StringCompression;

public class Solution {

    /**
     * 1. Loop through the given input
     * 2. If the current character equals to the next character -> increase counter
     * 3. If it is different, write the current character into the chars by the writeIndex,
     *    then increase it for the next iteration
     * 4. If repeating more than 1, loop on each character of the digit and write to the chars
     * 5. Reset counter after writing
     */
    public int compress(char[] chars) {
        int writeIndex = 0;
        int repeatingCounter = 1;

        for (int i = 0; i < chars.length; i++) {
            if (i + 1 < chars.length && chars[i] == chars[i+1]) {
                repeatingCounter++;
            } else {
                chars[writeIndex] = chars[i];
                writeIndex++;
                if (repeatingCounter > 1) {
                    for (char c: Integer.toString(repeatingCounter).toCharArray()) { // 15 -> {'1', '5'}
                        chars[writeIndex] = c;
                        writeIndex++;
                    }
                }
                repeatingCounter = 1;
            }
        }
        return writeIndex;
    }

    public static void main(String[] args) {
        Solution x = new Solution();
        char[] input = new char[] {'a','a','b','b','c','c','c'};
        x.compress(input);
    }
}
