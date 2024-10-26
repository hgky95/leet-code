package problem_solving.GreatestCommonDivisorOfStrings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("inputData")
    public void gcdOfStrings_returnGreatestCommonDivisorString(String firstStr, String secondStr, String expected) {
        String result = Solution.gcdOfStrings(firstStr, secondStr);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("inputData")
    public void gcdOfStringsOptimal_returnGreatestCommonDivisorString(String firstStr, String secondStr, String expected) {
        String result = Solution.gcdOfStringsOptimal(firstStr, secondStr);
        assertEquals(expected, result);
    }

    static Stream<Arguments> inputData() {
        return Stream.of(
                Arguments.of("ABCABC", "ABC", "ABC"),
                Arguments.of("ABABAB", "ABAB", "AB"),
                Arguments.of("LEET", "CODE", ""),
                Arguments.of("ABAB", "ABABAB", "AB"),
                Arguments.of("CXTXNCXTXNCXTXNCXTXNCXTXN", "CXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXN", "CXTXN"),
                Arguments.of("TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX", "TAUXXTAUXXTAUXXTAUXXTAUXX", "TAUXX"),
                Arguments.of("NLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGM", "NLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGM", "NLZGM"),
                Arguments.of("AAAAAAAAA", "AAACCC", "")
        );
    }
}
