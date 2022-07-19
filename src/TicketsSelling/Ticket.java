package TicketsSelling;

import java.io.IOException;
import java.time.LocalDateTime;

public class Ticket {

  LocalDateTime purchaseStartTime = LocalDateTime.now();
  String purchaseStartTimeString = purchaseStartTime.toString();

  public static void main(String[] args) throws IOException {

    Credentials credentials = new Credentials();
    Destinos destinos = new Destinos();
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

      String[] userCredentials = credentials.getArrayCredentials();

      System.out.println("\n\n");

      destinos.showDestinos();

      Ticket.showFacture(userCredentials);

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

  /**
   * This method is used to show the facture with the user credentials that is
   * already entered by the user
   * 
   * @param userCredentials - array with user credentials (name, lastName, ID,
   *                        age, phone, email) to use in the Facture
   * @throws IOException
   */
  public static void showFacture(String[] userCredentials) throws IOException {

    Facture facture = new Facture(userCredentials[0], userCredentials[1], userCredentials[2],
        userCredentials[3], userCredentials[4], userCredentials[5]);

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
