package problem_solving.ProductOfArrayExceptSelf;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("inputData")
    public void productExceptSelf_returnNewArrayWithProductExceptSelf(int[] input, int[] expected) {
        Solution solution = new Solution();
        int[] result = solution.productExceptSelf(input);
        assertArrayEquals(expected, result);
    }

    static Stream<Arguments> inputData() {
        return Stream.of(
                Arguments.of(new int[]{5,6}, new int[]{6,5}),
                Arguments.of(new int[]{1,2,3,4}, new int[]{24,12,8,6}),
                Arguments.of(new int[]{-1,1,0,-3,3}, new int[]{0,0,9,0,0})
        );
    }
}
