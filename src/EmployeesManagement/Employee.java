package EmployeesManagement;

public class Employee {
  private String employeeName;
  private String lastEmployeeName;
  private int employeeAge;
  private int yearsOfExperience;
  private String UID;
  private String employeeEmail;
  private String employeePhone;
  private String employeeAddress;
  private String employeeLevel;
  private String employeeDNI;

  /**
   * Constructor of the class
   * 
   * @param employeeName
   * @param lastEmployeeName
   * @param employeeAge
   * @param yearsOfExperience
   */
  public Employee(String employeeName, String lastEmployeeName, int employeeAge, int yearsOfExperience,
      String employeePhone, String employeeAddress, String employeeDNI) {
    this.employeeName = employeeName;
    this.lastEmployeeName = lastEmployeeName;
    this.employeeAge = employeeAge;
    this.yearsOfExperience = yearsOfExperience;
    this.employeePhone = employeePhone;
    this.employeeAddress = employeeAddress;
    this.employeeDNI = employeeDNI;
    UID = generateUID();
    employeeEmail = generateEmail();
  }

  /**
   * Generates a unique ID for the employee
   * 
   * @return String UID
   */
  public String generateUID() {
    return String.format("%03d-", (int) (Math.random() * 1000)) + generateLetters();
  }

  /**
   * Generates a random email for the employee
   * 
   * @return String employeeEmail
   */
  public String generateEmail() {
    return String.valueOf(employeeName.charAt(0)).toLowerCase() + lastEmployeeName.toLowerCase()
        + "@wifland.com";
  }

  /**
   * Generates a random string of letters
   * 
   * @return String letters
   */
  public static String generateLetters() {
    String letters = "";

    for (int i = 0; i < 3; i++) {
      letters += (char) (Math.random() * 26 + 'a');
    }

    return letters.toUpperCase();
  }

  // Getters
  public String getEmployeeName() {
    return employeeName;
  }

  public String getLastEmployeeName() {
    return lastEmployeeName;
  }

  public int getEmployeeAge() {
    return employeeAge;
  }

  public int getYearsOfExperience() {
    return yearsOfExperience;
  }

  public String getUID() {
    return UID;
  }

  public String getEmployeeEmail() {
    return employeeEmail;
  }

  // Setters
  public void setEmployeeName(String employeeName) {
    this.employeeName = employeeName;
  }

  public void setLastEmployeeName(String lastEmployeeName) {
    this.lastEmployeeName = lastEmployeeName;
  }

  public void setEmployeeAge(int employeeAge) {
    this.employeeAge = employeeAge;
  }

  public void setYearsOfExperience(int yearsOfExperience) {
    this.yearsOfExperience = yearsOfExperience;
  }

  public void setUID(String UID) {
    this.UID = UID;
  }

  public void setEmployeeEmail(String employeeEmail) {
    this.employeeEmail = employeeEmail;
  }
}
