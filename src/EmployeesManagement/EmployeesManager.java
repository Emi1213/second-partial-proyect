package EmployeesManagement;

import java.util.Scanner;

import utils.MenuType;
import utils.UserInput;

public class EmployeesManager {
  static Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.println("\n\nBienvenido al Sistema de Gestión de Empleados\n\n");
    System.out.println("Puedes elegir entre varias opciones:\n");

    int option;

    do {
      MenuType.showMenu("employees");
      option = UserInput.getUserOption(scan);

      // TODO: Crear una forma de pedir el UID

      switch (option) {
        case 1:
          EmployeeFileManager.addEmployee(getEmployeeInfo());
          break;

        case 2:
          scan.nextLine();
          System.out.println("\n\n");
          System.out.print("Ingrese el UID del empleado que desea eliminar: ");
          String uid = scan.nextLine();
          EmployeeFileManager.deleteEmployee(uid);
          break;

        case 3:
          scan.nextLine();
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

        default:
          System.out.println("\nEsa opción no existe, intenta de nuevo\n");
          break;
      }

    } while (option != 5);
  }

  public static Employee getEmployeeInfo() {
    String employeeName = UserInput.getUserParam("nombre", "^[A-Z]{1}[a-z]{2,}$");
    String employeeLastName = UserInput.getUserParam("apellido", "^[A-Z]{1}[a-z]{2,}$");
    int employeeAge = Integer.parseInt(UserInput.getUserParam("edad", "[0-9]{2}"));
    int employeeYearsOfExperience = Integer.parseInt(UserInput.getUserParam("años de experiencia", "[0-9]{1,2}"));
    String employeePhone = UserInput.getUserParam("telefono", "^[0-9]{10}$");
    String employeeAddress = UserInput.getUserParam("dirección", "[a-zA-Z0-9\\s]*");
    String employeeDNI = UserInput.getUserParam("DNI", "[0-9]{10}");

    Employee employee = new Employee(employeeName, employeeLastName, employeeAge, employeeYearsOfExperience,
        employeePhone, employeeAddress, employeeDNI);

    return employee;
  }
}
