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
}
