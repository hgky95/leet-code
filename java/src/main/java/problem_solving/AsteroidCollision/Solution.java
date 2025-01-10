package problem_solving.AsteroidCollision;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Solution {

    /**
     * Using Deque for better performance than Stack (legacy implementation)
     * Loop through the asteroids
     *      Do a while loop if the current queue is not empty, the last element in queue > 0 and asteroid < 0 (collision occur)
     *          Then comparing on their absolute values
     *              if they are the same:
     *                  - destroy the asteroid and also the last element in queue
     *              if last element > asteroid:
     *                  - destroy the asteroid only
     *              if last element < asteroid:
     *                  - destroy the last element
     *           if asteroid is still exist (not be destroyed):
     *              - add it to the queue
     */
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> deque = new ArrayDeque<>();

        for (int asteroid : asteroids) {
            while (!deque.isEmpty() && deque.peekLast() > 0 && asteroid < 0) {
                int lastElementAbs = Math.abs(deque.peekLast());
                int asteroidAbs = Math.abs(asteroid);
                if (lastElementAbs == asteroidAbs) {
                    asteroid = 0;
                    deque.removeLast();
                    break;
                } else if (lastElementAbs > asteroidAbs) {
                    asteroid = 0;
                    break;
                } else {
                    deque.removeLast();
                }
            }
            if (asteroid != 0) {
                deque.addLast(asteroid);
            }
        }
        return deque.stream().mapToInt(i -> i).toArray();
    }


    public static void main(String[] args) {
        Solution x = new Solution();
        int[] rs = x.asteroidCollision(new int[] {-2,-2,1,-2});
        for (int r : rs) {
            System.out.println(r);
        }

    }
}
