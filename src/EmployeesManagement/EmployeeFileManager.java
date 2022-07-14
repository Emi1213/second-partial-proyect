package EmployeesManagement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class EmployeeFileManager {
  public static final String FILE_NAME = "employees.txt";
  public static final String DELIMITER = ";";
  public static final String NEW_LINE = "\n";
  public FileWriter fw;
  public PrintWriter pw;
  public FileReader fr;
  public BufferedReader br;
  // private ArrayList<Employee> employees = new ArrayList<Employee>();

  public EmployeeFileManager() {
    try {
      fw = new FileWriter(FILE_NAME, true);
      pw = new PrintWriter(fw);
      fr = new FileReader(FILE_NAME);
      br = new BufferedReader(fr);
    } catch (IOException e) {
      System.out.println("Error al crear el archivo " + FILE_NAME);
    }
  }

  public void addEmployee(Employee employee) {
    pw.println(employee.toString());
    pw.flush();
  }
}
