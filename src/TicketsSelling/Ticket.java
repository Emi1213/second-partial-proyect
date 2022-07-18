package TicketsSelling;

import java.io.IOException;
import java.time.LocalDateTime;

public class Ticket {

  LocalDateTime purchaseStartTime = LocalDateTime.now();
  String purchaseStartTimeString = purchaseStartTime.toString();

  public static void main(String[] args) throws IOException {

    Credentials credentials = new Credentials();
    Destinos destinos = new Destinos();
    Ticket tickets = new Ticket();
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
      System.out
          .println("Ingresa tus datos para poder comprar boletos\n Nota: La factura será generada con estos datos");

      credentials.getCredentials();

      System.out.println("\n\n");

      destinos.showDestinos();

      tickets.showFacture();

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

  public void showFacture() throws IOException {

    Facture facture = new Facture();

    System.out.println("\n\n");
    System.out.println("Desea su factura fisica o electronica? (fisica/electronica)");
    String answer = System.console().readLine().trim();
    boolean validexit = false;

    do {
      if (answer.equalsIgnoreCase("fisica")) {

        facture.factureFisic();
        validexit = true;

      } else if (answer.equalsIgnoreCase("electronica")) {

        facture.factureElectronic();
        validexit = true;

      } else {
        System.out.println("Respuesta inválida, intente de nuevo");
      }
    } while (!validexit);

  }
}
