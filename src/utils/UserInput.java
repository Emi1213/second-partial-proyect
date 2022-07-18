package utils;

import java.util.Scanner;

public class UserInput {

  /**
   * Gets the user option
   * 
   * @param scan Scanner to get the user option
   * @return The user option
   * 
   */
  public static int getUserOption(Scanner scan, int[] range) {
    int option = 0;

    try {
      System.out.print("\n\t-> ");
      option = Integer.valueOf(scan.nextLine().replaceAll("\\D*", ""));

      if (option < range[0] || option > range[1]) {
        throw new Exception();
      }
    } catch (Exception e) {
      System.out.println(Colors.ANSI_RED + "\n\t-> Opción inválida, vuelve a intentar\n" + Colors.ANSI_RESET);
    }

    return option;
  }

  /**
   * 
   * @param customMessage      Custom message to show to the user
   * @param regexParam         Regex to validate the user param
   * @param customErrorMessage Custom error message to show to the user
   * @return The validated user param
   */
  public static String getUserParam(String customMessage, String regexParam, String customErrorMessage) {
    do {
      try {
        System.out.print(customMessage + ": ");
        String currentParam = System.console().readLine().trim();

        if (currentParam.matches(regexParam)) {
          return currentParam;
        } else {
          System.out.println(Colors.ANSI_RED + "-> " + customErrorMessage + Colors.ANSI_RESET);
          continue;
        }
      } catch (Exception e) {
        System.out.println("\n\nProcura no cometer errores al ingresar los datos");
      }
    } while (true);
  }

}
