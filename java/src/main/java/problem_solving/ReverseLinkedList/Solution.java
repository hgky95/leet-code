package problem_solving.ReverseLinkedList;

public class Solution {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     *  Define the: current node and prev node
     *  Loop on the array values:
     *      Change the direction of the node
     */
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseListRecursive(head.next);
        head.next.next = head; // Update the connection point to the prev node
        head.next = null; // Break the old connection
        return newHead;
    }

    public static void main(String[] args) {
        int[] values = new int[] {2,3,4,5};
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }

        Solution x = new Solution();
        ListNode reversedLL = x.reverseListRecursive(head);
        System.out.println(reversedLL);
    }

}


