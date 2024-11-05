package problem_solving.ReverseVowelsOfAString;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {


    @ParameterizedTest
    @MethodSource("inputData")
    public void reverseVowelsOptimal_returnReversedString(String input, String expectedResult) {
        String result = Solution.reverseVowelsOptimal(input);
        assertEquals(expectedResult, result);
    }

    @ParameterizedTest
    @MethodSource("inputData")
    public void reverseVowels_returnReversedString(String input, String expectedResult) {
        String result = Solution.reverseVowels(input);
        assertEquals(expectedResult, result);
    }

    static Stream<Arguments> inputData() {
        return Stream.of(
                Arguments.of("IceCreAm", "AceCreIm"),
                Arguments.of("leetcode", "leotcede")
        );
    }

}
