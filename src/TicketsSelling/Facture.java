package TicketsSelling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Facture {
  String name;
  String lastName;
  String ID;
  String age;
  String phone;
  String email;

  /**
   * This constructor is used to initialize the variables of the class
   * 
   * @param name
   * @param lastName
   * @param ID
   * @param age
   * @param phone
   * @param email
   */
  public Facture(String name, String lastName, String ID, String age, String phone, String email) {
    this.name = name;
    this.lastName = lastName;
    this.ID = ID;
    this.age = age;
    this.phone = phone;
    this.email = email;
  }

  public void factureElectronic() {
    System.out.println("\n\n");
    System.out.println("*********************************************************");
    System.out.println("*                                                       *");
    System.out.println("*     Factura de compra de boletos de viaje             *");
    System.out.println("*                                                       *");
    System.out.println("*********************************************************");
    System.out.println("\n\n");
    System.out.println("*********************************************************");
    System.out.println("*                                                       *");
    System.out.println("*     Datos de la compra                                *");
    System.out.println("*                                                       *");
    System.out.println("*********************************************************");
    System.out.println("\n\n");
    System.out.println("*********************************************************\n");
    System.out.println("*     Nombre: " + name);
    System.out.println("*     Apellido: " + lastName);
    System.out.println("*     ID: " + ID);
    System.out.println("*     Edad: " + age);
    System.out.println("*     Correo electrónico:" + email);
    System.out.println("*     Telefono: " + phone + "\n");
    System.out.println("*********************************************************");
  }

  public void factureFisic() throws IOException {
    File file = new File("src/TicketsSelling/Factura.txt");
    file.createNewFile();
    FileWriter writer = new FileWriter(file);
    writer.write("\n\n");
    writer.write("*********************************************************");
    writer.write("*                                                       *");
    writer.write("*     Factura de compra de boletos de viaje             *");
    writer.write("*                                                       *");
    writer.write("*********************************************************");
    writer.write("\n\n");
    writer.write("*********************************************************");
    writer.write("*                                                       *");
    writer.write("*     Datos de la compra                                *");
    writer.write("*                                                       *");
    writer.write("*********************************************************");
    writer.write("\n\n");
    writer.write("*********************************************************\n");
    writer.write("*     Nombre: " + name);
    writer.write("*     Apellido: " + lastName);
    writer.write("*     ID: " + ID);
    writer.write("*     Edad: " + age);
    writer.write("*     Correo electrónico:" + email);
    writer.write("*     Telefono: " + phone + "\n");
    writer.write("*********************************************************");
    writer.close();
  }
}
