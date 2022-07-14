package utils;

import java.util.Scanner;

public class UserInput {

  /**
   * Gets the user option
   * 
   * @param scan Scanner to get the user option
   * @return {int} The user option
   */
  public static int getUserOption(Scanner scan) {
    try {
      return Integer.valueOf(scan.next().replaceAll("\\D*", ""));
    } catch (Exception e) {
      System.out.println("\n\nProcura no cometer errores al ingresar la opción.");
      System.out.println("Debes ingresar un número de opción correcto\n\n");
      scan.nextLine();
      return 0;
    }
  }

  /**
   * Gets the user param (name, last name, ID, email, etc)
   * 
   * @param scan
   * @param param      //String to get the user param
   * @param regexParam //String to validate the user param
   * @return currentParam //String with the user param
   * 
   */
  public static String getUserParam(Scanner scan, String param, String regexParam) {
    do {
      System.out.println("Ingrese su " + param + ": ");
      String currentParam = System.console().readLine().trim();

      if (currentParam.matches(regexParam)) {
        return currentParam;
      } else {
        System.out.println("Parametro inválido, intente de nuevo");
        continue;
      }

    } while (true);
  }

}
