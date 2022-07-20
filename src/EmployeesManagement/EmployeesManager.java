package EmployeesManagement;

import java.util.Scanner;
import utils.*;

public class EmployeesManager {
  static Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.println("\n\nBienvenido al Sistema de Gestión de Empleados\n");

    EmployeeFileManager.fillEmployees();

    int option;
    boolean redoOption = true;

    do {
      System.out.println("\nElige una de estas opciones:\n");
      MenuType.showMenu("employees");
      option = UserInput.getUserOption(scan, new int[] { 1, 7 });

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
                "^[0-9]{3}-[A-Z]{3}", "Procura ingresar un UID válido en el formato: 111-AAA");

            if (!EmployeeFileManager.deleteEmployee(UID)) {
              System.out.print(Colors.ANSI_GREEN +
                  "\n¿Desea volver a intentarlo? (Si/No): " + Colors.ANSI_RESET);
              boolean answer = UserInput.getSNUserOption();

              if (!answer) {
                break;
              }
            } else {
              break;
            }
          } while (true);
          break;

        case 3:
          System.out.println("\n\n");
          String uid2 = UserInput.getUserParam("Ingrese el UID del empleado que desea modificar", "^[0-9]{3}-[A-Z]{3}",
              "Procura ingresar un UID válido en el formato: 111-AAA");

          System.out.println();

          MenuType.showMenu("modifyEmployee");

          int paramToModify = Integer
              .parseInt(UserInput.getUserParam("Ingresa tu opción", "^[1-6]", "Procura ingresar una opción válida"));

          EmployeeFileManager.modifyEmployee(uid2, paramToModify);
          break;

        case 4:
          EmployeeFileManager.printEmployees();
          break;

        case 5:
          System.out.println("\n\n");
          String uid3 = UserInput.getUserParam("Ingrese el UID del empleado que desea ver su información",
              "^[0-9]{3}-[A-Z]{3}",
              "Procura ingresar un UID válido en el formato: 111-AAA");

          EmployeeFileManager.showArbitraryEmployee(uid3);
          break;

        case 6:
          EmployeeFileManager.generateReportInCSV();
          break;

        case 7:
          System.out.println("\n¿Quiéres volver a intentar esta opción? (Si/No)\n");
          boolean answer = UserInput.getSNUserOption();

          if (!answer) {
            redoOption = false;
            System.out.println(Colors.ANSI_CYAN + "\n\n¡Hasta pronto! Opción realizada con <3 por Lenin\n\n"
                + Colors.ANSI_RESET);
          }
          break;
      }
    } while (redoOption);
  }

  /**
   * Gets the information of the employee to add
   * 
   * @return Employee - the employee to add
   */
  public static Employee getEmployeeInfo() {
    System.out.println(Colors.ANSI_CYAN + "\nIngresa los siguientes datos del empleado\n" + Colors.ANSI_RESET);

    String employeeName = UserInput.getUserParam("Ingresa el nombre", "^[A-Z]{1}[a-z|áéíóú]{1,15}",
        "Procura ingresa un nombre válido. Ejemplo: Juan");

    String employeeLastName = UserInput.getUserParam("Ingresa el apellido", "^[A-Z]{1}[a-z|áéíóú]{1,15}$",
        "Procura ingresa un apellido válido. Ejemplo: Pérez");

    int employeeAge;

    do {
      employeeAge = Integer
          .parseInt(
              UserInput.getUserParam("Ingresa la edad", "[0-9]{2}", "Procura ingresa una edad válida. Ejemplo: 20"));

      if (employeeAge < 18) {
        System.out.println(Colors.ANSI_RED + "\n-> La edad debe ser mayor a 18 años\n" + Colors.ANSI_RESET);
      } else
        break;
    } while (true);

    int employeeYearsOfExperience;

    do {
      employeeYearsOfExperience = Integer.parseInt(
          UserInput.getUserParam("Ingresa los años de experiencia", "[0-9]{1,2}",
              "Procura ingresa un valor válido"));

      if (employeeYearsOfExperience < 0) {
        System.out.println(Colors.ANSI_RED + "\n-> Recuerda ingresar datos que tengan sentido\n"
            + Colors.ANSI_RESET);
        continue;
      }

      if (employeeAge - employeeYearsOfExperience < 17) {
        System.out
            .println(Colors.ANSI_RED + "\n-> El empleado debería tener una edad y años de experiencia coherentes.\n"
                + Colors.ANSI_RESET);
        continue;
      }

      break;
    } while (true);

    String employeePhone = UserInput.getUserParam("Ingresa el teléfono", "^[0][0-9]{9}$",
        "Procura ingresar un teléfono válido");

    String employeeAddress = UserInput.getUserParam("Ingresa la dirección", "[a-zA-Z0-9\\s]{1,}",
        "Procura ingresa una dirección válida");

    String employeeDNI = UserInput.getUserParam("Ingresa el DNI", "[0-9]{10}", "Procura ingresa un DNI válido");

    Employee employee = new Employee(employeeName, employeeLastName, employeeAge, employeeYearsOfExperience,
        employeePhone, employeeAddress, employeeDNI);

    return employee;
  }
}
