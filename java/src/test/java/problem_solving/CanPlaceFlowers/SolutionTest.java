package problem_solving.CanPlaceFlowers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {

    @ParameterizedTest
    @MethodSource("inputData")
    public void canPlaceFlowersOptimized_returnCorrectDecision(int[] flowerbed, int n, boolean expectedResult) {
        boolean result = Solution.canPlaceFlowersOptimized(flowerbed, n);
        assertEquals(expectedResult, result);
    }

    @ParameterizedTest
    @MethodSource("inputData")
    public void canPlaceFlowers_returnCorrectDecision(int[] flowerbed, int n, boolean expectedResult) {
        boolean result = Solution.canPlaceFlowersOptimized(flowerbed, n);
        assertEquals(expectedResult, result);
    }

    static Stream<Arguments> inputData() {
        return Stream.of(
                Arguments.of(new int[]{1, 0, 0, 0, 1}, 1, true),
                Arguments.of(new int[]{1,0,0,0,1}, 2, false),
                Arguments.of(new int[]{0,0,1,0,0}, 1, true)
        );
    }
}
