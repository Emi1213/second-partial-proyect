package FilesManagement;

import utils.UserInput;

public class FilesManagement {
    public static void main(String[] args) {

        FileCreation fc;
        InitialData id = new InitialData();
        String projectName = "";
        String projectPath = "";
        String packageName = "";
        boolean answer = true;
        boolean runGestion = true;
        boolean runProjectAgain = true;

        Options options;

        do {

            System.out.println("\nBienvenido a la opción para crear proyectos y gestionar archivos y directorios");

            System.out.println("\nVamos a empezar creando tu proyecto");
            System.out.println("Estas de acuerdo? (si/no)");
            answer = UserInput.getSNUserOption();

            if (answer) {
                try {
                    projectName = id.setProjectName();
                    projectPath = id.setProjectPath();
                    packageName = id.setPackageName();
                    fc = new FileCreation(projectName, projectPath, packageName);
                    fc.createProjectFolder();
                    fc.createPackageFolder();
                    fc.saveInLog("Creación del proyecto " + projectName + " en " + projectPath);
                    System.out.println("\nQuieres empezar a gestionarlo? (si/no)");
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
                    System.out.println("Esperamos que vuelvas pronto\n\n");

                }
            }
        } while (runProjectAgain);

    }
}
