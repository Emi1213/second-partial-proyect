import java.util.Scanner;

import EmployeesManagement.EmployeesManagement;
import TicketsSelling.Ticket;
import utils.UserInput;
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
            UserInput.showMenu("main");
            option = UserInput.getUserOption(scan);

            switch (option) {
                case 1:
                    Ticket.main(null);
                    break;
                case 2:
                    FilesManagement.main(null);
                    break;
                case 3:
                    EmployeesManagement.main(null);
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

}