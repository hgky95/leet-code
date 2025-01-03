package problem_solving.Dota2Senate;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    /**
     *  1. Create two queues to add all senators with index, e.g: RDD
     *      R = [0]; D = [1,2]
     *  2. Loop on the queues until it is empty:
     *      If radiant index < dire index:
     *          radiant win: move the senators to the end of queue
     *      If dire index < radiant index:
     *          dire win: move the senators to the end of queue
     *      Remove the first senator from both queues (one move to the end for next round, one is banned by opponent)
     */
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiants = new LinkedList<>();
        Queue<Integer> dires = new LinkedList<>();
        int n = senate.length();

        // Add all senators to queues with index
        for (int i = 0; i < n; i++){
            if (senate.charAt(i) == 'R'){
                radiants.add(i);
            } else {
                dires.add(i);
            }
        }

        // Increasing n to keep track of position
        while (!radiants.isEmpty() && !dires.isEmpty()){
            int radiantIndex = radiants.poll();
            int direIndex = dires.poll();
            // Only "winner" stays in their queue
            if (radiantIndex < direIndex){
                radiants.add(n++);
            } else {
                dires.add(n++);
            }

        }
        return (dires.isEmpty()) ? ("Radiant") : ("Dire");
    }

    public static void main(String[] args) {
        Solution x = new Solution();
        String rs = x.predictPartyVictory("RD");
        System.out.println(rs);
    }

}
