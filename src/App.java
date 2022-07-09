import java.util.Scanner;
import TicketsSelling.Ticket;
import FilesManagement.FilesManagement;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n\n\n");
            System.out.println("Welcome to the Ticket Management System!");
            System.out.println("Please select an option:");
            System.out.println("1. Tickets Selling");
            System.out.println("2. Files Management");
            System.out.println("3. Exit");
            System.out.print("Option: ");

            try {
                option = Integer.valueOf(scan.next().replaceAll("\\D*", ""));
            } catch (Exception e) {
                System.out.println("Invalid option!");
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
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        } while (option != 3);

        scan.close();
    }
}