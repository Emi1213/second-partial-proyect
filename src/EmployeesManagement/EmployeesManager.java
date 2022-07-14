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

      switch (option) {
        case 1:
          String employeeName = UserInput.getUserParam(scan, "nombre", "[a-zA-Z]*");
          String employeeLastName = UserInput.getUserParam(scan, "apellido", "[a-zA-Z]*");
          String employeeID = UserInput.getUserParam(scan, "ID", "[0-9]*");
          // addEmployee();
          break;
        case 2:
          // deleteEmployee();
          break;
        case 3:
          // modifyEmployee();
          break;
        case 4:
          System.out.println("\nEs un gusto tenerte en nuestra aplicación, hasta pronto!\n");
          break;
        default:
          System.out.println("\nEsa opción no existe, intenta de nuevo\n");
          break;
      }

    } while (option != 4);
  }
}
