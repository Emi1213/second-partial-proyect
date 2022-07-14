package utils;

import java.util.Scanner;

public class UserInput {
  /**
   * Shows the menu to the user depending on the type of menu
   * 
   * @param menuType the type of menu to show
   * @return void
   */

  public static void showMenu(String menuType) {
    switch (menuType) {
      case "main":
        System.out.println("\t1. Tickets Selling");
        System.out.println("\t2. Files Management");
        System.out.println("\t3. Tercera opción");
        System.out.println("\t4. Salir");
        System.out.print("\n\t-> ");
        break;

      case "employees":
        System.out.println("\t1. Añadir un nuevo empleado");
        System.out.println("\t2. Eliminar un empleado");
        System.out.println("\t3. Modificar la información de un empleado");
        System.out.println("\t4. Salir");
        System.out.print("\n\t-> ");
        break;
    }
  }

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
