package problem_solving.IncreasingTripletSubsequence;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("inputData")
    public void increasingTriplet_returnTrueIfTripletExist(int[] input, boolean expected) {
        Solution solution = new Solution();
        boolean result = solution.increasingTriplet(input);
        assertEquals(expected, result);
    }

    static Stream<Arguments> inputData() {
        return Stream.of(
                Arguments.of(new int[]{0}, false),
                Arguments.of(new int[]{5,4}, false),
                Arguments.of(new int[]{0,1,0,3,12}, true),
                Arguments.of(new int[]{1,2,3,4,5}, true),
                Arguments.of(new int[]{5,4,3,2,1}, false),
                Arguments.of(new int[]{2,1,5,0,4,6}, true),
                Arguments.of(new int[]{1,1,1,1,1,1,1,1,1,1,1}, false)
        );
    }
}
