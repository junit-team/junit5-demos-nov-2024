package org.example.tempdir;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TempDirTests {

    @TempDir
    Path tempDir;

    @Test
    void canReadAndWriteTextFile() throws Exception {
        var testFile = tempDir.resolve("test.txt");

        Files.writeString(testFile, "Hello, World!");

        assertEquals("Hello, World!", Files.readString(testFile));
    }

    @Test
    void canReadAndWriteBinaryFile() throws Exception {
        var testFile = tempDir.resolve("test.out");
        int sizeInKiB = 1024;

        try (var outputStream = Files.newOutputStream(testFile)) {
            var random = new Random();
            var bufferSizeInKiB = 8;
            var buffer = new byte[bufferSizeInKiB * 1024];
            for (var i = 0; i < (sizeInKiB / bufferSizeInKiB); i++) {
                random.nextBytes(buffer);
                outputStream.write(buffer);
            }
        }

        var sizeInBytes = sizeInKiB * 1024;
        assertEquals(sizeInBytes, Files.size(testFile));
    }

}
