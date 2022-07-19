package TicketsSelling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import utils.UserInput;

public class Destinos {

  boolean exit = false;
  String[] cityDescount = { "001", "002" };
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
  ArrayList<Double> pricesWithD = new ArrayList<Double>();

  public void getDestiny() {
    int cont = 0;
    int cont1 = 0;
    int cont2 = 0;
    String code = "";
    boolean validation = false;
    String line = "";
    String city = "";
    int numberSeatsToSet;
    int price;
    double priceWithDescount = 0;
    String codecity = "";

    do {
      cont++;
      try {
        System.out.println("\n\n");
        do {
          System.out.println("Escoga el numero de destino que desea: ");
          int destiny = Integer.parseInt(System.console().readLine());
          switch (destiny) {
            case 1:
              line = destination[0];
              city = "Quito";
              code = "17";
              codecity = "001";
              validation = true;

              break;
            case 2:
              line = destination[1];
              city = "Manta";
              code = "13";
              validation = true;
              codecity = "002";
              break;
            case 3:
              line = destination[2];
              city = "Loja";
              validation = true;
              codecity = "001";
              break;
            case 4:
              line = destination[3];
              city = "Guayaquil";
              code = "4";
              validation = true;
              codecity = "002";
              break;
            case 5:
              line = destination[4];
              city = "Cuenca";
              validation = true;
              codecity = "001";
              break;
            case 6:
              line = destination[5];
              city = "Macas";
              validation = true;
              break;
            case 7:
              line = destination[6];
              city = "Riobamba";
              codecity = "001";
              validation = true;
              break;
            case 8:
              line = destination[7];
              city = "Machala";
              code = "09";
              codecity = "002";
              validation = true;
              break;
            case 9:
              line = destination[8];
              city = "Latacunga";
              codecity = "001";
              validation = true;
              break;
            case 10:
              line = destination[9];
              city = "Ibarra";
              codecity = "001";
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

        String date = UserInput.getUserParam("Ingresa la fecha de viaje  ", regexdate, customErrorMessage);

        NumberSeats numberSeats = new NumberSeats();

        price = numberSeats.Destin(line, numberSeatsToSet);

        for (int k = 0; k < codetDestiny.length; k++) {
          if (codetDestiny[k].equals(code)) {
            priceWithDescount = price - (price * 0.10);
          } else {
            priceWithDescount = price;
          }
        }

        if (codecity.equals("001")) {
          cont1++;
        } else if (codecity.equals("002")) {
          cont2++;
        }

        pricesWithD.add(priceWithDescount);
        listDestiny.add(city + "  " + numberSeatsToSet + "  " + date + "  " + priceWithDescount);

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
