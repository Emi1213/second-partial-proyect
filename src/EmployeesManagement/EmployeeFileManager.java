package EmployeesManagement;

import java.util.ArrayList;
import utils.UserInput;
import java.io.*;
import utils.*;

/**
 * @author Lenin Mazabanda
 * @version 1.0
 */
public class EmployeeFileManager {
  public static final String FILE_NAME = "employees.txt";
  public static final File FILE = new File(FILE_NAME);
  public static FileWriter fw;
  public static PrintWriter pw;
  public static FileReader fr;
  public static BufferedReader br;
  public static ArrayList<Employee> employees = new ArrayList<Employee>();

  /**
   * @description Initializes the arraylist of employees with the employees from
   *              the file
   * @return boolean True if the file was loaded correctly, false otherwise
   */
  public static boolean fillEmployees() {
    if (FILE.exists()) {
      try {
        fr = new FileReader(FILE);
        br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
          String[] data = line.split(";");

          employees.add(
              new Employee(
                  data[0],
                  data[1],
                  data[2],
                  data[3],
                  data[4],
                  data[5],
                  data[6],
                  data[7],
                  data[8],
                  data[9]));
        }

        return true;
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    return false;
  }

  /**
   * @description Print all the employees in the arraylist on the screen
   */
  public static void printEmployees() {
    for (Employee employee : employees) {
      System.out.println("\n" + Colors.ANSI_CYAN + employee.toString() + Colors.ANSI_RESET + "\n");
    }
  }

  /**
   * @description Adds a new employee to the arraylist of employees
   * @param employee Employee to be added to the arraylist
   */
  public static void addEmployee(Employee employee) {
    employees.add(employee);
    System.out.println(Colors.ANSI_GREEN + "\n-> Empleado agregado correctamente\n" + Colors.ANSI_RESET);
  }

  /**
   * @description Deletes an employee from the arraylist of employees with an UID
   * @param UID UID of the employee to be deleted
   * @return boolean True if the employee was deleted, false otherwise
   */
  public static boolean deleteEmployee(String UID) {
    for (Employee employee : employees) {
      if (employee.getUID().equals(UID)) {
        employees.remove(employee);
        System.out.println(Colors.ANSI_GREEN + "\n-> Empleado eliminado correctamente\n" + Colors.ANSI_RESET);
        return true;
      }
    }

    System.out
        .println(Colors.ANSI_RED + "\n-> No se encontró el empleado con el UID: " + UID
            + Colors.ANSI_RESET);
    return false;
  }

  /**
   * @description Updates an employee from the arraylist of employees with an UID
   * @param UID           UID of the employee to be updated
   * @param paramToModify Parameter to be modified
   */
  public static void modifyEmployee(String UID, int paramToModify) {
    for (Employee employee : employees) {
      if (employee.getUID().equals(UID)) {
        switch (paramToModify) {
          case 1:
            employee.setEmployeeName(
                UserInput.getUserParam("Ingresa el nombre", "^[A-Z]{1}[a-z]{2,}$", "Procura ingresa un nombre válido"));
            break;

          case 2:
            employee.setLastEmployeeName(UserInput.getUserParam("Ingresa el apellido", "^[A-Z]{1}[a-z]{2,}$",
                "Procura ingresa un apellido válido"));
            break;

          case 3:
            employee.setEmployeePhone(
                UserInput.getUserParam("Ingresa el teléfono", "^[0-9]{10}$", "Procura ingresa un teléfono válido"));
            break;

          case 4:
            employee.setEmployeeAddress(
                UserInput.getUserParam("Ingresa la dirección", "[a-zA-Z0-9\\s]",
                    "Procura ingresa una dirección válida"));
            break;

          case 5:
            employee
                .setEmployeeDNI(UserInput.getUserParam("Ingresa el DNI", "[0-9]{10}", "Procura ingresa un DNI válido"));
            break;

          default:
            System.out.println(Colors.ANSI_RED + "\n-> No se encontró el parámetro a modificar\n"
                + Colors.ANSI_RESET);
            break;
        }
      }
    }

    System.out.println(Colors.ANSI_GREEN + "\n-> Empleado modificado correctamente\n" + Colors.ANSI_RESET);
    System.out.println("La nueva información del empleado es: \n");
    showArbitraryEmployee(UID);
  }

  /**
   * @description Generates a file with the employees in the arraylist
   */
  public static void generateReportInCSV() {
    if (employees.size() == 0) {
      System.out.println(Colors.ANSI_RED + "\n-> No hay empleados para generar el reporte\n"
          + Colors.ANSI_RESET);
    } else {
      try {
        fw = new FileWriter(FILE);
        pw = new PrintWriter(fw);

        String line;

        for (Employee employee : employees) {
          line = employee.toString(true);
          pw.println(line);
        }

        pw.close();
        fw.close();

        System.out.println(Colors.ANSI_GREEN + "\n-> Reporte generado correctamente\n" + Colors.ANSI_RESET);
      } catch (IOException e) {
        System.out.println(Colors.ANSI_RED + "Error al leer el archivo " + FILE_NAME + Colors.ANSI_RESET);
      }
    }
  }

  /**
   * @description Shows an employee from the arraylist of employees with an UID
   * @param UID UID of the employee to be shown
   */
  public static void showArbitraryEmployee(String UID) {
    for (Employee employee : employees) {
      if (employee.getUID().equals(UID)) {
        System.out.println("\n" + Colors.ANSI_CYAN + employee.toString() + Colors.ANSI_RESET + "\n");
        return;
      }
    }
  }

}
