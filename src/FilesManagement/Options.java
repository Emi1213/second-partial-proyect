package FilesManagement;

import java.io.File;
import utils.Colors;

import utils.UserInput;

public class Options {
    FileCreation fileCreation;
    final String OPTIONS[] = { "",
            Colors.ANSI_BLACK + "1. Mostrar los archivos y directorios contenidos en el directorio del proyecto",
            "2. Crear archivos", "3. Modificar el nombre de una carpeta o archivo",
            "4. Eliminar un archivo o directorio", "5. Leer un archivo y mostrarlo en pantalla",
            "6. Escribir en un archivo", "7. Copiar un archivo", "8. Salir de las opciones de gestión\n" };

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

        boolean isValidOption = true;
        boolean runAgain = true;

        do {
            System.out.println("\nSeleccione una opción:");
            for (int i = 0; i < OPTIONS.length; i++) {
                System.out.println(Colors.ANSI_PURPLE + OPTIONS[i] + Colors.ANSI_RESET);
            }
            option = Integer.parseInt(System.console().readLine());
            if (option > 8 || option < 1) {
                System.out.println("\nLa opción seleccionada no es válida");
                isValidOption = false;
            } else {
                isValidOption = true;

                switch (option) {
                    case 1:
                        fileCreation.saveInLog(option, OPTIONS);
                        fileCreation.changeDirectory(fileCreation.getProjectFolderPath());
                        runAgain = getUserRunAgain();

                        break;

                    case 2:
                        fileCreation.saveInLog(option, OPTIONS);

                        fileCreation.createFile(fileCreation.getProjectFolderPath());
                        runAgain = getUserRunAgain();

                        break;

                    case 3:
                        fileCreation.saveInLog(option, OPTIONS);
                        System.out.println("\nPara renombrar un archivo o directorio, primero ubique el direcorio:\n");
                        File whereRename = fileCreation.changeDirectory(fileCreation.getProjectFolderPath());
                        System.out.println("\nIngresa el archivo o directorio que deseas renombrar");
                        int optionFileToRename = InitialData
                                .getOptionByArray(fileCreation.getFilesString(whereRename));
                        File fileToRename = whereRename.listFiles()[optionFileToRename - 1];
                        fileCreation.renameFile(fileToRename);
                        runAgain = getUserRunAgain();

                        break;

                    case 4:
                        fileCreation.saveInLog(option, OPTIONS);
                        File whereDelete = fileCreation.changeDirectory(fileCreation.getProjectFolderPath());
                        System.out.println("\nIngresa el archivo o directorio que deseas eliminar");
                        int optionFileToDelete = InitialData
                                .getOptionByArray(fileCreation.getFilesString(whereDelete));
                        File fileToDelete = whereDelete.listFiles()[optionFileToDelete - 1];
                        fileCreation.deleteFile(fileToDelete);
                        runAgain = getUserRunAgain();

                        break;

                    case 5:
                        fileCreation.saveInLog(option, OPTIONS);
                        File whereRead = fileCreation.changeDirectory(fileCreation.getProjectFolderPath());
                        System.out.println("\nIngresa el archivo que deseas leer");
                        int optionFileToRead = InitialData.getOptionByArray(fileCreation.getFilesString(whereRead));
                        File fileToRead = whereRead.listFiles()[optionFileToRead - 1];
                        fileCreation.readFile(fileToRead);
                        runAgain = getUserRunAgain();

                        break;

                    case 6:
                        fileCreation.saveInLog(option, OPTIONS);
                        File whereWrite = fileCreation.changeDirectory(fileCreation.getProjectFolderPath());
                        System.out.println("\nIngresa el archivo que deseas escribir");
                        int optionFileToWrite = InitialData
                                .getOptionByArray(fileCreation.getFilesString(whereWrite));
                        File fileToWrite = whereWrite.listFiles()[optionFileToWrite - 1];
                        fileCreation.writeFile(fileToWrite);
                        runAgain = getUserRunAgain();

                        break;

                    case 7:
                        fileCreation.saveInLog(option, OPTIONS);
                        File whereCopy = fileCreation.changeDirectory(fileCreation.getProjectFolderPath());
                        System.out.println("\nIngresa el archivo que deseas copiar");
                        int optionFileToCopy = InitialData.getOptionByArray(fileCreation.getFilesString(whereCopy));
                        File fileToCopy = whereCopy.listFiles()[optionFileToCopy - 1];
                        fileCreation.copyFile(fileToCopy);
                        runAgain = getUserRunAgain();

                        break;

                    case 8:
                        fileCreation.saveInLog(option, OPTIONS);
                        runAgain = false;

                        break;
                }

            }
        } while (!isValidOption || runAgain);

    }

    /**
     * @description Get the user answer to the question if he wants to run the same
     *              or other option again
     * @return boolean with the answer
     */
    public boolean getUserRunAgain() {
        boolean runAgain = true;
        System.out.println(
                Colors.ANSI_YELLOW
                        + "\n¿Desea ejecutar otra opción o ejecutar esta opción otra vez? (s/n)\n Al seleccionar s, se mostrarán nuevamente las opciones de gestión, al pulsar n, se finalizará la ejecución de las opciones de gestión y se mostrará la ventana inicial de creación de proyecto"
                        + Colors.ANSI_RESET);
        runAgain = UserInput.getSNUserOption();
        return runAgain;
    }

}
