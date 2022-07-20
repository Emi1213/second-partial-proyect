package FilesManagement;

import java.io.File;

import utils.Colors;

import utils.UserInput;

public class Options {
    FileCreation fileCreation;
    final String OPTIONS[] = { "",
            "1. Mostrar los archivos y directorios contenidos en el directorio del proyecto",
            "2. Crear archivos", "3. Modificar el nombre de una carpeta o archivo",
            "4. Eliminar un archivo o directorio", "5. Leer un archivo y mostrarlo en pantalla",
            "6. Escribir en un archivo", "7. Copiar un archivo", "8. Crear una carpeta",
            "9. Salir de las opciones de gestión\n" };

    public Options(FileCreation fileCreation) {
        this.fileCreation = fileCreation;
    }

    /**
     * @description Show the options to manage the project and save the selected
     *              option in the log file
     * @return int with the option selected
     */
    public void showOptions() {

        int option = 0;
        boolean runGestion = true;
        boolean runAgain = true;

        do {
            option = InitialData.getOptionByArray(OPTIONS);
            runGestion = getUserSure();

            if (runGestion) {

                switch (option) {
                    case 1:
                        fileCreation.saveInLog(option, OPTIONS);
                        fileCreation.moveOnDirectories(fileCreation.getProjectFolderPath());
                        runAgain = getUserRunAgain();

                        break;

                    case 2:
                        fileCreation.saveInLog(option, OPTIONS);
                        System.out.println(Colors.ANSI_GREEN
                                + "\nPara crear un archivo, primero ubique el directorio donde crearlo:"
                                + Colors.ANSI_RESET);
                        fileCreation.createFile(fileCreation.getProjectFolderPath());
                        runAgain = getUserRunAgain();

                        break;

                    case 3:
                        fileCreation.saveInLog(option, OPTIONS);
                        System.out.println(Colors.ANSI_GREEN
                                + "\nPara renombrar un archivo o directorio, primero ubique el archivo a ser renombrado:\n"
                                + Colors.ANSI_RESET);
                        File whereRename = fileCreation.changeDirectory(fileCreation.getProjectFolderPath());
                        ;
                        fileCreation.renameFile(whereRename);
                        runAgain = getUserRunAgain();

                        break;

                    case 4:
                        fileCreation.saveInLog(option, OPTIONS);
                        System.out.println(Colors.ANSI_GREEN
                                + "\nPara eliminar un archivo o directorio, primero ubique el archivo o directorio a ser eliminado:\n"
                                + Colors.ANSI_RESET);
                        File whereDelete = fileCreation.changeDirectory(fileCreation.getProjectFolderPath());
                        fileCreation.deleteFile(whereDelete);
                        runAgain = getUserRunAgain();

                        break;

                    case 5:
                        fileCreation.saveInLog(option, OPTIONS);
                        System.out.println(Colors.ANSI_GREEN
                                + "\nPara leer un archivo, primero ubique el archivo a ser leido:\n"
                                + Colors.ANSI_RESET);
                        File whereRead = fileCreation.changeDirectory(fileCreation.getProjectFolderPath());
                        fileCreation.readFile(whereRead);
                        runAgain = getUserRunAgain();

                        break;

                    case 6:
                        fileCreation.saveInLog(option, OPTIONS);
                        System.out.println(Colors.ANSI_GREEN
                                + "\nPara escribir en un archivo, primero ubique el archivo a ser escrito:\n"
                                + Colors.ANSI_RESET);
                        File whereWrite = fileCreation.changeDirectory(fileCreation.getProjectFolderPath());
                        fileCreation.writeFile(whereWrite);
                        runAgain = getUserRunAgain();

                        break;

                    case 7:
                        fileCreation.saveInLog(option, OPTIONS);
                        System.out.println(Colors.ANSI_GREEN
                                + "\nPara copiar un archivo, primero ubique el archivo a ser copiado:\n"
                                + Colors.ANSI_RESET);
                        File whereCopy = fileCreation.changeDirectory(fileCreation.getProjectFolderPath());
                        fileCreation.copyFile(whereCopy);
                        runAgain = getUserRunAgain();

                        break;

                    case 8:
                        fileCreation.saveInLog(option, OPTIONS);
                        System.out.println(Colors.ANSI_GREEN
                                + "\nPara crear una carpeta, primero ubique el directorio:\n" + Colors.ANSI_RESET);
                        fileCreation.createFolder(fileCreation.getProjectFolderPath());
                        runAgain = getUserRunAgain();

                        break;

                    case 9:
                        fileCreation.saveInLog(option, OPTIONS);
                        runAgain = false;

                        break;
                }
            }

        } while (runAgain);

    }

    /**
     * @description Get the user answer to the question if he wants to run the same
     *              or other option again
     * @return boolean with the answer
     */
    public boolean getUserRunAgain() {
        boolean runAgain = true;
        System.out.println(
                Colors.ANSI_CYAN
                        + "\n¿Desea ejecutar otra opción o ejecutar esta opción otra vez? (s/n)\n (Al seleccionar s, se mostrarán nuevamente las opciones de gestión, al pulsar n, se finalizará la ejecución de las opciones de gestión y se mostrará la ventana inicial de creación de proyecto)\n ->"
                        + Colors.ANSI_RESET);
        runAgain = UserInput.getSNUserOption();
        return runAgain;
    }

    /**
     * @description Ask the user if he be sure to run the option
     * @return boolean with the answer
     */
    public boolean getUserSure() {
        boolean sure = true;
        System.out.println(
                Colors.ANSI_CYAN
                        + "\n¿Está seguro de que desea ejecutar esta opción? (s/n)\n ->"
                        + Colors.ANSI_RESET);
        sure = UserInput.getSNUserOption();
        return sure;
    }

}
