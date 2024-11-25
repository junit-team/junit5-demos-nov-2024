package org.example.autoclose;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.function.Consumer;

public class LocalHttpServer {

    private final HttpServer httpServer;

    LocalHttpServer() {
        try {
            httpServer = HttpServer.create();
            httpServer.bind(new InetSocketAddress(InetAddress.getLoopbackAddress(), 0), 0);
        } catch (IOException e) {
            throw new RuntimeException("Failed to create HTTP server", e);
        }
    }

    LocalHttpServer configure(Consumer<HttpServer> configurer) {
        configurer.accept(httpServer);
        return this;
    }

    LocalHttpServer start() {
        httpServer.start();
        return this;
    }

    @SuppressWarnings("unused") // called via reflection from JUnit
    void stop() {
        httpServer.stop(0);
    }

    int getPort() {
        return httpServer.getAddress().getPort();
    }
}
