package TicketsSelling;

public class Credentials {

  public void getCredentials() {

    String name = "";
    String lastname = "";
    String ID = "";
    String age = "";
    String cellphone = "";
    String email = "";

    String regexname = "^[A-Z]{1}[a-z]{1,}$";
    String regexlastname = "^[A-Z]{1}[a-z]{1,}$";
    String regexID = "^[0-9]{10}$";
    String regexage = "^[0-9]{1,2}$";
    String regexcellphone = "^[0-9]{10}$";
    String regexemail = "^[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,4}$";

    boolean valid = false;
    String arrayCredentials[] = new String[6];

    for (int i = 0; i < arrayCredentials.length; i++) {
      switch (i) {
        case 0:
          do {
            System.out.println("Ingrese su nombre: ");
            name = System.console().readLine().trim();
            if (name.matches(regexname)) {
              arrayCredentials[i] = name;
              valid = true;
            } else {
              System.out.println("Nombre inválido, intente de nuevo");
              valid = false;
            }
          } while (!valid);
          break;
        case 1:
          do {
            System.out.println("Ingrese su apellido: ");
            lastname = System.console().readLine().trim();
            if (lastname.matches(regexlastname)) {
              arrayCredentials[i] = lastname;
              valid = true;
            } else {
              System.out.println("Apellido inválido, intente de nuevo");
              valid = false;
            }
          } while (!valid);
          break;
        case 2:
          do {
            System.out.println("Ingrese su ID: ");
            ID = System.console().readLine().trim();
            if (ID.matches(regexID)) {
              arrayCredentials[i] = ID;
              valid = true;
            } else {
              System.out.println("ID inválido, intente de nuevo");
              valid = false;
            }
          } while (!valid);
          break;
        case 3:
          do {
            System.out.println("Ingrese su edad: ");
            age = System.console().readLine().trim();
            if (age.matches(regexage)) {
              arrayCredentials[i] = age;
              valid = true;
            } else {
              System.out.println("Edad inválida, intente de nuevo");
              valid = false;
            }
          } while (!valid);
          break;
        case 4:
          do {
            System.out.println("Ingrese su celular: ");
            cellphone = System.console().readLine().trim();
            if (cellphone.matches(regexcellphone)) {
              arrayCredentials[i] = cellphone;
              valid = true;
            } else {
              System.out.println("Celular inválido, intente de nuevo");
              valid = false;
            }
          } while (!valid);
          break;
        case 5:
          do {
            System.out.println("Ingrese su email: ");
            email = System.console().readLine().trim();
            if (email.matches(regexemail)) {
              arrayCredentials[i] = email;
              valid = true;
            } else {
              System.out.println("Email inválido, intente de nuevo");
              valid = false;
            }
          } while (!valid);
          break;
      } // end switch
    }

  }
}
