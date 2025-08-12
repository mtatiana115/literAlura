package com.alura.literatura.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.stereotype.Component;

@Component
public class ConsumidorApi {
    private final HttpClient client = HttpClient.newHttpClient();

    public String obtenerDatos(String url) {
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            // Imprime el código de estado para saber si la solicitud fue exitosa
            System.out.println("Código de estado de la respuesta: " + response.statusCode());
            // Imprime el cuerpo de la respuesta para ver el JSON
            System.out.println("Cuerpo de la respuesta: " + response.body());
            return response.body();
        } catch (Exception e) {
            System.err.println("Excepción al consumir API: " + e.getMessage());
            e.printStackTrace();
            return null; // Devuelve null para indicar un fallo
        }
    }
}
