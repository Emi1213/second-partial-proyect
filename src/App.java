import java.util.Scanner;
import TicketsSelling.Ticket;
import FilesManagement.FilesManagement;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int option;
        System.out.println(
                "\n\nBienvenido al Proyecto del Segundo Parcial de Algoritmos y Lógica de Programación\n\n");
        System.out.println("Elije una opción para empezar\n");

        do {
            System.out.println("\t1. Tickets Selling");
            System.out.println("\t2. Files Management");
            System.out.println("\t3. Exit");
            System.out.print("\n\tOption -> ");

            try {
                option = Integer.valueOf(scan.next().replaceAll("\\D*", ""));
            } catch (Exception e) {
                System.out.println("\n\nProcura no cometer errores al ingresar la opción.");
                System.out.println("Debes ingresar un número entre 1 y 3.\n\n");
                option = 0;
                scan.nextLine();
            }

            switch (option) {
                case 1:
                    Ticket.main(null);
                    break;
                case 2:
                    FilesManagement.main(null);
                    break;
                case 3:
                    System.out.println("\nEs un gusto tenerte en nuestra aplicación, hasta pronto!\n");
                    break;
                default:
                    System.out.println("\nEsa opción no existe, intenta de nuevo\n");
                    break;
            }
        } while (option != 3);

        scan.close();
    }
}