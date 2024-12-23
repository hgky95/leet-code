package problem_solving.StringCompression;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("inputData")
    public void compress_newCharsWithRepeatingCounter(char[] input, char[] expected) {
        Solution solution = new Solution();
        int numOfElement = solution.compress(input);
        assertEquals(expected.length, numOfElement);
        assertArrayEquals(expected, Arrays.copyOf(input, numOfElement));
    }

    static Stream<Arguments> inputData() {
        return Stream.of(
                Arguments.of(new char[]{'a'}, new char[]{'a'}),
                Arguments.of(new char[]{'a','a','b','b','c','c','c'}, new char[]{'a','2','b','2','c','3'}),
                Arguments.of(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'}, new char[]{'a','b','1','2'})
        );
    }
}
