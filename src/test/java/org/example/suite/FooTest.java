package org.example.suite;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;

public class FooTest {

    @BeforeAll
    static void setUp() {
        System.out.println("      --> @BeforeAll in FooTest");
    }

    @RepeatedTest(2)
    void test() {
        System.out.println("         --> @Test in FooTest");
    }

    @AfterAll
    static void tearDown() {
        System.out.println("      --> @AfterAll in FooTest");
    }

}
