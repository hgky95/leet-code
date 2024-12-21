package problem_solving.MoveZeroes;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("inputData")
    public void moveZeroes_returnNewArrayThatOrderedZeroesToTheLeft(int[] input, int[] expected) {
        Solution solution = new Solution();
        solution.moveZeroesOptimal(input);
        assertArrayEquals(expected, input);
    }

    static Stream<Arguments> inputData() {
        return Stream.of(
                Arguments.of(new int[]{0}, new int[]{0}),
                Arguments.of(new int[]{0,1,0,3,12}, new int[]{1,3,12,0,0}),
                Arguments.of(new int[]{2,0,1,0,3,12}, new int[]{2,1,3,12,0,0}),
                Arguments.of(new int[]{-2,0,0,0,3,12}, new int[]{-2,3,12,0,0,0}),
                Arguments.of(new int[]{-2,9,0,0,3,0}, new int[]{-2,9,3,0,0,0})
        );
    }
}
