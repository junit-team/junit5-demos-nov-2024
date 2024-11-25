package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TempDirTests {

    @Test
    void test(@TempDir Path tempDir) throws Exception {
        var testFile = tempDir.resolve("test.txt");

        Files.writeString(testFile, "Hello, World!");

        assertEquals("Hello, World!", Files.readString(testFile));
    }
}
