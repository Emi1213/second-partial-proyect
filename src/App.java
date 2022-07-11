import java.util.Scanner;
import TicketsSelling.Ticket;
import FilesManagement.FilesManagement;

public class App {
    static Scanner scan = new Scanner(System.in);

    /**
     * Start the program
     * 
     * @param args the command line arguments
     * @return void
     */

    public static void main(String[] args) {
        System.out.println("\n\nBienvenido al Proyecto del Segundo Parcial de Algoritmos y Lógica de Programación\n\n");
        System.out.println("Elije una opción para empezar\n");

        int option;

        do {
            showMenu();
            option = getUserOption(scan);

            switch (option) {
                case 1:
                    Ticket.main(null);
                    break;
                case 2:
                    FilesManagement.main(null);
                    break;
                case 3:
                    System.out.println("Option 3");
                    break;
                case 4:
                    System.out.println("\nEs un gusto tenerte en nuestra aplicación, hasta pronto!\n");
                    break;
                default:
                    System.out.println("\nEsa opción no existe, intenta de nuevo\n");
                    break;
            }

        } while (option != 4);
    }

    /**
     * Shows the menu to the user
     * 
     * @return void
     */

    public static void showMenu() {
        System.out.println("\t1. Tickets Selling");
        System.out.println("\t2. Files Management");
        System.out.println("\t3. Tercera opción");
        System.out.println("\t4. Salir");
        System.out.print("\n\t-> ");
    }

    /**
     * Gets the user option
     * 
     * @param scan Scanner to get the user option
     * @return {int} The user option
     */

    public static int getUserOption(Scanner scan) {
        try {
            return Integer.valueOf(scan.next().replaceAll("\\D*", ""));
        } catch (Exception e) {
            System.out.println("\n\nProcura no cometer errores al ingresar la opción.");
            System.out.println("Debes ingresar un número entre 1 y 3.\n\n");
            scan.nextLine();
            return 0;
        }
    }
}