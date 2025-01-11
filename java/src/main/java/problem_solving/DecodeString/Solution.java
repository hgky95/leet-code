package problem_solving.DecodeString;

import java.util.Stack;

public class Solution {

    /**
     * Using stack for storing character
     * Loop through each character:
     *      1. if it is not close bracket ']':
     *          Adding this character to the stack
     *      2. if it is close bracket:
     *          2.1 Init a subString to store the current string
     *          2.2 Back track on the stack until it reach the open bracket or stack is empty:
     *              - update the subString
     *          2.3 remove the open bracket
     *          2.4 Init a k value (the repeated time)
     *          2.5 Back track on the stack until stack is empty or it is not the digit:
     *              - update the k value
     *          2.6 Combine the new subString by multiply k and current subString and then push it to the stack
     *          2.7 Combine string on the stack and return value
     */
    public String decodeString(String s) {
        String decodedString = "";
        Stack<String> stack = new Stack<>();

        for (char character : s.toCharArray()) {
            if (character != ']') {
                stack.push(String.valueOf(character));
            } else {
                String subString = "";
                while (!stack.isEmpty() && !stack.peek().equals("[")) {
                    subString = stack.pop() + subString;
                }
                stack.pop();
                String k = "";
                while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0)) ) {
                    k = stack.pop() + k;
                }
                String subStringMultiplied = "";
                for (int i = 0; i < Integer.parseInt(k); i++) {
                    subStringMultiplied += subString;
                }
                stack.push(subStringMultiplied);
            }
        }
        while (!stack.isEmpty()) {
            decodedString = stack.pop() + decodedString;
        }
        return decodedString;
    }

    public static void main(String[] args) {
        Solution x = new Solution();
        String rs = x.decodeString("3[a]2[bc]");
        System.out.println(rs);
    }
}
