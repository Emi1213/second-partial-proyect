package TicketsSelling;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Ticket {

  LocalDateTime purchaseStartTime = LocalDateTime.now();
  String purchaseStartTimeString = purchaseStartTime.toString();

  public static void main(String[] args) throws IOException {

    Credentials credentials = new Credentials();
    Descounts descounts = new Descounts();
    Destinos destinos;
    boolean exit = false;

    System.out.println("*********************************************************");
    System.out.println("*                                                       *");
    System.out.println("*     Bienvenido a la Aplicacionde venta de boletos     *");
    System.out.println("*            de viaje de transporte público             *");
    System.out.println("*                                                       *");
    System.out.println("*********************************************************");

    do {

      System.out.println("\n\n");
      System.out
          .println("Ingresa tus datos para poder comprar boletos\n Nota: La factura será generada con estos datos\n");

      credentials.getCredentials();
      destinos = new Destinos(Integer.parseInt(credentials.getArrayCredentials()[6]));

      destinos.showDestinos();
      ArrayList<Destino> totalDestinies = destinos.getDestinies();
      descounts.getSecondDescount(credentials.getDestinationsQuantity());
      descounts.getDescounts(credentials.getDescountClients());

      for (Destino destino : totalDestinies) {
        System.out.println(destino.getCityName() + " " + destino.getCityCode() + " " + destino.getNumberSeats() + " "
            + destino.getPrice());
      }
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
