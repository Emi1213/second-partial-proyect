package EmployeesManagement;

import java.util.Scanner;
import utils.UserInput;

public class EmployeesManagement {
  static Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.println("\n\nBienvenido al Sistema de Gestión de Empleados\n\n");
    System.out.println("Puedes elegir entre varias opciones:\n");

    int option;

    do {
      UserInput.showMenu("employees");
      option = UserInput.getUserOption(scan);

      switch (option) {
        case 1:
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
