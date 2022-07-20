package FilesManagement;

import java.io.File;

import utils.Colors;
import utils.UserInput;

public class FilesManagement {
    public static void main(String[] args) {

        FileCreation fc;
        InitialData id = new InitialData();
        String projectName = "";
        String projectPath = "";
        String packageName = "";
        String welcome = "Bienvenido a la opción para crear proyectos y gestionar archivos y directorios";
        boolean answer = true;
        boolean runGestion = true;
        boolean runProjectAgain = true;
        boolean isValidProject = true;

        Options options;

        do {

            System.out.println(Colors.ANSI_BLUE + "\n -" + welcome.replaceAll("\\D", "-") + "-"
                    + "\n| " + welcome.replaceAll("\\D", " ") + " |"
                    + "\n| Bienvenido a la opción para crear proyectos y gestionar archivos y directorios |"
                    + "\n| " + welcome.replaceAll("\\D", " ") + " |"
                    + "\n -" + welcome.replaceAll("\\D", "-") + "-" + Colors.ANSI_RESET);

            System.out.println("\nVamos a empezar creando tu proyecto");
            System.out.println(Colors.ANSI_PURPLE + "Estas de acuerdo? (si/no)" + Colors.ANSI_RESET);
            answer = UserInput.getSNUserOption();

            if (answer) {
                try {
                    do {
                        projectName = id.setProjectName();
                        projectPath = id.setProjectPath();
                        File preProject = new File(projectPath + "\\" + projectName);
                        File testPath = new File(projectPath);
                        if (testPath.exists()) {
                            if (preProject.exists()) {
                                System.out
                                        .println(Colors.ANSI_RED + "El proyecto ya existe, ingrese un nombre diferente"
                                                + Colors.ANSI_RESET);
                                isValidProject = false;
                            } else {
                                isValidProject = true;
                            }
                        } else {
                            System.out.println(Colors.ANSI_RED + "El directorio no existe, ingrese un directorio válido"
                                    + Colors.ANSI_RESET);
                            isValidProject = false;
                        }
                    } while (!isValidProject);

                    packageName = id.setPackageName();
                    fc = new FileCreation(projectName, projectPath, packageName);
                    fc.createProjectFolder();
                    System.out.println("\nQuieres crear los paquetes en forma escalonada o en el mismo directorio?");
                    int option = InitialData.getNumeredOptionByArray(new String[] { "Escalonado", "Mismo directorio" });

                    if (option == 1) {
                        fc.createScalonatePackageFolder();
                    } else {
                        fc.createPackageFolder();
                    }

                    fc.saveInLog("Creación del proyecto " + projectName + " en " + projectPath);
                    System.out.println(
                            Colors.ANSI_PURPLE + "\nQuieres empezar a gestionarlo? (si/no)" + Colors.ANSI_RESET);
                    runGestion = UserInput.getSNUserOption();

                    if (runGestion) {
                        fc.saveInLog("Inicio de gestión del proyecto " + projectName + " en " + projectPath);
                        options = new Options(fc);
                        options.showOptions();
                    } else {
                        System.out.println("\nGracias por usar nuestra aplicación\n");
                        System.out.println(
                                "\n¿Quieres volver a empezar? (si/no)\n Al presionar \"n\" o \"no\" se terminará la ejecución de esta opción");
                        runProjectAgain = UserInput.getSNUserOption();
                        fc.saveInLog("\nFin de gestión del proyecto " + projectName + " en " + projectPath);

                    }

                } catch (Exception e) {
                    System.out.println("\nError al crear el proyecto" + e.getMessage());
                }

            } else {
                System.out.println(
                        "\n¿Quieres volver a empezar? (si/no)\n Al presionar \"n\" o \"no\" se terminará la ejecución de esta opción");
                runProjectAgain = UserInput.getSNUserOption();
                if (runProjectAgain) {
                    System.out.println("\nVuelve a empezar*");
                } else {
                    System.out.println("\nGracias por usar nuestra aplicación");
                    System.out.println("Saliendo de la aplicación...");
                    // hacer que el sistema espere 2 segundos
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("\nEsperamos que vuelvas pronto\n\n");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        } while (runProjectAgain);

    }
}
