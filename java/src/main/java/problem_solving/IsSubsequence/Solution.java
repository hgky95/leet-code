package problem_solving.IsSubsequence;

import java.util.Arrays;

public class Solution {

    /**
     *
     */
    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) return true;

        int index = 0;
        for (char character : t.toCharArray()) {
            if (character == s.charAt(index)) {
                index++;
                if (index == s.length()) return true;
            }
        }
        return false;
    }
}
