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
        System.out.println("\t1. Manejo de Ficheros");
        System.out.println("\t2. Venta de Tickets");
        System.out.println("\t3. Administración de Empleados");
        System.out.println("\t4. Salir");
        break;

      case "employees":
        System.out.println("\t1. Añadir un nuevo empleado");
        System.out.println("\t2. Eliminar un empleado");
        System.out.println("\t3. Modificar la información de un empleado");
        System.out.println("\t4. Generar reporte de empleados en formato CSV");
        System.out.println("\t5. Salir");
        break;

      case "modifyEmployee":
        System.out.println("\t¿Qué desea modificar?");
        System.out.println("\t1. Nombre");
        System.out.println("\t2. Apellido");
        System.out.println("\t3. Edad");
        System.out.println("\t4. Años de experiencia");
        System.out.println("\t5. Teléfono");
        System.out.println("\t6. Dirección");
        System.out.println("\t7. DNI");
        System.out.println("\t8. Cancelar");
        break;
    }
  }
}
