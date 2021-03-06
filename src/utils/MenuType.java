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
        System.out.println("\t4. Ver la lista de empleados");
        System.out.println("\t5. Ver la información de un empleado arbitrario");
        System.out.println("\t6. Generar reporte de empleados en formato CSV");
        System.out.println("\t7. Salir");
        break;

      case "modifyEmployee":
        System.out.println("\t¿Qué desea modificar?");
        System.out.println("\t1. Nombre");
        System.out.println("\t2. Apellido");
        System.out.println("\t3. Teléfono");
        System.out.println("\t4. Dirección");
        System.out.println("\t5. DNI");
        System.out.println("\t6. Cancelar");
        break;
    }
  }
}
