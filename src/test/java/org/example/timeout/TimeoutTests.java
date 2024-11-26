package org.example.timeout;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.CountDownLatch;

@Timeout(1)
public class TimeoutTests {

    @Test
    void fast() {
        printJUnitThreads("fast()");
    }

    @Test
    void slow() {
        printJUnitThreads("slow()");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Interrupted on thread: " + Thread.currentThread().getName());
//            waitIndefinitely();
        }
    }

    @AfterAll
    static void afterAll() {
        printJUnitThreads("@AfterAll");
    }

    private static void printJUnitThreads(String header) {
        System.out.printf("--- %s ---%n", header);
        System.out.println("JUnit threads:");
        Thread.getAllStackTraces().keySet().stream()
                .filter(it -> it.getName().equals("main") || it.getName().startsWith("junit-"))
                .forEach(it -> System.out.printf("- %s (%s)%s%n", it.getName(), it.getState(), it == Thread.currentThread() ? " <-- current" : ""));
        System.out.println();
    }

    @SuppressWarnings("unused")
    private static void waitIndefinitely() {
        try {
            new CountDownLatch(1).await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
