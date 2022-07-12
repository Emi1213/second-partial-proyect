package EmployeesManagement;

public class EmployeesManagement {
  public static void main(String[] args) {
    Employee employee1 = new Employee("Emilia", "Galarza", 25, 5, "12345678", "Calle falsa 123", "1234567890");

    System.out.println(employee1.getUID());
    System.out.println(employee1.getEmployeeEmail());
    System.out.println(employee1.getEmployeeName());
    System.out.println(employee1.getLastEmployeeName());
    System.out.println(employee1.getEmployeeAge());
    System.out.println(employee1.getYearsOfExperience());

  }
}