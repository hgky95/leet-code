package problem_solving.DeleteMiddleNodeLL;

public class Solution {

    /*
    This method using 'slow and fast pointer' technique to find the middle node by only single pass
    Let n be the number of nodes:
        - Fast pointer moves 2 steps each iteration
        - Slow pointer moves 1 step each iteration
    When fast reaches or passes the end: 2x ≥ n
    Therefore, x ≥ n/2
     */
    public static ListNode deleteMiddleOptimized(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static ListNode deleteMiddle(ListNode head) {
        int length = 0;
        ListNode temp = head;
        //Loop through list to get length
        while(temp != null) {
            length++;
            temp = temp.next;
        }
        ListNode curr = head;
        ListNode pre = null;
        int middleNodeIndex = length / 2;
        int counter = 0;
        //compare counter with middle node index
        while (curr != null & counter != middleNodeIndex) {
            pre = curr;
            curr = curr.next;
            counter++;
        }
        if (pre == null) {
            return head.next;
        } else {
            pre.next = curr.next;
            return head;
        }
    }

}
