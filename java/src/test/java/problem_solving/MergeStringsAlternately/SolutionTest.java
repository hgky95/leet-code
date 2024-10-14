package problem_solving.MergeStringsAlternately;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("inputData")
    public void mergeAlternately_returnMergedString(String firstWord, String secondWord, String expected) {
        String mergedString = Solution.mergeAlternately(firstWord, secondWord);
        assertEquals(expected, mergedString);

    }

    static Stream<Arguments> inputData() {
        return Stream.of(
                Arguments.of("abc", "pqr", "apbqcr"),
                Arguments.of("ab", "pqrs", "apbqrs"),
                Arguments.of("abcd", "pq", "apbqcd")
        );
    }
}
