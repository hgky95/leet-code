package problem_solving.MergeStringsAlternately;

public class Solution {

    public static String mergeAlternately(String word1, String word2) {
        char[] word1Array = word1.toCharArray();
        char[] word2Array = word2.toCharArray();
        StringBuilder builder = new StringBuilder();
        if (word1Array.length <= word2Array.length) {
            for (int i = 0; i < word1Array.length; i++) {
                builder.append(word1Array[i]).append(word2Array[i]);
            }
            builder.append(word2.substring(word1Array.length));
        } else {
            for (int i = 0; i < word2Array.length; i++) {
                builder.append(word1Array[i]).append(word2Array[i]);
            }
            builder.append(word1.substring(word2Array.length));
        }
        return builder.toString();
    }

}
