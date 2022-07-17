package TicketsSelling;

import java.io.IOException;

public class Ticket {

  public static void main(String[] args) throws IOException  {

    boolean exit = false;
    boolean validexit = false;

    System.out.println("*********************************************************");
    System.out.println("*                                                       *");
    System.out.println("*     Bienvenido a la Aplicacionde venta de boletos     *");
    System.out.println("*            de viaje de transporte público             *");
    System.out.println("*                                                       *");
    System.out.println("*********************************************************");

    do {

      System.out.println("\n\n");

      Credentials credentials = new Credentials();
      credentials.getCredentials();

      Destinos destinos = new Destinos();
      destinos.getDestinos();

      do {

        System.out.println("\n\n");

        System.out.println("¿Desea ejecutar esta opción otra vez? (si/no)");
        String answer = System.console().readLine().trim();

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

  }
}
