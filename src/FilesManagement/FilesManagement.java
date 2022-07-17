package FilesManagement;

public class FilesManagement {
    public static void main(String[] args) {
        FileCreation fc;
        InitialData id = new InitialData();
        String projectName = "";
        String projectPath = "";
        String packageName = "";
        String answer = "";
        boolean isValidAnwer = false;

        Options options;

        System.out.println("Bienvenido a la opción para gestionar archivos y directorios");
        do {
            System.out.println("Vamos a empezar creando tu proyecto");
            System.out.println("Estas de acuerdo? (si/no)");
            answer = System.console().readLine().toLowerCase();
            if (answer == "si" || answer == "no" || answer == "s" || answer == "n") {
                isValidAnwer = true;
            } else {
                System.out.println("La respuesta ingresada no es válida");
                isValidAnwer = false;
            }

        } while (!isValidAnwer == true);
        if (answer == "si" || answer == "s") {
            try {
                projectName = id.setProjectName();
                projectPath = id.setProjectPath();
                packageName = id.setPackageName();
                fc = new FileCreation(projectName, projectPath, packageName);
                fc.createProjectFolder();
                fc.createPackageFolder();
                System.out.println("El proyecto se ha creado correctamente\n");
                options = new Options(fc);

            } catch (Exception e) {
                System.out.println("Error al crear el proyecto");
            }

        } else {
            System.out.println("Esperamos que vuelvas pronto");
        }

    }
}
