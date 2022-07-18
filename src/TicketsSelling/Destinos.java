package TicketsSelling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Destinos {
  public void getDestinos() throws IOException {

    File file = new File("src/TicketsSelling/Destinos.txt");
    file.createNewFile();

    FileWriter writer = new FileWriter(file);

    writer.write(" Ciudad  \t Codigo \t Número de Asientos \t Precio normal \t Precio por grupos \n");

    writer.write(" Quito    \t 171050 \t     60             \t   $5          \t      $3");
    writer.write(" Manta    \t 161514 \t     40             \t   $7          \t      $5");
    writer.write(" Cuenca   \t 185572 \t     55             \t   $9          \t      $7");
    writer.write(" Macas    \t 141536 \t     50             \t   $9          \t      $7");
    writer.write(" Guayaquil\t 151536 \t     45             \t   $5          \t      $3");
    writer.write(" Loja     \t 171536 \t     60             \t   $10         \t      $8");
    writer.write(" Manabi   \t 181536 \t     55             \t   $12         \t      $10");
    writer.write(" Ibarra   \t 191536 \t     50             \t   $12         \t      $10");
    writer.write(" Zamora   \t 201536 \t     45             \t   $10         \t      $8");
    writer.write(" Latacunga\t 211536 \t     60             \t   $3          \t      $2");
    writer.write("fin");

    writer.close();

  }
}
