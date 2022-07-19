package TicketsSelling;

import utils.*;

public class Credentials {

  String arrayCredentials[] = new String[7];
  boolean descountClients = false;

  /**
   * @description This method is used to get the credentials of the user
   * 
   * @return void
   */
  public void getCredentials() {

    String name = "";
    String lastName = "";
    String ID = "";
    String age = "";
    String cellPhone = "";
    String email = "";
    int destinationsQuantity;

    String regexName = "^[A-Z]{1}[a-z]{1,}$";
    String regexLastName = "^[A-Z]{1}[a-z]{1,}$";
    String regexID = "^[0-9]{10}$";
    String regexAge = "^[0-9]{1,2}$";
    String regexCellPhone = "^[0-9]{10}$";
    String regexEmail = "^[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,4}$";
    String[] codesClients = { " 1851047363", "1710550607", "1802641322" };

    String customErrorMessage = "El dato ingresado no es válido, intenta de nuevo";

    for (int i = 0; i < arrayCredentials.length; i++) {
      switch (i) {
        case 0:
          name = UserInput.getUserParam("Ingresa tu nombre", regexName, customErrorMessage);
          arrayCredentials[i] = name;
          break;

        case 1:
          lastName = UserInput.getUserParam("Ingresa tu apellido", regexLastName, customErrorMessage);
          arrayCredentials[i] = lastName;
          break;

        case 2:
          ID = UserInput.getUserParam("Ingresa tu identificación", regexID, customErrorMessage);
          arrayCredentials[i] = ID;
          for (int j = 0; j < codesClients.length; j++) {
            if (ID.equals(codesClients[j])) {
              descountClients = true;
            } else {
              descountClients = false;
            }
          }
          break;

        case 3:
          age = UserInput.getUserParam("Ingresa tu edad", regexAge, customErrorMessage);
          arrayCredentials[i] = age;
          break;

        case 4:
          cellPhone = UserInput.getUserParam("Ingresa tu número de telefono", regexCellPhone, customErrorMessage);
          arrayCredentials[i] = cellPhone;
          break;

        case 5:
          email = UserInput.getUserParam("Ingresa tu email", regexEmail, customErrorMessage);
          arrayCredentials[i] = email;
          break;
        case 6:
          destinationsQuantity = Integer
              .parseInt(UserInput.getUserParam("Ingresa la cantidad de destinos que deseas comprar",
                  regexAge, customErrorMessage));
          arrayCredentials[i] = Integer.toString(destinationsQuantity);
          break;

      } // end switch
    }

  }

  /**
   * @description This method is used to return the credentials of the user
   * @return String[] The credentials of the user
   */
  public String[] getArrayCredentials() {
    return arrayCredentials;
  }

  public Boolean getDescountClients() {
    return descountClients;
  }
}
