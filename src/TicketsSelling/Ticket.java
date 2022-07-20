package TicketsSelling;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Ticket {

  LocalDateTime purchaseStartTime = LocalDateTime.now();
  String purchaseStartTimeString = purchaseStartTime.toString();

  public static void main(String[] args) throws IOException {

    Credentials credentials = new Credentials();
    Destinos destinos;
    boolean exit = false;
    boolean isValid = false;

    System.out.println("**************************   *******************************");
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

      Facture facture = new Facture(credentials.getArrayCredentials()[0], credentials.getArrayCredentials()[1],
          credentials.getArrayCredentials()[2], credentials.getArrayCredentials()[3],
          credentials.getArrayCredentials()[4], credentials.getArrayCredentials()[5],
          credentials.getDescountClients(), totalDestinies);

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

      do {
        try {
          System.out.println("\n\n");
          System.out.println("¿Desea desea igresar otra factura? (si/no)");
          String answer4 = System.console().readLine();
          if (answer4.equalsIgnoreCase("si")) {
            isValid = true;
          } else if (answer4.equalsIgnoreCase("no")) {
            isValid = true;
            exit = true;
          } else {
            System.out.println("\n\n");
            System.out.println("Ingrese una opcion valida");
          }
        } catch (Exception e) {
          System.out.println("Error: " + e.getMessage());
        }
      } while (!isValid);
    } while (!exit);

  }
}
