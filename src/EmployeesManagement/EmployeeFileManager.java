package EmployeesManagement;

import java.util.ArrayList;

import utils.UserInput;
import java.io.*;
import utils.*;

public class EmployeeFileManager {
  public static final String FILE_NAME = "employees.txt";
  public static final File FILE = new File(FILE_NAME);
  public static FileWriter fw;
  public static PrintWriter pw;
  public static FileReader fr;
  public static BufferedReader br;
  public static ArrayList<Employee> employees = new ArrayList<Employee>();

  public EmployeeFileManager() {
    try {
      if (!FILE.exists()) {
        FILE.createNewFile();
        System.out.println("Archivo creado");
      } else {
        System.out.println("Archivo existente");
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void addEmployee(Employee employee) {
    employees.add(employee);
    System.out.println(Colors.ANSI_GREEN + "\n-> Empleado agregado correctamente\n" + Colors.ANSI_RESET);
  }

  public static boolean deleteEmployee(String UID) {
    for (Employee employee : employees) {
      if (employee.getUID().equals(UID)) {
        employees.remove(employee);
        System.out.println("Empleado eliminado correctamente");
        return true;
      }
    }

    System.out
        .println(Colors.ANSI_RED + "\n-> No se encontró el empleado con el UID: " + UID
            + Colors.ANSI_RESET);
    return false;
  }

  public static void modifyEmployee(String UID, String paramToModify) {
    for (Employee employee : employees) {
      if (employee.getUID() == UID) {
        switch (paramToModify) {
          case "nombre":
            employee.setEmployeeName(
                UserInput.getUserParam("Ingresa el nombre", "^[A-Z]{1}[a-z]{2,}$", "Procura ingresa un nombre válido"));
            break;

          case "apellido":
            employee.setLastEmployeeName(UserInput.getUserParam("Ingresa el apellido", "^[A-Z]{1}[a-z]{2,}$",
                "Procura ingresa un apellido válido"));
            break;

          case "edad":
            employee.setEmployeeAge(
                Integer.parseInt(
                    UserInput.getUserParam("Ingresa la edad", "[0-9]{2}", "Procura ingresa una edad válida")));
            break;

          case "años de experiencia":
            employee
                .setYearsOfExperience(Integer.parseInt(
                    UserInput.getUserParam("Ingresa los años de experiencia", "[0-9]{1,2}*",
                        "Procura ingresa un valor válido")));
            break;

          case "teléfono":
            employee.setEmployeePhone(
                UserInput.getUserParam("Ingresa el teléfono", "^[0-9]{10}$", "Procura ingresa un teléfono válido"));
            break;

          case "dirección":
            employee.setEmployeeAddress(
                UserInput.getUserParam("Ingresa la dirección", "[a-zA-Z0-9\\s]",
                    "Procura ingresa una dirección válida"));
            break;

          case "dni":
            employee
                .setEmployeeDNI(UserInput.getUserParam("Ingresa el DNI", "[0-9]{10}", "Procura ingresa un DNI válido"));
            break;
        }
      }
    }
  }

  public static void generateReportInCSV() {
    if (employees.size() == 0) {
      System.out.println("No hay empleados para generar el reporte");
    } else {
      try {
        fw = new FileWriter(FILE);
        pw = new PrintWriter(fw);

        String line;

        for (Employee employee : employees) {
          line = employee.toString();
          pw.println(line);
        }

        pw.close();
        fw.close();
      } catch (IOException e) {
        System.out.println("Error al leer el archivo " + FILE_NAME);
      }
    }
  }
}
