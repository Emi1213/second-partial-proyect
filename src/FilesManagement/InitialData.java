package FilesManagement;

import utils.Colors;
import utils.UserInput;

public class InitialData {
    /**
     * @description Set the project name whit validations
     * @return String
     */
    public String setProjectName() {
        String projectName = "";
        String regex = "[a-zA-Z0-9_]*";
        boolean isValidProjectName = false;
        do {
            System.out.println("\nIngrese el nombre del proyecto");
            projectName = System.console().readLine().trim();
            if (projectName.length() > 0 && projectName.matches(regex)) {
                isValidProjectName = true;
            } else {
                System.out.println(
                        "\nEl nombre del proyecto no puede ser vacío ni contener caracteres especiales además del \"_\"");
                isValidProjectName = false;
            }
        } while (!isValidProjectName);
        return projectName;
    }

    /**
     * @description Set the project path whit validations
     * @return String
     */
    public String setProjectPath() {
        String projectPath = "";
        boolean isValidProjectPath = false;
        do {
            try {
                System.out.println("\nIngrese el path del proyecto");
                projectPath = System.console().readLine().trim();
                if (projectPath.length() > 0) {
                    isValidProjectPath = true;
                } else {
                    System.out.println("\nEl path del proyecto no puede ser vacío");
                    isValidProjectPath = false;
                }
            } catch (Exception e) {
                System.out.println("\nError en el Path ingresado " + e.getMessage());
                isValidProjectPath = false;
            }
        } while (!isValidProjectPath);
        return projectPath;
    }

    /**
     * @description Set the packpage name whit validations whit the format
     *              "ec.edu.uta.fisei.software"
     * @return String
     */
    public String setPackageName() {
        String packpageName = "";
        boolean isValidPackpageName = false;
        String regexPackpageName = "^[a-zA-Z0-9_]+[\\.]{1}[[a-zA-Z0-9_]+[\\.]{1}]*[a-zA-Z0-9_]{1}$";
        do {
            System.out.println(
                    "\nIngrese el nombre del paquete siguiendo el formato (ec.edu.uta.fisei.software)(minimo debe tener dos carpetas): ");
            packpageName = System.console().readLine().trim();
            if (packpageName != null && packpageName.length() > 0 && packpageName.matches(regexPackpageName)) {
                isValidPackpageName = true;
            } else {
                System.out
                        .println("\nError en el nombre del paquete recuerdad el formato: (ec.edu.uta.fisei.software)");
                isValidPackpageName = false;
            }
        } while (!isValidPackpageName);

        return packpageName;
    }

    /**
     * @description Set a String param with validations
     * @return String whit the param
     */
    public static String setParam() {
        String param = "";
        boolean isValidParam = false;
        do {
            param = System.console().readLine().trim();
            if (param.length() > 0) {
                isValidParam = true;
            } else {
                System.out.println("El parametro no puede ser vacío");
                isValidParam = false;
            }
        } while (!isValidParam);
        return param;
    }

    /**
     * @description Get the user selected option by an array of options whit
     *              validations
     * @return int whit the option selected
     */
    public static int getOptionByArray(String[] options) {
        int option = 0;
        boolean isValidOption = false;
        do {
            System.out.println(Colors.ANSI_CYAN + "\nSeleccione una opción:\n" + Colors.ANSI_RESET);
            for (int i = 0; i < options.length; i++) {
                System.out.println(Colors.ANSI_PURPLE + options[i] + Colors.ANSI_RESET);
            }
            try {
                option = UserInput.getUserOption();
                if (option > 0 && option <= options.length) {
                    isValidOption = true;
                } else {
                    System.out.println(Colors.ANSI_RED + "\nLa opción seleccionada no es válida" + Colors.ANSI_RESET);
                    isValidOption = false;
                }
            } catch (NumberFormatException e) {
                System.out.println(Colors.ANSI_RED + "\nLa opción seleccionada no es válida" + Colors.ANSI_RESET);
                isValidOption = false;
            }
        } while (!isValidOption);
        return option;
    }

    /**
     * @description Get the user selected option by an array of numered options whit
     *              validations
     * @return int whit the option selected
     */
    public static int getNumeredOptionByArray(String[] options) {
        int option = 0;
        boolean isValidOption = false;
        do {
            System.out.println(Colors.ANSI_CYAN + "\nSeleccione una opción:\n" + Colors.ANSI_RESET);
            for (int i = 0; i < options.length; i++) {
                System.out.println(Colors.ANSI_PURPLE + (i + 1) + ") " + options[i] + Colors.ANSI_RESET);
            }
            try {
                option = UserInput.getUserOption();
                if (option > 0 && option <= options.length) {
                    isValidOption = true;
                } else {
                    System.out.println(Colors.ANSI_RED + "\nLa opción seleccionada no es válida" + Colors.ANSI_RESET);
                    isValidOption = false;
                }
            } catch (NumberFormatException e) {
                System.out.println(Colors.ANSI_RED + "\nLa opción seleccionada no es válida" + Colors.ANSI_RESET);
                isValidOption = false;
            }
        } while (!isValidOption);
        return option;
    }

}
