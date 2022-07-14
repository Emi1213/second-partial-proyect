package utils;

public class MenuType {
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
        System.out.println("\t4. Generar reporte de empleados en formato CSV");
        System.out.println("\t5. Salir");
        System.out.print("\n\t-> ");
        break;
    }
  }
}
