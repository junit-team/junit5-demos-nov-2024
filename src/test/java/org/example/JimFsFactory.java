package org.example;

import com.google.common.jimfs.Jimfs;
import org.junit.jupiter.api.extension.AnnotatedElementContext;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.io.TempDirFactory;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;

class JimFsFactory implements TempDirFactory {

    private final FileSystem fileSystem;

    public JimFsFactory() {
        fileSystem = Jimfs.newFileSystem();
    }

    @Override
    public Path createTempDirectory(AnnotatedElementContext elementContext, ExtensionContext extensionContext) throws Exception {
        return Files.createTempDirectory(fileSystem.getPath("/"), "junit-");
    }

    @Override
    public void close() throws IOException {
        fileSystem.close();
    }
}
