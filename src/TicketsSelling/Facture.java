package TicketsSelling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Facture {

  Credentials credentials = new Credentials();

  String[] Credencials;
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

  public void getCredentials() {
    credentials.getCredentials();
    Credencials = credentials.getArrayCredentials();
    name = Credencials[0];
    lastName = Credencials[1];
    ID = Credencials[2];
    age = Credencials[3];
    phone = Credencials[4];
    email = Credencials[5];

  }

  /**
   * @description This method is used to give the facture electronic of the user
   * @return void
   */
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

  /**
   * @description This method is used to give the facture fisic of the user
   * 
   * @return void
   */
  public void factureFisic() throws IOException {
    File file = new File("src/TicketsSelling/Factura.txt");
    file.createNewFile();
    FileWriter writer = new FileWriter(file);
    writer.write("\n\n");
    writer.write("*********************************************************\n");
    writer.write("*                                                       *\n");
    writer.write("*     Factura de compra de boletos de viaje             *\n");
    writer.write("*                                                       *\n");
    writer.write("*********************************************************\n");
    writer.write("\n\n");
    writer.write("*********************************************************\n");
    writer.write("*                                                       *\n");
    writer.write("*     Datos de la compra                                *\n");
    writer.write("*                                                       *\n");
    writer.write("*********************************************************");
    writer.write("\n\n");
    writer.write("*********************************************************\n");
    writer.write("*     Nombre: " + name + "\n");
    writer.write("*     Apellido: " + lastName + "\n");
    writer.write("*     ID: " + ID + "\n");
    writer.write("*     Edad: " + age + "\n");
    writer.write("*     Correo electrónico:" + email + "\n");
    writer.write("*     Telefono: " + phone + "\n");
    writer.write("*********************************************************");
    writer.close();
  }
}
