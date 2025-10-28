package com.sistemareservalibros;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Scanner;

import com.sistemareservalibros.repository.ReservaRepository;
import com.sistemareservalibros.repository.CopiaRepository;
import com.sistemareservalibros.repository.UsuarioRepository;
import com.sistemareservalibros.model.Reserva;
import com.sistemareservalibros.model.Copia;
import com.sistemareservalibros.model.Usuario;

@SpringBootApplication
public class SistemaReservaLibrosApplication implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Autowired
    private CopiaRepository copiaRepo;

    @Autowired
    private ReservaRepository reservaRepo;

    public static void main(String[] args) {
        SpringApplication.run(SistemaReservaLibrosApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner SC = new Scanner(System.in);

        System.out.println("=== Sistema de Reservas de Libros ===");
        System.out.print("Ingrese su ID de usuario: ");
        int userId = Integer.parseInt(SC.nextLine());

        var userOpt = usuarioRepo.findById(userId);
        if (userOpt.isEmpty()) {
            System.out.println("No encontrado.");
            return;
        }

        Usuario user = userOpt.get();
        System.out.println("✅ Bienvenido " + user.getNombreUsuario());

        boolean exit = false;
        while (!exit) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Ver copias disponibles");
            System.out.println("2. Reservar un libro");
            System.out.println("3. Devolver un libro");
            System.out.println("4. Salir");
            System.out.print("Opción: ");
            String option = SC.nextLine();

            switch (option) {
                case "1":
                    System.out.println("\n📚 Copias disponibles:");
                    copiaRepo.findAll().forEach(copia -> System.out.println(
                        "ID: " + copia.getId() +
                        " | Libro: " + copia.getLibro().getTituloLibro() +
                        " | Código: " + copia.getCodigoBarra() +
                        " | Ubicación: " + copia.getUbicacion()
                    ));
                    break;

                case "2":
                    System.out.print("Ingrese ID de copia a reservar: ");
                    int copiaId = Integer.parseInt(SC.nextLine());

                    var copiaOpt = copiaRepo.findById(copiaId);
                    if (copiaOpt.isEmpty()) {
                        System.out.println("La copia no existe.");
                        break;
                    }

                    if (reservaRepo.existsByCopia_Id(copiaId)) {
                        System.out.println("La copia ya está reservada.");
                        break;
                    }

                    Copia copia = copiaOpt.get();
                    Reserva reserva = new Reserva();
                    reserva.setUsuario(user);
                    reserva.setCopia(copia);
                    reservaRepo.save(reserva);
                    System.out.println("Reserva realizada con éxito.");
                    break;

                case "3":
                    System.out.print("Ingrese ID de copia a devolver: ");
                    int copiaReturnId = Integer.parseInt(SC.nextLine());

                    if (!reservaRepo.existsByCopia_Id(copiaReturnId)) {
                        System.out.println("No hay reserva activa para esta copia.");
                    } else {
                        reservaRepo.deleteByCopia_Id(copiaReturnId);
                        System.out.println("♻ devuelto correctamente.");
                    }
                    break;

                case "4":
                    exit = true;
                    break;

                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }

        SC.close();
        System.out.println("Hasta luego!");
    }
}




/* public static void main(String[] args) throws Exception {
        Scanner SC = new Scanner(System.in);

        Copia[] c = {
                new Copia(1,
                        "23542352",
                        "C1-D04",
                        "Echoes of the Deep",
                        "2023",
                        "Mira Khan",
                        " Oceanic Books",
                        "Historical Fantasy"),
                new Copia(2,
                        "3123414",
                        "B2-F09",
                        "Algorithmic Dreams",
                        "2022",
                        "Lin Zhuo",
                        " FutureCode Press",
                        "Techno Thriller"),
        };

        // Testing object
        // Copia milibro = new Copia(12, "CB Test", "UBTest", "TTest", "FBTest",
        // "ATest", "ETest", "GTest");
        // milibro.libroReservado();

        System.out.print("Ingrese su nombre: ");
        String nombre = SC.nextLine();

        System.out.print("Ingrese su correo electrónico: ");
        String email = SC.nextLine();

        Reserva reservaNueva = new Reserva();
        reservaNueva.UserAdd(1, nombre, email);

        boolean encontrado = false;
        boolean cancelar = false;

        while (!encontrado && !cancelar) {
            System.out.print("\nIntroduce el título del libro que buscas (o escribe 'q' para salir): ");
            String tituloBuscado = SC.nextLine().trim();

            if (tituloBuscado.equalsIgnoreCase("q") ||
                    tituloBuscado.equalsIgnoreCase("quit") ||
                    tituloBuscado.equalsIgnoreCase("exit")) {
                cancelar = true;
                System.out.println("\nBúsqueda cancelada por el usuario.");
                break;
            }

            for (Copia copia : c) {
                if (copia.getTitulo().equalsIgnoreCase(tituloBuscado)) {
                    System.out.println("\nTítulo encontrado: " + copia.getTitulo()
                            + "\nCopia reservada.");
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado && !cancelar) {
                System.out.println("\nNo se encontró ese libro. Revise si fue escrito bien."
                        + "\nIntente nuevamente o escriba 'q' para salir.");
            }
        }

        SC.close();  */