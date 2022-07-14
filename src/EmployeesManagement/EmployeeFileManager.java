package EmployeesManagement;

import java.util.ArrayList;

import utils.UserInput;

import java.io.*;

public class EmployeeFileManager {
  public static final String FILE_NAME = "employees.txt";
  public static final File FILE = new File(FILE_NAME);
  public static FileWriter fw;
  public static PrintWriter pw;
  public static FileReader fr;
  public static BufferedReader br;
  private static ArrayList<Employee> employees = new ArrayList<Employee>();

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
    System.out.println("Empleado agregado correctamente");
  }

  public static void deleteEmployee(String UID) {
    for (Employee employee : employees) {
      if (employee.getUID().equals(UID)) {
        employees.remove(employee);
        System.out.println("Empleado eliminado correctamente");
        break;
      }
    }
  }

  public static void modifyEmployee(String UID, String paramToModify) {
    for (Employee employee : employees) {
      if (employee.getUID() == UID) {
        switch (paramToModify) {
          case "nombre":
            employee.setEmployeeName(UserInput.getUserParam("nombre", "^[A-Z]{1}[a-z]{2,}$"));
            break;
          case "apellido":
            employee.setLastEmployeeName(UserInput.getUserParam("apellido", "^[A-Z]{1}[a-z]{2,}$"));
            break;
          case "edad":
            employee.setEmployeeAge(Integer.parseInt(UserInput.getUserParam("edad", "[0-9]{2}*")));
            break;
          case "años de experiencia":
            employee
                .setYearsOfExperience(Integer.parseInt(UserInput.getUserParam("años de experiencia", "[0-9]{1-2}*")));
            break;
          case "teléfono":
            employee.setEmployeePhone(UserInput.getUserParam("telefono", "^[0-9]{10}$"));
            break;
          case "dirección":
            employee.setEmployeeAddress(UserInput.getUserParam("dirección", "[a-zA-Z0-9\s]*"));
            break;
          case "DNI":
            employee.setEmployeeDNI(UserInput.getUserParam("DNI", "[0-9]{10}*"));
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
