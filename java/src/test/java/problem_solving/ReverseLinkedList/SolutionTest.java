package problem_solving.ReverseLinkedList;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("inputData")
    void reverseList_shouldReturnReversedList(int[] input, int[] expected) {
        Solution solution = new Solution();
        Solution.ListNode head = createLinkedList(solution, input);
        Solution.ListNode reversed = solution.reverseList(head);
        assertThat(linkedListToArray(reversed)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("inputData")
    void reverseListRecursive_shouldReturnReversedList(int[] input, int[] expected) {
        Solution solution = new Solution();
        Solution.ListNode head = createLinkedList(solution, input);
        Solution.ListNode reversed = solution.reverseListRecursive(head);
        assertThat(linkedListToArray(reversed)).isEqualTo(expected);
    }

    private Solution.ListNode createLinkedList(Solution solution, int[] values) {
        Solution.ListNode dummy = new Solution.ListNode(0);
        Solution.ListNode current = dummy;
        for (int val : values) {
            current.next = new Solution.ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    private int[] linkedListToArray(Solution.ListNode head) {
        java.util.List<Integer> list = new java.util.ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    static Stream<Arguments> inputData() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{5, 4, 3, 2, 1}),
                Arguments.of(new int[]{1, 2}, new int[]{2, 1}),
                Arguments.of(new int[]{}, new int[]{}),
                Arguments.of(new int[]{1}, new int[]{1})
        );
    }

}
