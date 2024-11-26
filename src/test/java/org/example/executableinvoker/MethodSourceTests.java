package org.example.executableinvoker;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@ExtendWith(IntegerResolver.class)
public class MethodSourceTests {

    @ParameterizedTest
    @MethodSource("groceries")
    void test(String item) {
        assertTrue(item.endsWith("2"));
    }

    static Stream<Arguments> groceries(int quantity) {
        return Stream.of(
                arguments("apples x" + quantity),
                arguments("lemons x" + quantity)
        );
    }

}
