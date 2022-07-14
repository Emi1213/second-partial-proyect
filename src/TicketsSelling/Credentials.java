package TicketsSelling;

import utils.*;

public class Credentials {

  public void getCredentials() {

    String name = "";
    String lastName = "";
    String ID = "";
    String age = "";
    String cellPhone = "";
    String email = "";

    String regexName = "^[A-Z]{1}[a-z]{1,}$";
    String regexLastName = "^[A-Z]{1}[a-z]{1,}$";
    String regexID = "^[0-9]{10}$";
    String regexAge = "^[0-9]{1,2}$";
    String regexCellPhone = "^[0-9]{10}$";
    String regexEmail = "^[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,4}$";

    String arrayCredentials[] = new String[6];

    for (int i = 0; i < arrayCredentials.length; i++) {
      switch (i) {
        case 0:
          name = UserInput.getUserParam("nombre", regexName);
          arrayCredentials[i] = name;
          break;

        case 1:
          lastName = UserInput.getUserParam("apellido", regexLastName);
          arrayCredentials[i] = lastName;
          break;

        case 2:
          ID = UserInput.getUserParam("ID", regexID);
          arrayCredentials[i] = ID;
          break;

        case 3:
          age = UserInput.getUserParam("edad", regexAge);
          arrayCredentials[i] = age;
          break;

        case 4:
          cellPhone = UserInput.getUserParam("celular", regexCellPhone);
          arrayCredentials[i] = cellPhone;
          break;

        case 5:
          email = UserInput.getUserParam("email", regexEmail);
          arrayCredentials[i] = email;
          break;

      } // end switch
    }

  }
}
