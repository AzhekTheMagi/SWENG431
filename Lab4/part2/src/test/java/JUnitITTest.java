/**
 * author: Anthony Vallin, aav5195
 * class: SWENG 431
 * date: 20220202
 * Assignment: Lab4 Part2
 * Description: Performs Robustness testing on function foo.
 */

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JUnitITTest {

    // Robustness test on function foo. Values derived from lab instructions.
    @DisplayName("Should display the correct triangle type")
    @ParameterizedTest(name = "{index} => a={0}, b={1}, c={2}, triangleType={3}")
    @CsvSource({
            "50,  100, 100, isosceles",
            "50,  100, 101, scalene",
            "50,  100, 150, scalene",
            "50,  100, 199, scalene",
            "50,  100, 200, scalene",
            "50,  50,  150, isosceles",
            "50,  51,  150, scalene",
            "50,  149, 150, scalene",
            "50,  150, 150, isosceles",
            "1,   100, 150, scalene",
            "2,   100, 150, scalene",
            "99,  100, 150, scalene",
            "100, 100, 150, isosceles",
            "50,  100, 99,  scalene",
            "50,  100, 201, scalene",
            "50,  49,  150, scalene",
            "50,  151, 150, scalene",
            "0,   100, 150, scalene",
            "101, 100, 150, scalene"
    })
    void foo_ShouldReturnCorrectTriangle(int a, int b, int c, String triangleType)
    {
        assertEquals(triangleType, JUnitIT.foo(a, b, c));
    }
}