package problem_solving.OddEvenLinkedList;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("inputData")
    void oddEvenList_shouldReturnCorrectedList(int[] input, int[] expected) {
        ListNode head = createLinkedList(input);
        ListNode newLL = Solution.oddEvenList(head);
        assertThat(linkedListToArray(newLL)).isEqualTo(expected);
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
                Arguments.of(new int[]{1,2,3,4,5}, new int[]{1,3,5,2,4}),
                Arguments.of(new int[]{2,1,3,5,6,4,7}, new int[]{2,3,6,7,1,5,4}),
                Arguments.of(new int[]{8}, new int[]{8})
        );
    }
}
