package problem_solving.NumberofRecentCalls;

import java.util.LinkedList;

public class Solution {

    LinkedList<Integer> requests;
    public Solution() {
        requests = new LinkedList<>();
    }

    /**
     * LC933 - https://leetcode.com/problems/number-of-recent-calls/description/?envType=study-plan-v2&envId=leetcode-75
     * Add ping value whenever this method is called
     * Remove the first item if it is less than t - 3000
     */
    public int ping(int t) {
        requests.add(t);
        while (!requests.isEmpty() && requests.getFirst() < t - 3000) {
            requests.removeFirst();
        }
        return requests.size();
    }

}
