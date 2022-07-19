package TicketsSelling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Destinos {

  String[] descountDestiny = { "151536", "171050", "185572" };
  String[] descountClients = { " 1413", "1515", "1710", "1855" };
  String regexdate = "^[0-9]{2}-[0-9]{2}-[0-9]{4}$";

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
        writer.write("*********************************************************");
        writer.write("*                                                       *");
        writer.write("*               Lista de destinos                       *");
        writer.write("*                                                       *");
        writer.write("*********************************************************");
        writer.write("\n\n");

        writer.write(" Ciudad  \t Codigo \t Numero de Asientos \t Precio normal \t Precio por grupos \n");

        writer.write(" Quito    \t 171050 \t     60             \t   $5          \t      $3\n");
        writer.write(" Manta    \t 161514 \t     40             \t   $7          \t      $5\n");
        writer.write(" Cuenca   \t 185572 \t     55             \t   $9          \t      $7\n");
        writer.write(" Macas    \t 141536 \t     50             \t   $9          \t      $7\n");
        writer.write(" Guayaquil\t 151536 \t     45             \t   $5          \t      $3\n");
        writer.write(" Loja     \t 171536 \t     60             \t   $10         \t      $8\n");
        writer.write(" Manabi   \t 181536 \t     55             \t   $12         \t      $10\n");
        writer.write(" Ibarra   \t 191536 \t     50             \t   $12         \t      $10\n");
        writer.write(" Zamora   \t 201536 \t     45             \t   $10         \t      $8\n");
        writer.write(" Latacunga\t 211536 \t     60             \t   $3          \t      $2\n");
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

  // metodo que retorne una linkedlist con los destinos

  public void getDestiny() {

    int numDestiny;
    String destiny;
    String numberSeats;
    boolean isValid = false;

    do {
      System.out.println("Ingrese el número de destinos que desea comprar");
      numDestiny = Integer.parseInt(System.console().readLine());

      System.out.println("El numero a diferentes destinos es: " + numDestiny);
      String answer = System.console().readLine();
      if (answer.equalsIgnoreCase("si")) {
        isValid = true;
      } else if (answer.equalsIgnoreCase("no")) {
        isValid = false;
      } else {
        System.out.println("Ingrese una opción válida");
      }
    } while (!isValid);

    String[] destinos = new String[numDestiny];

    for (int i = 0; i < numDestiny; i++) {
      do {
        System.out.println("Ingrese el primer destino");
        destiny = System.console().readLine();
        System.out.println("Ingrese el numero de asientos para el destino: " + destiny);
        numberSeats = System.console().readLine();

      } while (!isValid);

    }

  }
}
