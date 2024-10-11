package problem_solving.MaximumTwinSumLL;

public class Solution {

    /*
        Maximum Twin Sum by separate the list into two parts using slow and fast pointer.
        After that:
            - the slow pointer goes to the right side of the list
            - the pre pointer goes to the left side of the list
        Then we sum slow.val + pre.val and using Math.max() to compare the value of each time.
     */
    public static int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode tmp = slow.next;
            slow.next = pre;
            pre = slow;
            slow = tmp;
        }
        int max = 0;
        while(slow != null) {
            max = Math.max(max, slow.val + pre.val);
            slow = slow.next;
            pre = pre.next;
        }
        return max;
    }

    public static int pairSumBruteForce(ListNode head) {
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        ListNode firstTwin = head;
        int max = 0;
        int temp_max;
        int counter = 0;
        while(counter <= (length / 2) -1) {
            int secondTwinCounter = counter;
            ListNode secondTwin = firstTwin;
            while (secondTwinCounter < length - 1 - counter) {
                secondTwin = secondTwin.next;
                secondTwinCounter++;
            }
            temp_max = firstTwin.val + secondTwin.val;
            if (temp_max > max) {
                max = temp_max;
            }
            firstTwin = firstTwin.next;
            counter++;
        }
        return max;
    }

}
