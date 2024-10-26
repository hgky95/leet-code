package problem_solving.KidsWithGreatestNumberOfCandies;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import problem_solving.KidsWithGreatestNumberOfCandies.Solution;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("inputData")
    public void kidsWithCandies_returnCorrectResult(int[] candies, int extraCandies, List<Boolean> expectedResult) {
        List<Boolean> result = Solution.kidsWithCandies(candies, extraCandies);
        assertEquals(expectedResult, result);
    }

    @ParameterizedTest
    @MethodSource("inputData")
    public void kidsWithCandiesJava8_returnCorrectResult(int[] candies, int extraCandies, List<Boolean> expectedResult) {
        List<Boolean> result = Solution.kidsWithCandiesJava8(candies, extraCandies);
        assertEquals(expectedResult, result);
    }

    static Stream<Arguments> inputData() {
        return Stream.of(
                Arguments.of(new int[] {2,3,5,1,3}, 3, List.of(true,true,true,false,true)),
                Arguments.of(new int[] {4,2,1,1,2}, 1, List.of(true,false,false,false,false)),
                Arguments.of(new int[] {12, 1, 2}, 10, List.of(true,false,true))
        );
    }
}
