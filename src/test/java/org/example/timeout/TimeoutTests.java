package org.example.timeout;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

@Timeout(1)
public class TimeoutTests {

    @Test
    void fast() {
        printJUnitThreads();
    }

    @Test
    void slow() {
        printJUnitThreads();
        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted on thread: " + Thread.currentThread().getName());
        }
    }

    private static void printJUnitThreads() {
        System.out.println("Active threads:");
        Thread.getAllStackTraces().keySet().stream()
                .filter(it -> it.getName().equals("main") || it.getName().startsWith("junit-"))
                .forEach(it -> System.out.println("- " + it.getName()));
        System.out.println();
    }
}
