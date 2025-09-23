import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
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

        SC.close();
    }
}