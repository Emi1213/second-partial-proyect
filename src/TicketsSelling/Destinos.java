package TicketsSelling;

import java.io.*;
import java.util.ArrayList;

import utils.*;

public class Destinos {

  boolean exit = false;
  String[] codetDestiny = { "17", "13", "09", "07" };
  String regexdate = "^[0-9]{2}-[0-9]{2}-[0-9]{4}$";
  String regexnumberSeats = "^[0-9]{1,2}$";
  String regexDestinationName = "^[a-zA-Z]{1,20}$";
  String regexNumbers = "^[0-9]{1,2}$";
  String customErrorMessage = "El dato ingresado no es válido, intenta de nuevo";
  String[] destinies = { " Quito/17/60/5/3",
      " Manta/13/40/7/5", " Loja/11/50/10/8", " Guayaquil/09/30/5/3", " Cuenca/01/40/7/5",
      "Macas/14/50/9/7", "Riobamba/06/60/7/5", "Machala/07/40/3/5", "Latacunga/05/50/4/3",
      "Ibarra/10/60/7/5" };
  int destiniesNumber;

  public Destinos(int destiniesNumber) {
    this.destiniesNumber = destiniesNumber;
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

      File file = new File("src/TicketsSelling/Destinos.txt");

      if (!file.exists()) {
        file.createNewFile();
        FileWriter writer = new FileWriter(file);

        writer.write("\n\n");
        writer.write("*********************************************************\n");
        writer.write("*                                                       *\n");
        writer.write("*               Lista de destinos                       *\n");
        writer.write("*                                                       *\n");
        writer.write("*********************************************************\n");
        writer.write("\n\n");

        writer.write(" Ciudad/Codigo/Numero de Asientos/Precio normal/Precio por grupos \n");

        for (int i = 0; i < destinies.length; i++) {
          writer.write((i + 1) + "." + destinies[i] + "\n");
        }
        writer.close();

        while ((line = reader.readLine()) != null) {
          System.out.println(line);
        }
        reader.close();

      } else if (file.exists()) {
        while ((line = reader.readLine()) != null) {
          System.out.println(line);
        }
        reader.close();

      }

      reader.close();
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  public ArrayList<Destino> getDestinies() {
    ArrayList<Destino> listDestinies = new ArrayList<>();

    for (int i = 1; i <= destiniesNumber; i++) {
      int option;
      int numberSeats;
      String dateToTravel;

      System.out.println("Selecciona el destino " + i + ": ");

      for (int j = 0; j < destinies.length; j++) {
        System.out.println("\t" + (j + 1) + ". " + destinies[j].split("/")[0].trim());
      }

      option = UserInput.getUserOption();

      if (option > 0 && option <= destinies.length) {
        numberSeats = Integer
            .parseInt(UserInput.getUserParam("Ingrese el numero de asientos", regexNumbers, customErrorMessage));

        dateToTravel = UserInput.getUserParam("Ingrese la fecha de viaje (dd-mm-yyyy)", regexdate, customErrorMessage);

        Destino destino = new Destino(destinies[option - 1], numberSeats, dateToTravel);

        listDestinies.add(destino);
      } else {
        System.out.println("Opción inválida");
      }
    }

    return listDestinies;
  }
}
