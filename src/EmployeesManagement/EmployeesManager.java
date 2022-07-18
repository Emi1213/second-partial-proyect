package EmployeesManagement;

import java.util.Scanner;
import utils.*;

public class EmployeesManager {
  static Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.println("\n\nBienvenido al Sistema de Gestión de Empleados\n");

    int option;

    do {
      System.out.println("\nElige una de estas opciones:\n");
      MenuType.showMenu("employees");
      option = UserInput.getUserOption(scan, new int[] { 1, 5 });

      switch (option) {
        case 1:
          EmployeeFileManager.addEmployee(getEmployeeInfo());
          break;

        case 2:
          if (EmployeeFileManager.employees.isEmpty()) {
            System.out.println(Colors.ANSI_RED + "\n-> No hay empleados para eliminar\n" + Colors.ANSI_RESET);
            break;
          }

          do {
            String UID = UserInput.getUserParam("\nIngrese el UID del empleado que desea eliminar",
                "^[a-zA-z0-9\\s]{1,}$", "Procura ingresar un UID válido");

            if (!EmployeeFileManager.deleteEmployee(UID)) {
              System.out.print(Colors.ANSI_GREEN +
                  "\n¿Desea volver a intentarlo? (Si/No): " + Colors.ANSI_RESET);
              String answer = scan.nextLine();

              if (answer.equalsIgnoreCase("No")) {
                break;
              }

            } else {
              break;
            }
          } while (true);
          break;

        case 3:
          System.out.println("\n\n");
          System.out.print("Ingrese el UID del empleado que desea modificar: ");
          String uid2 = scan.nextLine();
          System.out.println("\n");

          MenuType.showMenu("modifyEmployee");
          String paramToModify = scan.nextLine();

          EmployeeFileManager.modifyEmployee(uid2, paramToModify.toLowerCase().trim());
          break;

        case 4:
          EmployeeFileManager.generateReportInCSV();
          break;

        case 5:
          System.out.println("\nEs un gusto tenerte en nuestra aplicación, hasta pronto!\n");
          break;
      }

    } while (option != 5);
  }

  public static Employee getEmployeeInfo() {
    System.out.println("\n\nPara agregar un nuevo empleado, ingrese los siguientes datos:\n");

    String employeeName = UserInput.getUserParam("Ingresa el nombre", "^[A-Z]{1}[a-z]{2,}$",
        "Procura ingresa un nombre válido");

    String employeeLastName = UserInput.getUserParam("Ingresa el apellido", "^[A-Z]{1}[a-z]{2,}$",
        "Procura ingresa un apellido válido");

    int employeeAge = Integer
        .parseInt(UserInput.getUserParam("Ingresa la edad", "[0-9]{2}", "Procura ingresa una edad válida"));

    int employeeYearsOfExperience = Integer.parseInt(
        UserInput.getUserParam("Ingresa los años de experiencia", "[0-9]{1,2}",
            "Procura ingresa un valor válido"));

    String employeePhone = UserInput.getUserParam("Ingresa el teléfono", "^[0-9]{10}$",
        "Procura ingresa un teléfono válido");

    String employeeAddress = UserInput.getUserParam("Ingresa la dirección", "[a-zA-Z0-9\\s]{1,}",
        "Procura ingresa una dirección válida");

    String employeeDNI = UserInput.getUserParam("Ingresa el DNI", "[0-9]{10}", "Procura ingresa un DNI válido");

    Employee employee = new Employee(employeeName, employeeLastName, employeeAge, employeeYearsOfExperience,
        employeePhone, employeeAddress, employeeDNI);

    return employee;
  }

  public static void getUserInput() {
    scan.nextLine();
    System.out.print("\nIngrese una opción: ");
  }
}
