package TicketsSelling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import utils.UserInput;

public class Destinos {

  String[] descountDestiny = { "151536", "171050", "185572" };
  String[] descountClients = { " 1413", "1515", "1710", "1855" };
  String regexdate = "^[0-9]{2}-[0-9]{2}-[0-9]{4}$";
  String regexnumberSeats = "^[0-9]{1,2}$";
  String regexDestinationName = "^[a-zA-Z]{1,20}$";
  String customErrorMessage = "El dato ingresado no es válido, intenta de nuevo";
  ArrayList<String> arrayDestinies = new ArrayList<String>();
  ArrayList<Destino> arrayDestiniesList = new ArrayList<Destino>();
  int destionationsQuantity;

  public Destinos(int destinationsQuantity) {
    this.destionationsQuantity = destinationsQuantity;
  }

  /**
   * @description This method is used to show the destinations from the file
   * @return void
   * @throws IOException
   */
  public void showDestinos() throws IOException {
    try {
      BufferedReader reader = new BufferedReader(new FileReader("src/TicketsSelling/Destinos.txt"));
      String line;

      while ((line = reader.readLine()) != null) {
        System.out.println(line);
        arrayDestinies.add(line);
      }

      reader.close();
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  public void getDestiny() {
    String destination;
    int numberSeats;

    System.out.println(arrayDestinies);

    for (int i = 0; i < destionationsQuantity; i++) {
      destination = UserInput.getUserParam("Ingresa el destino " + i + ":",
          regexDestinationName, customErrorMessage);

      numberSeats = Integer
          .parseInt(UserInput.getUserParam("Ingresa el número de asientos:",
              regexnumberSeats, customErrorMessage));
    }
  }
}
