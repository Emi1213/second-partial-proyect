package TicketsSelling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Destinos {

  boolean exit = false;
  String[] codetDestiny = { "17", "13", "09", "07" };
  String regexdate = "^[0-9]{2}-[0-9]{2}-[0-9]{4}$";
  String regexnumberSeats = "^[0-9]{1,2}$";
  String regexDestinyName = "^[a-zA-Z]{1,20}$";
  String customErrorMessage = "El dato ingresado no es válido, intenta de nuevo";
  String[] destination = { " Quito/17/60/$5/$3",
      " Manta/13/40/$7/$5", " Loja/11/50/$10/$8", " Guayaquil/09/30/$5/$3", " Cuenca/01/40/$7/$5",
      "Macas/14/50/$9/$7", "Riobamba/06/60/$7/$5", "Machala/07/40/$3/$5", "Latacunga/05/50/$4/$3",
      "Ibarra/10/60/$7/$5" };

  /**
   * @description This method is used to show the destinations from the file
   * @return void
   * @throws IOException
   */
  public void showDestinos() throws IOException {

    try {

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

        for (int i = 0; i < destination.length; i++) {
          writer.write((i + 1) + "." + destination[i] + "\n");
        }
        writer.close();

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;

        while ((line = reader.readLine()) != null) {
          System.out.println(line);
        }
        reader.close();

      } else if (file.exists()) {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
          System.out.println(line);
        }
        reader.close();

      }
    } catch (Exception e) {

      System.out.println("Error: " + e.getMessage());

    }

  }

  ArrayList<String> listDestiny = new ArrayList<String>();

  public void getDestiny() {

    String code = "";
    boolean validation = false;
    String line = "";
    int numberSeatsToSet;

    do {
      try {
        System.out.println("\n\n");
        do {
          System.out.println("Escoga el numero de destino que desea: ");
          int destiny = Integer.parseInt(System.console().readLine());
          switch (destiny) {
            case 1:
              line = destination[0];
              listDestiny.add(line);
              code = "17";
              validation = true;

              break;
            case 2:
              line = destination[1];
              listDestiny.add(line);
              code = "13";
              validation = true;
              break;
            case 3:
              line = destination[2];
              listDestiny.add(line);
              validation = true;
              break;
            case 4:
              line = destination[3];
              listDestiny.add(line);
              code = "4";
              validation = true;
              break;
            case 5:
              line = destination[4];
              listDestiny.add(line);
              validation = true;
              break;
            case 6:
              line = destination[5];
              listDestiny.add(line);
              validation = true;
              break;
            case 7:
              line = destination[6];
              listDestiny.add(line);
              validation = true;
              break;
            case 8:
              line = destination[7];
              listDestiny.add(line);
              code = "09";
              validation = true;
              break;
            case 9:
              line = destination[8];
              listDestiny.add(line);
              validation = true;
              break;
            case 10:
              line = destination[9];
              listDestiny.add(line);
              validation = true;
              break;
            default:
              System.out.println("El numero de destino ingresado no es valido, intente de nuevo");
              break;
          }
        } while (!validation);

        do {
          System.out.println("Ingrese el numero de asientos que desea: ");
          numberSeatsToSet = Integer.parseInt(System.console().readLine());
          if (numberSeatsToSet > 0 && numberSeatsToSet <= 15) {
            validation = true;
          } else {
            System.out.println("El numero de asientos ingresado no es valido, intente de nuevo");
            validation = false;
          }
        } while (!validation);

        NumberSeats numberSeats = new NumberSeats();

        int price = numberSeats.Destin(line, numberSeatsToSet);

        // for (int k = 0; k < codetDestiny.length; k++) {
        // if (codetDestiny[k].equals(code)) {

        // }
        // }

        do {
          System.out.println("Desea ingresar otro destino? (Si/No)");
          String answer3 = System.console().readLine();

          if (answer3.equalsIgnoreCase("si")) {
            validation = true;
          } else if (answer3.equalsIgnoreCase("no")) {
            validation = true;
            exit = true;
          } else {
            System.out.println(customErrorMessage);
          }
        } while (!validation);

      } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());

      }
    } while (!exit);

  }

  // public static void getPoints(String line, int numberSeats) {
  // String[] dates = line.split("/");
  // int normalPrice = Integer.parseInt(dates[3]);
  // int groupPrice = Integer.parseInt(dates[4]);
  // int price = 0;
  // if (numberSeats <= 4) {

  // price = groupPrice * numberSeats;
  // }
  // }
}
