package FilesManagement;

public class FilesManagement {
    public static void main(String[] args) {
        String regexAnswer = "[]";
        String answer = "";
        String isValidAnwer = "";
        System.out.println("Bienvenido a la opción para gestionar archivos y directorios");
        do{
        System.out.println("Vamos a empezar creando tu proyecto");
        System.out.println("Estas de acuerdo? (si/no)");
        answer = System.console().readLine().toLowerCase();
        if (answer == "si"|| answer == "no"||answer == "s"||answer == "n") {
            isValidAnwer = "si";
        } else {
            System.out.println("La respuesta ingresada no es válida");
            isValidAnwer = "no";
        }

        }

    }
}
