package org.example.suite;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BarTest {

    @BeforeEach
    void setUp() {
        System.out.println("      --> @BeforeEach in BarTest");
    }

    @Test
    void test() {
        System.out.println("         --> @Test in BarTest");
    }

    @AfterEach
    void tearDown() {
        System.out.println("      --> @AfterEach in BarTest");
    }

}
