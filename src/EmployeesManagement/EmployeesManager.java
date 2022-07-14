package EmployeesManagement;

import java.util.Scanner;

import utils.MenuType;
import utils.UserInput;

public class EmployeesManager {
  static Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.println("\n\nBienvenido al Sistema de Gestión de Empleados\n\n");
    System.out.println("Puedes elegir entre varias opciones:\n");
    EmployeeFileManager employeeFileManager = new EmployeeFileManager();

    int option;

    do {
      MenuType.showMenu("employees");
      option = UserInput.getUserOption(scan);

      switch (option) {
        case 1:
          String employeeName = UserInput.getUserParam("nombre", "[a-zA-Z]*");
          String employeeLastName = UserInput.getUserParam("apellido", "[a-zA-Z]*");
          int employeeAge = Integer.parseInt(UserInput.getUserParam("edad", "[0-9]*"));
          int employeeYearsOfExperience = Integer.parseInt(UserInput.getUserParam("años de experiencia", "[0-9]*"));
          String employeePhone = UserInput.getUserParam("telefono", "[0-9]*");
          String employeeAddress = UserInput.getUserParam("dirección", "[a-zA-Z0-9]*");
          String employeeDNI = UserInput.getUserParam("DNI", "[0-9]*");

          Employee employee = new Employee(employeeName, employeeLastName, employeeAge, employeeYearsOfExperience,
              employeePhone, employeeAddress, employeeDNI);

          employeeFileManager.addEmployee(employee);
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
