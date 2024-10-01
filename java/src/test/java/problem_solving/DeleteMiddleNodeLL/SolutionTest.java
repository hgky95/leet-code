package problem_solving.DeleteMiddleNodeLL;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("inputData")
    void deleteMiddleOptimized_shouldReturnCorrectedList(int[] input, int[] expected) {
        ListNode head = createLinkedList(input);
        ListNode reversed = Solution.deleteMiddleOptimized(head);
        assertThat(linkedListToArray(reversed)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("inputData")
    void deleteMiddle_shouldReturnCorrectedList(int[] input, int[] expected) {
        ListNode head = createLinkedList(input);
        ListNode reversed = Solution.deleteMiddle(head);
        assertThat(linkedListToArray(reversed)).isEqualTo(expected);
    }

    private ListNode createLinkedList(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    private int[] linkedListToArray(ListNode head) {
        java.util.List<Integer> list = new java.util.ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    static Stream<Arguments> inputData() {
        return Stream.of(
                Arguments.of(new int[]{1,3,4,7,1,2,6}, new int[]{1,3,4,1,2,6}),
                Arguments.of(new int[]{1,2,3,4,5,6}, new int[]{1,2,3,5,6}),
                Arguments.of(new int[]{1,2,3,4}, new int[]{1,2,4}),
                Arguments.of(new int[]{2,1}, new int[]{2})
        );
    }
}
