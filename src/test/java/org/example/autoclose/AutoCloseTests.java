package org.example.autoclose;

import org.junit.jupiter.api.AutoClose;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AutoCloseTests {

    @AutoClose
    HttpClient httpClient = HttpClient.newHttpClient();

    @AutoClose("stop")
    LocalHttpServer httpServer = new LocalHttpServer()
            .configure(server -> server.createContext("/echo", exchange -> {
                exchange.sendResponseHeaders(200, 0);
                exchange.getRequestBody().transferTo(exchange.getResponseBody());
                exchange.close();
            }))
            .start();

    @Test
    void httpServerRespondsWithExpectedStatusCode() throws Exception {
        var request = HttpRequest.newBuilder()
                .POST(BodyPublishers.ofString("Hello, World!"))
                .uri(URI.create("http://localhost:%d/echo".formatted(httpServer.getPort())))
                .build();

        var response = httpClient.send(request, BodyHandlers.ofString());

        assertEquals(200, response.statusCode());
        assertEquals("Hello, World!", response.body());
    }
}
