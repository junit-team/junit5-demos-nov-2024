package org.example.tempdir;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TempDirTests {

    @TempDir
    Path tempDir;

    @Test
    void canReadAndWriteTextFile(TestReporter reporter) throws Exception {
        reporter.publishEntry("File system", tempDir.getFileSystem().getClass().getName());

        var testFile = tempDir.resolve("test.txt");
        reporter.publishEntry("Test file", testFile.toAbsolutePath().toString());

        Files.writeString(testFile, "Hello, World!");

        assertEquals("Hello, World!", Files.readString(testFile));
    }

}
