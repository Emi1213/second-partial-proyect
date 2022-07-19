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
   * Gets the user option
   * 
   * @return {int} The user option
   */
  public static int getUserOption() {
    try {
      return Integer.valueOf(System.console().readLine().trim().replaceAll("\\D*", ""));
    } catch (Exception e) {
      System.out.println("\n\nProcura no cometer errores al ingresar la opción.");
      System.out.println("Debes ingresar un número de opción correcto\n\n");
      return 0;
    }
  }

  /**
   * @description Gets the s/n user option whit validation
   * 
   * @return boolean The user option
   */
  public static boolean getSNUserOption() {
    boolean isValidOption = true;
    String userSNOption = "";
    boolean userOption = true;

    do {
      try {
        userSNOption = System.console().readLine().replaceAll("\\d*", "").toLowerCase();

        if (userSNOption.equals("s") || userSNOption.equals("n") || userSNOption.equals("si")
            || userSNOption.equals("no")) {
          isValidOption = true;

          if (userSNOption.equals("s") || userSNOption.equals("si")) {
            userOption = true;
          } else {
            userOption = false;
          }
        } else {
          System.out.println("\n\nProcura no cometer errores al ingresar la opción.");
          System.out.println("Debes ingresar una opción válida\n\n");
          isValidOption = false;
        }
      } catch (Exception e) {
        System.out.println("\n\nProcura no cometer errores al ingresar la opción.");
        System.out.println("Debes ingresar una opción correcta\n\n");
        isValidOption = false;
      }

    } while (!isValidOption);

    return userOption;

  }

  /**
   * @description Gets the user param (name, last name, ID, email, etc)
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
