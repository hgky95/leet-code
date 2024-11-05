package problem_solving.ReverseWordsInAString;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("inputData")
    public void reverseWords_returnReversedWords(String input, String expectedResult) {
        String result = Solution.reverseWords(input);
        assertEquals(expectedResult, result);
    }

    static Stream<Arguments> inputData() {
        return Stream.of(
                Arguments.of(" the sky ", "sky the"),
                Arguments.of("hello   my friend  ", "friend my hello")
        );
    }

}
