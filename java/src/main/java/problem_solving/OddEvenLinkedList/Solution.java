package problem_solving.OddEvenLinkedList;

public class Solution {

    /*
        Create two pointers: one for odd and one for even
        Traverse the list: connecting odd-indexed nodes together and even-indexed nodes together
        Connect the end of the odd-indexed list with the first of the even-indexed list
     */
    public static ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
