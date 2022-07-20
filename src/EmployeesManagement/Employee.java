package EmployeesManagement;

public class Employee {
  private String employeeName;
  private String lastEmployeeName;
  private String UID;
  private String employeeEmail;
  private String employeePhone;
  private String employeeAddress;
  private String employeeLevel;
  private String employeeDNI;
  private int yearsOfExperience;
  private int employeeAge;

  /**
   * Constructor of the class
   * 
   * @param employeeName
   * @param lastEmployeeName
   * @param employeeAge
   * @param yearsOfExperience
   * @param employeeDNI
   * @param employeePhone
   * @param employeeAddress
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
    this.employeeLevel = generateEmployeeLevel(yearsOfExperience);
    this.employeeEmail = generateEmail(employeeName, lastEmployeeName);
    this.UID = generateUID();
  }

  public Employee(String employeeName, String lastEmployeeName, String employeeAge, String yearsOfExperience,
      String UID, String employeeEmail, String employeePhone, String employeeAddress, String employeeLevel,
      String employeeDNI) {
    this.employeeName = employeeName;
    this.lastEmployeeName = lastEmployeeName;
    this.employeeAge = Integer.parseInt(employeeAge);
    this.yearsOfExperience = Integer.parseInt(yearsOfExperience);
    this.employeePhone = employeePhone;
    this.employeeAddress = employeeAddress;
    this.employeeDNI = employeeDNI;
    this.employeeLevel = employeeLevel;
    this.employeeEmail = employeeEmail;
    this.UID = UID;
  }

  /**
   * Generates the current employee level
   * 
   * @param yearsOfExperience
   * @return String (Junior, Mid-level, Senior)
   */
  public String generateEmployeeLevel(int yearsOfExperience) {
    return yearsOfExperience < 5 ? "Junior" : yearsOfExperience >= 5 && yearsOfExperience < 10 ? "Mid-level" : "Senior";
  }

  /**
   * Generates a random email for the employee
   * 
   * @return String employeeEmail
   */
  public String generateEmail(String employeeName, String lastEmployeeName) {
    return String.valueOf(employeeName.charAt(0)).toLowerCase() + lastEmployeeName.toLowerCase()
        + "@wifland.com";
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

  /**
   * Prints the employee information
   * 
   * @return String
   */
  public String toString() {
    return "Nombre: " + employeeName + "\nApellido: " + lastEmployeeName + "\nEdad: " + employeeAge
        + "\nAños de experiencia: " + yearsOfExperience + "\nDNI: " + employeeDNI + "\nTeléfono: "
        + employeePhone + "\nDirección: " + employeeAddress + "\nNivel: " + employeeLevel + "\nEmail: "
        + employeeEmail + "\nUID: " + UID;
  }

  public String toString(boolean oneLine) {
    return employeeName + ";" + lastEmployeeName + ";" + employeeAge + ";" + yearsOfExperience + ";" + UID + ";"
        + employeeEmail + ";" + employeePhone + ";" + employeeAddress + ";" + employeeLevel + ";" + employeeDNI;
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

  public String getEmployeePhone() {
    return employeePhone;
  }

  public String getEmployeeAddress() {
    return employeeAddress;
  }

  public String getEmployeeLevel() {
    return employeeLevel;
  }

  public String getEmployeeDNI() {
    return employeeDNI;
  }

  // Setters
  public void setEmployeeName(String employeeName) {
    this.employeeName = employeeName;
    this.employeeEmail = generateEmail(employeeName, lastEmployeeName);
  }

  public void setLastEmployeeName(String lastEmployeeName) {
    this.lastEmployeeName = lastEmployeeName;
    this.employeeEmail = generateEmail(employeeName, lastEmployeeName);
  }

  public void setEmployeeAge(int employeeAge) {
    this.employeeAge = employeeAge;
  }

  /**
   * Sets the years of experience of the employee and updates the
   * employee level
   * 
   * @param yearsOfExperience years of experience of the employee
   * @return {void}
   */
  public void setYearsOfExperience(int yearsOfExperience) {
    this.yearsOfExperience = yearsOfExperience;

    if (yearsOfExperience < 5) {
      this.employeeLevel = "Junior";
    } else if (yearsOfExperience >= 5 && yearsOfExperience < 10) {
      this.employeeLevel = "Mid-level";
    } else {
      this.employeeLevel = "Senior";
    }
  }

  public void setEmployeeEmail(String employeeEmail) {
    this.employeeEmail = employeeEmail;
  }

  public void setEmployeePhone(String employeePhone) {
    this.employeePhone = employeePhone;
  }

  public void setEmployeeAddress(String employeeAddress) {
    this.employeeAddress = employeeAddress;
  }

  public void setEmployeeDNI(String employeeDNI) {
    this.employeeDNI = employeeDNI;
  }
}
