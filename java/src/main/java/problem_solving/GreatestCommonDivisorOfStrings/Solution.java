package problem_solving.GreatestCommonDivisorOfStrings;

public class Solution {

    public static String gcdOfStrings(String str1, String str2) {
        String shorter = str1.length() < str2.length() ? str1 : str2;
        for (int i = shorter.length(); i > 0 ; i--) {
            String common = shorter.substring(0, i);
            if (canBeDivided(str1, common) && canBeDivided(str2, common)) {
                return common;
            }
        }
        return "";
    }

    public static boolean canBeDivided(String str, String common) {
        if (str.length() % common.length() != 0) {
            return false;
        }
        int timesOfRepeat = str.length() / common.length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < timesOfRepeat; i++) {
            stringBuilder.append(common);
        }
        return stringBuilder.toString().equals(str);
    }

    public static String gcdOfStringsOptimal(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) return "";
        int gcdLength = gcd(str1.length(), str2.length());
        return str1.substring(0, gcdLength);
    }

    public static int gcd(int firstNumber, int secondNumber) {
        while (secondNumber != 0) {
            int temp = secondNumber;
            secondNumber = firstNumber % secondNumber;
            firstNumber = temp;
        }
        return firstNumber;
    }
}
