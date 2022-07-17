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
        userSNOption = System.console().readLine().replaceAll("\\D*", "").toLowerCase();

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
   * @param scan
   * @param param      //String to get the user param
   * @param regexParam //String to validate the user param
   * @return currentParam //String with the user param
   */
  public static String getUserParam(String param, String regexParam) {
    do {
      try {
        System.out.print("Ingrese su " + param + ": ");
        String currentParam = System.console().readLine().trim();

        if (currentParam.matches(regexParam)) {
          return currentParam;
        } else {
          System.out.println("Parametro inválido, intente de nuevo");
          continue;
        }
      } catch (Exception e) {
        System.out.println("\n\nProcura no cometer errores al ingresar los datos");
      }
    } while (true);
  }

}
