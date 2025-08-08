package com.alura.literatura.client;

import java.io.IOException;
import java.net.URI;
import java.net.http.*;

public class GutendexClient {

    public String buscarLibroPorTitulo(String titulo) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://gutendex.com/books/?search=" + titulo.replace(" ", "+")))
            .GET()
            .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al llamar la API");
            return "";
        }
    }
}
