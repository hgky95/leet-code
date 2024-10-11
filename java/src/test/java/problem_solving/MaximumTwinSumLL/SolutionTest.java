package problem_solving.MaximumTwinSumLL;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("inputData")
    void pairSum_shouldReturnMaxTwinSum(int[] input, int expected) {
        ListNode head = createLinkedList(input);
        int max = Solution.pairSum(head);
        assertEquals(expected, max);
    }

    @ParameterizedTest
    @MethodSource("inputData")
    void pairSumBruteForce_shouldReturnMaxTwinSum(int[] input, int expected) {
        ListNode head = createLinkedList(input);
        int max = Solution.pairSumBruteForce(head);
        assertEquals(expected, max);
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

    static Stream<Arguments> inputData() {
        return Stream.of(
                Arguments.of(new int[]{5,4,2,1}, 6),
                Arguments.of(new int[]{4,2,2,3}, 7),
                Arguments.of(new int[]{1,100000}, 100001),
                Arguments.of(new int[]{1,9,3,8,4, 20}, 21)
        );
    }
}
