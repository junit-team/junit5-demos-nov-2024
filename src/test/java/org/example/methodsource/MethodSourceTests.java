package org.example.methodsource;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MyContextResolver.class)
public class MethodSourceTests {

    @ParameterizedTest
    @MethodSource("users(org.example.methodsource.MyContext)")
    void test(String username) {
        assertTrue(username.length() > 0);
    }

    static Stream<Arguments> users(MyContext myContext) {
        return myContext.getAllUsers()
                .stream().map(Arguments::arguments);
    }

    static void users() {

    }

}
