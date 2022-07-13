package TicketsSelling;

import java.util.Scanner;

public class Ticket {
  public static Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {

    boolean exit = false;
    boolean validexit = false;

    do {
      Credentials credentials = new Credentials();
      credentials.getCredentials();

      do {
        System.out.println("¿Desea ejecutar esta opción otra vez? (si/no)");
        String answer = scan.nextLine();

        if (answer.equalsIgnoreCase("si")) {
          validexit = true;
        } else if (answer.equalsIgnoreCase("no")) {
          validexit = true;
          exit = true;
        } else {
          System.out.println("Respuesta inválida, intente de nuevo");
        }

      } while (!validexit);
    } while (!exit);
    scan.close();
  }
}
