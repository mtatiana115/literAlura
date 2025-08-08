package com.alura.literatura;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraturaApplication  implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(LiteraturaApplication.class, args);
	}

	@Override
    public void run(String... args) {
        Scanner teclado = new Scanner(System.in);
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1 - Buscar libro por título");
            System.out.println("2 - Listar todos los libros");
            System.out.println("3 - Listar autores");
            System.out.println("4 - Autores vivos en un año");
            System.out.println("5 - Cantidad de libros por idioma");
            System.out.println("0 - Salir");
            System.out.print("Opción: ");
            opcion = teclado.nextInt();
            teclado.nextLine();

            // Llamar métodos correspondientes
        }

        System.out.println("¡Gracias por usar LiterAlura!");
	}

}
