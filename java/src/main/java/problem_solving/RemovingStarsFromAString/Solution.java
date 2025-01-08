package problem_solving.RemovingStarsFromAString;

import java.util.LinkedList;

public class Solution {

    /**
     * Loop through each character
     * If current character is *:
     *      - append to string builder
     * Otherwise:
     *      - remove the last value in the string builder by reduce length
     */
    public String removeStarsOptimized(String s) {
        StringBuilder sb = new StringBuilder();
        for (char character : s.toCharArray()) {
            if (character == '*') {
                sb.setLength(sb.length() - 1); //reduce length to remove the last item, simulate pop
            } else {
                sb.append(character);
            }
        }
        return sb.toString();
    }

}
