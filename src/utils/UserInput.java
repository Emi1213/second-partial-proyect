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
      System.out.println(Colors.ANSI_RED + "\n\t-> Opción inválida, vuelve a intentar\n" + Colors.ANSI_RESET);
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
          System.out.println(Colors.ANSI_RED
              + "\n\t-> Opción inválida, vuelve a intentar. Recuerda que puedes ingresar s-Si-n-No y todas sus variantes\n"
              + Colors.ANSI_RESET);
          isValidOption = false;
        }
      } catch (Exception e) {
        System.out.println(Colors.ANSI_RED + "\n\t-> Opción inválida, vuelve a intentar\n" + Colors.ANSI_RESET);
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
          System.out.println(Colors.ANSI_RED + "\n-> " + customErrorMessage + Colors.ANSI_RESET);
          continue;
        }
      } catch (Exception e) {
        System.out
            .println(Colors.ANSI_RED + "\n-> Procura no cometer errores al ingresar los datos" + Colors.ANSI_RESET);
      }
    } while (true);
  }

}
