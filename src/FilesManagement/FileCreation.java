package FilesManagement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import utils.Colors;
import utils.UserInput;

public class FileCreation {
    public String projectName;
    public String projectPath;
    public String packageName;
    final String[] EXTENSSIONS = { ".java", ".txt", ".xml", ".html", ".css", ".js", ".json", ".csv" };
    public File log;

    public FileCreation(String projectName, String projectPath, String packageName) {
        this.projectName = projectName;
        this.projectPath = projectPath;
        this.packageName = packageName;
        log = new File(projectPath + "\\" + projectName + "\\log.txt");
    }

    /**
     * @description Save the option selected in the log file
     * @param option  int with the option selected
     * @param OPTIONS String[] with the options available
     * @return void
     */
    public void saveInLog(int option, String[] OPTIONS) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(log, true));
            bw.write(getTime() + "\tSe utilizó la opción: " + OPTIONS[option] + "\n");
            bw.close();
        } catch (Exception e) {
            System.out.println("Error al escribir en el archivo log");
        }

    }

    /**
     * @description Save the option selected in the log file
     * @param option String with the option selected
     * @return void
     */
    public void saveInLog(String option) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(log, true));
            bw.write(getTime() + "\tSe utilizó la opción: " + option + "\n");
            bw.close();
        } catch (Exception e) {
            System.out.println("Error al escribir en el archivo log");
        }

    }

    /**
     * @description Creates the project folder and the package folder
     * @return {boolean} True if the project folder and the package folder were
     *         created successfully, false otherwise
     */

    public boolean createProjectFolder() {
        File projectFolder = new File(projectPath + "\\" + projectName);
        File fileProjectPath = new File(projectPath);
        if (fileProjectPath.exists()) {

            if (projectFolder.exists()) {
                System.out.println("El proyecto ya existe");
                return false;
            } else {
                try {
                    projectFolder.mkdir();
                    System.out.println(
                            Colors.ANSI_CYAN + "\nEl proyecto se ha creado correctamente\n" + Colors.ANSI_RESET);
                    saveInLog("Se creó la carpeta del proyecto");
                    return true;
                } catch (SecurityException e) {
                    System.out.println("Error al crear el proyecto");
                    return false;
                }
            }
        } else {
            System.out.println("El directorio ingresado no existe no existe");
            return false;
        }
    }

    /**
     * @description Get the path of Project folder
     * @return {String} The path of the project folder
     */
    public String getProjectFolderPath() {
        String projectFolderPath = projectPath + "\\" + projectName;
        return projectFolderPath;
    }

    /**
     * @description Creates the package folders in subfolders of the project
     * @return {boolean} True if the package folder was created successfully,
     *         false otherwise
     */

    public boolean createScalonatePackageFolder() {
        boolean isCreated = true;
        File packageFolder = new File(getProjectFolderPath());
        ArrayList<String> ArraypackageName = new ArrayList<String>();
        System.out.println("");

        try {
            if (packageName.contains(".")) {
                for (int i = 0; i < packageName.split("\\.").length; i++) {
                    ArraypackageName.add(packageName.split("\\.")[i]);
                }
                for (int i = 0; i < ArraypackageName.size(); i++) {
                    packageFolder = new File(packageFolder.getAbsolutePath() + "\\" + ArraypackageName.get(i));
                    if (packageFolder.exists()) {
                        System.out.println("El paquete ya existe");
                        isCreated = false;

                    } else {
                        packageFolder.mkdir();
                        System.out.println(
                                Colors.ANSI_CYAN + "El paquete se ha creado correctamente" + Colors.ANSI_RESET);
                        isCreated = true;
                    }
                    if (i == ArraypackageName.size() - 1) {
                        File projectFile = new File(
                                packageFolder.getAbsolutePath() + "\\"
                                        + projectName + ".java");
                        if (projectFile.exists()) {
                            System.out.println(Colors.ANSI_RED + "El archivo \"" + projectName + ".java\" ya existe"
                                    + Colors.ANSI_RESET);
                            isCreated = false;
                        } else {
                            projectFile.createNewFile();
                            System.out.println(
                                    Colors.ANSI_CYAN + "El archivo \"" + projectName
                                            + ".java\" se ha creado correctamente"
                                            + Colors.ANSI_RESET);
                            isCreated = true;
                        }
                    }
                }
            } else {
                packageFolder = new File(getProjectFolderPath() + "\\" + packageName);
                if (packageFolder.exists()) {
                    System.out.println("El paquete ya existe");
                    isCreated = false;
                } else {
                    packageFolder.mkdir();
                    System.out.println(Colors.ANSI_CYAN + "El paquete se ha creado correctamente" + Colors.ANSI_RESET);

                    isCreated = true;
                }
            }

            if (isCreated == false) {
                return false;
            } else {
                saveInLog("Se creó las carpetas del paquete");
                return true;

            }
        } catch (Exception e) {
            System.out.println(
                    Colors.ANSI_RED + "Error en la creación de los paquetes: " + e.getMessage() + Colors.ANSI_RESET);
            return false;
        }
    }

    /**
     * @description Creates the package folders
     * @return {boolean} True if the package folder was created successfully,
     *         false otherwise
     */

    public boolean createPackageFolder() {
        boolean isCreated = true;
        File packageFolder;
        ArrayList<String> ArraypackageName = new ArrayList<String>();
        try {
            if (packageName.contains(".")) {
                for (int i = 0; i < packageName.split("\\.").length; i++) {
                    ArraypackageName.add(packageName.split("\\.")[i]);
                }

                for (int i = 0; i < ArraypackageName.size(); i++) {
                    packageFolder = new File(getProjectFolderPath() + "\\" + ArraypackageName.get(i));
                    if (packageFolder.exists()) {
                        System.out.println("El paquete ya existe");
                        isCreated = false;

                    } else {
                        packageFolder.mkdir();
                        System.out.println(
                                Colors.ANSI_CYAN + "El paquete se ha creado correctamente" + Colors.ANSI_RESET);

                        isCreated = true;
                    }
                }
                File projectFile = new File(getProjectFolderPath() + "\\"
                        + projectName + ".java");
                if (projectFile.exists()) {
                    System.out.println(Colors.ANSI_RED + "El archivo \"" + projectName + ".java\" ya existe"
                            + Colors.ANSI_RESET);
                    isCreated = false;
                } else {
                    projectFile.createNewFile();
                    System.out.println(
                            Colors.ANSI_CYAN + "El archivo \"" + projectName + ".java\" se ha creado correctamente"
                                    + Colors.ANSI_RESET);
                    isCreated = true;
                }
            } else {
                packageFolder = new File(getProjectFolderPath() + "\\" + packageName);
                if (packageFolder.exists()) {
                    System.out.println("El paquete ya existe");
                    isCreated = false;
                } else {
                    packageFolder.mkdir();
                    System.out.println(Colors.ANSI_CYAN + "El paquete se ha creado correctamente" + Colors.ANSI_RESET);

                    isCreated = true;
                }
            }

            if (isCreated == false) {
                return false;
            } else {
                saveInLog("Se creó las carpetas del paquete");
                return true;

            }
        } catch (Exception e) {
            System.out.println("Error en la creación de los paquetes: " + e.getMessage());
            return false;
        }
    }

    /**
     * @description Show the propities of the file argument
     * @param file
     * @return String whit the propities in a format to print
     */

    public String showFilesPropities(File file) {
        String filePropities = Colors.ANSI_BLUE + "*********************************************************\n"
                + "Nombre: " + Colors.ANSI_RESET + file.getName() + "\n" + Colors.ANSI_BLUE + "Tipo: "
                + Colors.ANSI_RESET + showFileType(file) + "\t            " + Colors.ANSI_BLUE + "Tamaño: "
                + Colors.ANSI_RESET
                + String.valueOf(file.length()) + " Bytes"
                + "\n" + Colors.ANSI_BLUE + "Permisos de Lectura: " + Colors.ANSI_RESET
                + changeBooleanToString(file.canRead()) + "     " + Colors.ANSI_BLUE + "Permisos de escritura: "
                + Colors.ANSI_RESET
                + changeBooleanToString(file.canWrite()) + "\n";

        return filePropities;
    }

    /**
     * @description Change true to si and false to no
     * @param booleanToChange
     * @return String with the boolean value
     */
    public String changeBooleanToString(boolean booleanToChange) {
        if (booleanToChange) {
            return "Si";
        } else {
            return "No";
        }
    }

    /**
     * @description Show Archivo if the file is a file or carpeta if is a directory
     * @param file
     * @return String with the type of the file
     */
    public String showFileType(File file) {
        if (file.isFile()) {
            return "Archivo";
        } else {
            return "Carpeta";
        }
    }

    /**
     * @description Print the list of the files whit description of a File or file
     *              path
     * @param file
     * @return void
     */

    public void showFiles(File file) {
        File[] files = file.listFiles();
        System.out.println(Colors.ANSI_YELLOW +
                "\nTe encuentras en el directorio: " + file.getPath() + ", contiene los archivos y carpetas:\n"
                + Colors.ANSI_RESET);
        for (int i = 0; i < files.length; i++) {
            System.out.println(showFilesPropities(files[i]));
        }
    }

    /**
     * @description Print the list of the files whit description of a File or file
     *              path
     * @param path String with the path of the file or file
     * @return void
     */
    public void showFiles(String path) {
        File filePath = new File(path);
        File[] files = filePath.listFiles();
        System.out.println(Colors.ANSI_YELLOW +
                "\nTe encuentras en el directorio: " + filePath.getPath() + ", contiene los archivos y carpetas:\n"
                + Colors.ANSI_RESET);
        for (int i = 0; i < files.length; i++) {
            System.out.println(showFilesPropities(files[i]));
        }
    }

    /**
     * @description Print the list of the files whit description of a File or file
     *              path
     * @param path String with the path of the file or file
     * @return Array of files
     */
    public File[] getFiles(String path) {
        File filePath = new File(path);
        File[] files = filePath.listFiles();
        System.out.println(Colors.ANSI_YELLOW +
                "\nTe encuentras en el directorio: " + filePath.getPath() + ", contiene los archivos y carpetas:\n"
                + Colors.ANSI_RESET);
        for (int i = 0; i < files.length; i++) {
            System.out.println(showFilesPropities(files[i]));
        }
        return files;
    }

    /**
     * @description Print the list of the files whit description of a File or file
     *              path
     * @param file
     * @return Array of files
     */
    public File[] getFiles(File file) {
        ;
        File[] files = file.listFiles();
        System.out.println(
                Colors.ANSI_YELLOW +
                        "\nTe encuentras en el directorio: " + file.getPath() + ", contiene los archivos y carpetas:\n"
                        + Colors.ANSI_RESET);
        for (int i = 0; i < files.length; i++) {
            System.out.println((i + 1) + ". " + showFilesPropities(files[i]));
        }
        return files;
    }

    /**
     * @description Save in a String Array the list of the files whit description of
     *              a File or file
     *              path
     * @param file
     * @return Array of files
     */
    public String[] getFilesString(File file) {
        ;
        File[] files = file.listFiles();
        String[] filesString = new String[files.length];
        System.out.println(Colors.ANSI_YELLOW +
                "\nTe encuentras en el directorio: " + file.getPath() + ", contiene los archivos y carpetas:\n"
                + Colors.ANSI_RESET);
        for (int i = 0; i < files.length; i++) {
            filesString[i] = (" " + (i + 1) + ". " + showFilesPropities(files[i]));
        }
        return filesString;
    }

    /**
     * @description Save in a String Array the list of the directories whit
     *              description
     * @param file
     * @return String[] Array of directories
     */
    public String[] getDirectoriesString(File file) {
        ArrayList<File> directories = new ArrayList<File>();
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                directories.add(files[i]);
            }
        }
        String[] filesString = new String[directories.size()];
        System.out.println(Colors.ANSI_YELLOW +
                "\nTe encuentras en el directorio: " + file.getPath() + ", contiene las carpetas:\n"
                + Colors.ANSI_RESET);
        for (int i = 0; i < directories.size(); i++) {
            filesString[i] = (" " + (i + 1) + ". " + showFilesPropities(directories.get(i)));
        }
        return filesString;
    }

    /**
     * @description Save in a File Array the list of the directories whit
     *              description
     * @param file
     * @return File[] Array of directories
     */
    public File[] getDirectories(File file) {
        ArrayList<File> directories = new ArrayList<File>();
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                directories.add(files[i]);
            }
        }
        String[] filesString = new String[directories.size()];
        System.out.println(Colors.ANSI_YELLOW + "\nTe encuentras en  el directorio: " + file.getPath()
                + ", contiene las carpetas:\n" + Colors.ANSI_RESET);
        for (int i = 0; i < filesString.length; i++) {
            filesString[i] = (" " + (i + 1) + ". " + showFilesPropities(directories.get(i)));
            System.out.println(filesString[i]);
        }
        return directories.toArray(new File[directories.size()]);
    }

    /**
     * @description Save in a File Array the list of the directories whit
     *              description
     * @param file
     * @return File[] Array of directories
     */
    public File[] getDirectoriesOnly(File file) {
        ArrayList<File> directories = new ArrayList<File>();
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                directories.add(files[i]);
            }
        }

        return directories.toArray(new File[directories.size()]);
    }

    /**
     * @description Create a file by asking the user the extension of the file and
     *              the name of the file after run the changeDirectory method
     * @param projectPath String whit the path will run the changeDirectory method
     * @return {boolean} True if the file was created successfully, false otherwise
     */
    public boolean createFile(String projectPath) {
        File filePath = new File(projectPath);
        File filePathToCreate = changeDirectoryFolders(filePath);
        int extenssion = 0;
        String nameFile = "";
        boolean isValidExtension = true;
        File file;
        boolean isCreated = true;

        do {
            System.out.println("\nIngrese la extensión para el archivo que desea crear: \n\n");
            extenssion = InitialData.getNumeredOptionByArray(EXTENSSIONS);

            System.out.println("\nLa extensión ingresada es: " + EXTENSSIONS[extenssion - 1]);
            System.out.println("\nIngrese el nombre del archivo:");
            nameFile = InitialData.setParam();
            file = new File(filePathToCreate + "\\" + nameFile + EXTENSSIONS[extenssion - 1]);

            if (file.exists()) {
                System.out.println(Colors.ANSI_RED + "El archivo ya existe" + Colors.ANSI_RESET);
                isCreated = false;
            } else {
                try {
                    file.createNewFile();
                    System.out.println(Colors.ANSI_GREEN + "\nEl archivo fue creado con éxito" + Colors.ANSI_RESET);
                    isCreated = true;
                } catch (IOException e) {
                    System.out.println(Colors.ANSI_RED + "Error al crear el archivo" + Colors.ANSI_RESET);
                    isCreated = false;
                }
            }

        } while (!isValidExtension);

        return isCreated;
    }

    /**
     * @description Create a directory by asking the user the name of the directory
     *              after run the changeDirectory method
     * @param projectPath where the directory will run the changeDirectory method
     * @return {boolean} True if the directory was created successfully, false
     *         otherwise
     */
    public boolean createFolder(String projectPath) {
        File filePath = new File(projectPath);
        File filePathToCreate = changeDirectoryFolders(filePath);
        String nameFolder = "";
        File file;
        boolean isCreated = true;

        do {
            System.out.println("\nIngrese el nombre de la carpeta que desea crear:");
            nameFolder = InitialData.setParam();
            file = new File(filePathToCreate + "\\" + nameFolder);
            if (file.exists()) {
                System.out.println(Colors.ANSI_RED + "La carpeta ya existe" + Colors.ANSI_RESET);
                isCreated = false;
            } else {
                try {
                    file.mkdir();
                    System.out.println(Colors.ANSI_GREEN + "\nLa carpeta fue creada" + Colors.ANSI_RESET);
                    isCreated = true;
                } catch (SecurityException e) {
                    System.out.println(Colors.ANSI_RED + "\nError al crear la carpeta" + Colors.ANSI_RESET);
                    isCreated = false;
                }
            }
        } while (!isCreated);

        return isCreated;
    }

    /**
     * @description Change the directory to show the files
     * @param path String with the path of the directory
     * @return void
     */
    public File moveOnDirectories(String path) {
        File file = new File(path);
        File filePath = file;
        File[] directoriesArray;
        String[] changeOrBack = { "Cambiar de directorio", "Regresar al directorio principal",
                "Terminar de ver" };
        String[] changeOrSelec = { "Cambiar de directorio", "Terminar de ver" };
        String[] backOrSelect = { "Regresar al directorio principal", "Terminar de ver" };
        boolean isSelect = true;
        int option = 0;
        int fileOption = 0;

        do {

            if (filePath.exists()) {

                if (filePath.isDirectory()) {
                    directoriesArray = getFiles(filePath);

                    if (directoriesArray.length > 0) {

                        if (filePath == file) {
                            option = InitialData.getNumeredOptionByArray(changeOrSelec);

                            switch (option) {
                                case 1:

                                    System.out.println(Colors.ANSI_PURPLE
                                            + "\nIngrese el número del directorio al que desea cambiar: "
                                            + Colors.ANSI_RESET);
                                    fileOption = InitialData.getOptionByArray(getFilesString(filePath));
                                    filePath = directoriesArray[fileOption - 1];
                                    isSelect = false;
                                    break;

                                case 2:
                                    System.out.println(Colors.ANSI_GREEN
                                            + "\nGracias por ver" + Colors.ANSI_RESET);
                                    isSelect = true;
                                    break;

                            }
                        } else {

                            option = InitialData.getNumeredOptionByArray(changeOrBack);

                            switch (option) {
                                case 1:
                                    System.out.println(Colors.ANSI_PURPLE
                                            + "\nIngrese el número del directorio al que desea cambiar: "
                                            + Colors.ANSI_RESET);
                                    fileOption = InitialData.getOptionByArray(getFilesString(filePath));
                                    filePath = directoriesArray[fileOption - 1];
                                    isSelect = false;
                                    break;
                                case 2:
                                    System.out.println(Colors.ANSI_YELLOW
                                            + "\nSe ha regresado al directorio principal"
                                            + Colors.ANSI_RESET);
                                    filePath = file;
                                    isSelect = false;
                                    break;
                                case 3:
                                    System.out.println(Colors.ANSI_GREEN
                                            + "\nGracias por ver"
                                            + Colors.ANSI_RESET);
                                    isSelect = true;
                                    break;

                            }

                        }

                    } else {
                        System.out.println(
                                Colors.ANSI_YELLOW + "\nEl directorio no contiene archivos o carpetas"
                                        + Colors.ANSI_RESET);
                        option = InitialData.getNumeredOptionByArray(backOrSelect);
                        switch (option) {
                            case 1:
                                System.out.println(Colors.ANSI_YELLOW
                                        + "\nSe ha regresado al directorio principal"
                                        + Colors.ANSI_RESET);
                                filePath = file;
                                isSelect = false;
                                break;
                            case 2:
                                System.out.println(Colors.ANSI_GREEN
                                        + "\nGracias por ver"
                                        + Colors.ANSI_RESET);
                                isSelect = true;
                                break;
                        }
                    }
                } else {
                    System.out.println(Colors.ANSI_YELLOW + "\nEs un archivo" + Colors.ANSI_RESET);
                    option = InitialData.getNumeredOptionByArray(backOrSelect);
                    switch (option) {
                        case 1:
                            System.out.println(Colors.ANSI_YELLOW
                                    + "\nSe ha regresado al directorio principal"
                                    + Colors.ANSI_RESET);
                            filePath = file;
                            isSelect = false;
                            break;
                        case 2:
                            System.out.println(Colors.ANSI_GREEN
                                    + "\nGracias por ver"
                                    + Colors.ANSI_RESET);
                            isSelect = true;
                            break;
                    }
                }
            } else {
                System.out.println(Colors.ANSI_RED + "\nEl directorio no existe" + Colors.ANSI_RESET);
                filePath = new File(filePath.getParent());

            }
        } while (!isSelect);

        return filePath;

    }

    /**
     * @descripton Get the actual time in a format "HH:MM:SS"
     * @return String whit the actual time
     */
    public String getTime() {
        LocalDateTime isTime = LocalDateTime.now();
        String time = isTime.format(DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss"));

        return time;
    }

    /**
     * @description Change the directory to show the files
     * @param path String with the path of the directory
     * @return void
     */
    public File changeDirectory(String path) {
        File file = new File(path);
        File filePath = file;
        File[] directoriesArray;
        String[] changeOrBack = { "Cambiar de directorio", "Regresar al directorio principal",
                "Seleccionar este directorio o archivo" };
        String[] changeOrSelec = { "Cambiar de directorio", "Seleccionar este directorio o archivo" };
        String[] backOrSelect = { "Regresar al directorio principal", "Seleccionar este directorio o archivo" };
        boolean isSelect = true;
        int option = 0;
        int fileOption = 0;

        do {

            if (filePath.exists()) {

                if (filePath.isDirectory()) {
                    directoriesArray = getFiles(filePath);

                    if (directoriesArray.length > 0) {

                        if (filePath == file) {
                            option = InitialData.getNumeredOptionByArray(changeOrSelec);

                            switch (option) {
                                case 1:

                                    System.out.println(Colors.ANSI_PURPLE
                                            + "\nIngrese el número del directorio al que desea cambiar: "
                                            + Colors.ANSI_RESET);
                                    fileOption = InitialData.getOptionByArray(getFilesString(filePath));
                                    filePath = directoriesArray[fileOption - 1];
                                    isSelect = false;
                                    break;

                                case 2:
                                    System.out.println(Colors.ANSI_GREEN
                                            + "\nSe ha seleccionado este directorio o archivo" + Colors.ANSI_RESET);
                                    isSelect = true;
                                    break;

                            }
                        } else {

                            option = InitialData.getNumeredOptionByArray(changeOrBack);

                            switch (option) {
                                case 1:
                                    System.out.println(Colors.ANSI_PURPLE
                                            + "\nIngrese el número del directorio al que desea cambiar: "
                                            + Colors.ANSI_RESET);
                                    fileOption = InitialData.getOptionByArray(getFilesString(filePath));
                                    filePath = directoriesArray[fileOption - 1];
                                    isSelect = false;
                                    break;
                                case 2:
                                    System.out.println(Colors.ANSI_YELLOW
                                            + "\nSe ha regresado al directorio principal"
                                            + Colors.ANSI_RESET);
                                    filePath = file;
                                    isSelect = false;
                                    break;
                                case 3:
                                    System.out.println(Colors.ANSI_GREEN
                                            + "\nSe ha seleccionado este directorio o archivo"
                                            + Colors.ANSI_RESET);
                                    isSelect = true;
                                    break;

                            }

                        }

                    } else {
                        System.out.println(
                                Colors.ANSI_YELLOW + "\nEl directorio no contiene archivos o carpetas"
                                        + Colors.ANSI_RESET);
                        option = InitialData.getNumeredOptionByArray(backOrSelect);
                        switch (option) {
                            case 1:
                                System.out.println(Colors.ANSI_YELLOW
                                        + "\nSe ha regresado al directorio principal"
                                        + Colors.ANSI_RESET);
                                filePath = file;
                                isSelect = false;
                                break;
                            case 2:
                                System.out.println(Colors.ANSI_GREEN
                                        + "\nSe ha seleccionado este directorio o archivo"
                                        + Colors.ANSI_RESET);
                                isSelect = true;
                                break;
                        }
                    }
                } else {
                    System.out.println(Colors.ANSI_YELLOW + "\nEs un archivo" + Colors.ANSI_RESET);
                    option = InitialData.getNumeredOptionByArray(backOrSelect);
                    switch (option) {
                        case 1:
                            System.out.println(Colors.ANSI_YELLOW
                                    + "\nSe ha regresado al directorio principal"
                                    + Colors.ANSI_RESET);
                            filePath = file;
                            isSelect = false;
                            break;
                        case 2:
                            System.out.println(Colors.ANSI_GREEN
                                    + "\nSe ha seleccionado este directorio o archivo"
                                    + Colors.ANSI_RESET);
                            isSelect = true;
                            break;
                    }
                }
            } else {
                System.out.println(Colors.ANSI_RED + "\nEl directorio no existe" + Colors.ANSI_RESET);
                filePath = new File(filePath.getParent());

            }
        } while (!isSelect);

        return filePath;

    }

    /**
     * @description Change the directory to show the folders
     * @param file File with the path of the directory
     * @return File with the path selected by the user
     */
    public File changeDirectoryFolders(File file) {
        File filePath = file;
        File[] directoriesArray;
        String[] changeOrBack = { "Cambiar de directorio", "Regresar al directorio principal",
                "Seleccionar este directorio" };
        String[] changeOrSelec = { "Cambiar de directorio", "Seleccionar este directorio" };
        String[] backOrSelect = { "Regresar al directorio principal", "Seleccionar este directorio" };
        boolean isSelect = true;
        int option = 0;
        int fileOption = 0;

        do {

            if (filePath.exists()) {

                if (filePath.isDirectory()) {
                    directoriesArray = getDirectories(filePath);

                    if (directoriesArray.length > 0) {

                        if (filePath == file) {
                            option = InitialData.getNumeredOptionByArray(changeOrSelec);

                            switch (option) {
                                case 1:

                                    System.out.println(Colors.ANSI_PURPLE
                                            + "\nIngrese el número del directorio al que desea cambiar: "
                                            + Colors.ANSI_RESET);
                                    fileOption = InitialData.getOptionByArray(getDirectoriesString(filePath));
                                    filePath = directoriesArray[fileOption - 1];
                                    isSelect = false;
                                    break;

                                case 2:
                                    System.out.println(Colors.ANSI_GREEN
                                            + "\nSe ha seleccionado este directorio" + Colors.ANSI_RESET);
                                    isSelect = true;
                                    break;

                            }
                        } else {

                            option = InitialData.getNumeredOptionByArray(changeOrBack);

                            switch (option) {
                                case 1:
                                    System.out.println(Colors.ANSI_PURPLE
                                            + "\nIngrese el número del directorio al que desea cambiar: "
                                            + Colors.ANSI_RESET);
                                    fileOption = InitialData.getOptionByArray(getDirectoriesString(filePath));
                                    filePath = directoriesArray[fileOption - 1];
                                    isSelect = false;
                                    break;
                                case 2:
                                    System.out.println(Colors.ANSI_YELLOW
                                            + "\nSe ha regresado al directorio principal"
                                            + Colors.ANSI_RESET);
                                    filePath = file;
                                    isSelect = false;
                                    break;
                                case 3:
                                    System.out.println(Colors.ANSI_GREEN
                                            + "\nSe ha seleccionado este directorio"
                                            + Colors.ANSI_RESET);
                                    isSelect = true;
                                    break;

                            }

                        }

                    } else {
                        System.out.println(
                                Colors.ANSI_YELLOW + "\nEl directorio no contiene carpetas" + Colors.ANSI_RESET);
                        option = InitialData.getNumeredOptionByArray(backOrSelect);
                        switch (option) {
                            case 1:
                                System.out.println(Colors.ANSI_YELLOW
                                        + "\nSe ha regresado al directorio principal"
                                        + Colors.ANSI_RESET);
                                filePath = file;
                                isSelect = false;
                                break;
                            case 2:
                                System.out.println(Colors.ANSI_GREEN
                                        + "\nSe ha seleccionado este directorio"
                                        + Colors.ANSI_RESET);
                                isSelect = true;
                                break;
                        }
                    }
                } else {
                    System.out.println(Colors.ANSI_YELLOW + "\nEl archivo no es un directorio" + Colors.ANSI_RESET);
                    filePath = new File(filePath.getParent());
                }
            } else {
                System.out.println(Colors.ANSI_RED + "\nEl directorio no existe" + Colors.ANSI_RESET);
                filePath = new File(filePath.getParent());

            }
        } while (!isSelect);

        return filePath;

    }

    /**
     * @description Rename a file or directory
     * @param file File to rename
     * @return boolean True if the file was renamed successfully, false otherwise
     */
    public boolean renameFile(File file) {
        boolean isRenamed = false;
        boolean confirm = false;

        try {

            if (file.isFile()) {
                String nameFile = "";
                String extension = "";
                String originalExtension = file.getPath().substring(file.getPath().lastIndexOf("."));
                File newFile;
                System.out.println("Ingrese el nuevo nombre del archivo: ");
                nameFile = InitialData.setParam();
                System.out.println("¿Desea cambiar la extensión del archivo? (s/n)");
                confirm = UserInput.getSNUserOption();

                if (confirm) {
                    System.out.println("Ingrese la nueva extensión del archivo: ");
                    extension = EXTENSSIONS[InitialData.getNumeredOptionByArray(EXTENSSIONS) - 1];
                    newFile = new File(file.getParent() + "\\" + nameFile + extension);
                } else {
                    newFile = new File(file.getParent() + "\\" + nameFile + originalExtension);
                }
                if (newFile.exists()) {
                    System.out.println("El archivo con ese nombre ya existe");
                    isRenamed = false;
                } else {
                    System.out.println("¿Está seguro de que desea renombrar el archivo? (s/n)");
                    confirm = UserInput.getSNUserOption();
                    if (confirm) {
                        file.renameTo(newFile);
                        isRenamed = true;
                    } else {
                        System.out.println("No se ha renombrado el archivo");
                        isRenamed = false;
                    }
                }

            } else {
                System.out.println("\nIngrese el nuevo nombre de la carpeta: ");
                String nameFile = InitialData.setParam();
                File newFile = new File(file.getParent() + "\\" + nameFile);
                if (newFile.exists()) {
                    System.out.println("\nLa carpeta con ese nombre ya existe");
                } else {
                    System.out.println("\n¿Está seguro de renombrar la carpeta? (s/n)");
                    confirm = UserInput.getSNUserOption();
                    if (confirm) {
                        System.out.println("\nRenombrando carpeta...");
                        System.out.println("\nCarpeta renombrada***");
                        file.renameTo(newFile);
                        isRenamed = true;
                    } else {
                        System.out.println("\nNo se ha renombrado el directorio");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error al renombrar el archivo" + e.getMessage());
            isRenamed = false;
        }
        return isRenamed;

    }

    /**
     * @description Delete a file or directory
     * @param file File to delete
     * @return boolean True if the file was deleted successfully, false otherwise
     */
    public boolean deleteFile(File file) {
        boolean isDeleted = false;
        boolean confirm = false;
        try {
            if (file.isFile()) {
                System.out.println("¿Está seguro de que desea eliminar el archivo? (s/n)");
                confirm = UserInput.getSNUserOption();
                if (confirm) {
                    file.delete();
                    isDeleted = true;
                } else {
                    System.out.println("No se ha eliminado el archivo");
                }
            } else {
                System.out.println("¿Está seguro de que desea eliminar el directorio? (s/n)");
                confirm = UserInput.getSNUserOption();
                if (confirm) {
                    file.delete();
                    isDeleted = true;
                } else {
                    System.out.println("No se ha eliminado el directorio");
                }
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar el archivo" + e.getMessage());
            isDeleted = false;
        }
        return isDeleted;
    }

    /**
     * @description Read a file and print the content in the console
     * @param file File to read
     * @return boolean True if the file was read successfully, false otherwise
     */
    public boolean readFile(File file) {
        boolean isRead = false;
        try {
            if (file.isFile()) {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                if ((line = br.readLine()) == null) {
                    System.out.println(Colors.ANSI_WHITE + "El archivo está vacío" + Colors.ANSI_RESET);
                } else {
                    System.out.println(line);
                    while (br.ready()) {
                        line = br.readLine();
                        System.out.println(line);
                    }
                    br.close();
                    isRead = true;
                }
            } else {
                System.out.println("El argumento enviado no es un archivo");
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo" + e.getMessage());
            isRead = false;
        }
        return isRead;
    }

    /**
     * @description Write a file by asking to user if wants to overwrite or not
     * @param file File to write
     * @return boolean True if the file was written successfully, false otherwise
     */
    public boolean writeFile(File file) {
        boolean isWritten = false;
        boolean confirm = false;

        try {
            if (file.isFile()) {
                System.out.println(
                        "¿Qué forma de escritura desea probar?\n");
                int option = InitialData.getOptionByArray(
                        new String[] { "1. Sobreescribir el archivo.", "2. Escribir al final del archivo." });

                if (option == 1) {
                    FileWriter fw = new FileWriter(file);
                    do {
                        try {
                            System.out.println(Colors.ANSI_YELLOW
                                    + "Ingrese el contenido del archivo (Se sobreescribirá): " + Colors.ANSI_RESET);
                            String content = System.console().readLine();
                            fw.write(content + "\n");
                            fw.flush();
                            isWritten = true;
                            System.out.println(
                                    Colors.ANSI_PURPLE + "Deseas escribir otra linea? (s/n)" + Colors.ANSI_RESET);
                            confirm = UserInput.getSNUserOption();
                        } catch (Exception e) {
                            System.out.println(Colors.ANSI_RED + "Error al escribir el archivo" + e.getMessage()
                                    + Colors.ANSI_RESET);
                            isWritten = false;
                        }
                    } while (confirm);
                    fw.close();
                    System.out.println(Colors.ANSI_GREEN + "Archivo escrito con éxito" + Colors.ANSI_RESET);
                } else {

                    FileWriter fw = new FileWriter(file, true);
                    do {
                        try {
                            System.out.println("Ingrese el contenido del archivo (Se escribirá al final): ");
                            String content = System.console().readLine();
                            fw.write(content + "\n");
                            fw.flush();
                            isWritten = true;
                            System.out.println("Deseas escribir otra linea? (s/n)");
                            confirm = UserInput.getSNUserOption();
                        } catch (Exception e) {
                            System.out.println("Error al escribir el archivo" + e.getMessage());
                            isWritten = false;
                        }
                    } while (confirm);
                    fw.close();
                    System.out.println(Colors.ANSI_GREEN + "Archivo escrito con éxito" + Colors.ANSI_RESET);
                }

            } else {
                System.out.println("El argumento enviado no es un archivo");
            }
        } catch (Exception e) {
            System.out.println("Error al escribir el archivo" + e.getMessage());
            isWritten = false;
        }
        return isWritten;
    }

    /**
     * @description copy a file whit the same name in the same directory, ask to
     *              user to way to copy: 1. Copy exactly the file 2. Copy the file
     *              reemplacing the vocals for numbers 3. Copy the file begginin for
     *              the final character
     * @param file File to copy
     * @return boolean True if the file was copied successfully, false otherwise
     */
    public boolean copyFile(File file) {
        boolean isCopied = false;
        boolean confirm = false;
        String[] copyOptions = new String[] {
                "1. Copiar el archivo exactamente (Se guardará en el mismo directorio con el formato: copy_exactly_file).",
                "2. Copiar el archivo reemplazando las vocales por números(Se guardará en el mismo directorio con el formato: copy_replace_file).",
                "3. Copiar el archivo empezando por el final (Se guardará en el mismo directorio con el formato: copy_end_file)." };
        try {
            if (file.isFile()) {
                System.out.println(
                        "¿Qué forma de copiar desea probar?\n\n");
                int option = InitialData.getOptionByArray(copyOptions);

                switch (option) {
                    case 1:
                        File newFile = new File(file.getParent() + "\\" + "copy_exactly_" + file.getName());
                        if (newFile.exists()) {
                            System.out.println(Colors.ANSI_YELLOW
                                    + "El archivo copiado ya existe, desea sobreescribirlo? (s/n)" + Colors.ANSI_RESET);
                            confirm = UserInput.getSNUserOption();
                            if (confirm) {
                                newFile.delete();
                                copyTo(file, newFile);
                                System.out.println(Colors.ANSI_GREEN + "El archivo se ha copiado correctamente"
                                        + Colors.ANSI_RESET);
                                saveInLog("Copia exacta del archivo: " + file.getName());
                                isCopied = true;
                            } else {
                                System.out.println("No se ha copiado el archivo");
                            }
                        } else {
                            copyTo(file, newFile);
                            System.out.println(
                                    Colors.ANSI_GREEN + "El archivo se ha copiado correctamente" + Colors.ANSI_RESET);
                            saveInLog("Copia exacta del archivo: " + file.getName());
                            isCopied = true;
                        }
                        break;

                    case 2:
                        File newFile2 = new File(file.getParent() + "\\" + "copy_replace_" + file.getName());
                        if (newFile2.exists()) {
                            System.out.println(Colors.ANSI_YELLOW
                                    + "El archivo copiado ya existe, desea sobreescribirlo? (s/n)" + Colors.ANSI_RESET);
                            confirm = UserInput.getSNUserOption();
                            if (confirm) {
                                newFile2.delete();
                                copyToNumbers(file, newFile2);
                                System.out.println(Colors.ANSI_GREEN + "El archivo se ha copiado correctamente"
                                        + Colors.ANSI_RESET);
                                saveInLog("Copia reemplazo de vocales por números del archivo: " + file.getName());
                                isCopied = true;
                            } else {
                                System.out.println("No se ha copiado el archivo");
                            }
                        } else {
                            copyToNumbers(file, newFile2);
                            System.out.println(
                                    Colors.ANSI_GREEN + "El archivo se ha copiado correctamente" + Colors.ANSI_RESET);
                            saveInLog("Copia reemplazo de vocales por números del archivo: " + file.getName());
                            isCopied = true;
                        }
                        break;

                    case 3:
                        File newFile3 = new File(file.getParent() + "\\" + "copy_end_" + file.getName());
                        if (newFile3.exists()) {
                            System.out.println(Colors.ANSI_YELLOW
                                    + "El archivo copiado ya existe, desea sobreescribirlo? (s/n)" + Colors.ANSI_RESET);
                            confirm = UserInput.getSNUserOption();
                            if (confirm) {
                                newFile3.delete();
                                copyToEnd(file, newFile3);
                                System.out.println(Colors.ANSI_GREEN + "El archivo se ha copiado correctamente"
                                        + Colors.ANSI_RESET);
                                saveInLog("Copia reversa del archivo: " + file.getName());
                                isCopied = true;
                            } else {
                                System.out.println("No se ha copiado el archivo");
                            }
                        } else {
                            copyToEnd(file, newFile3);
                            System.out.println(
                                    Colors.ANSI_GREEN + "El archivo se ha copiado correctamente" + Colors.ANSI_RESET);
                            saveInLog("Copia reversa del archivo: " + file.getName());
                            isCopied = true;
                        }
                        break;

                    default:
                        System.out.println(Colors.ANSI_RED + "Opción inválida" + Colors.ANSI_RESET);
                        break;

                }
            } else {
                System.out.println("El argumento enviado no es un archivo");
            }
        } catch (Exception e) {
            System.out.println("Error al copiar el archivo" + e.getMessage());
            isCopied = false;
        }
        return isCopied;

    }

    /**
     * @description Copy the file of the firts parameter to the file in second
     *              parameter
     * @param file    File to copy
     * @param newFile File to copy in
     * @return boolean True if the file was copied successfully, false otherwise
     */
    public boolean copyTo(File file, File copyFile) {
        boolean isCopied = false;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            BufferedWriter bw = new BufferedWriter(new FileWriter(copyFile));
            String line;

            if (file.isFile()) {
                while ((line = br.readLine()) != null) {
                    bw.write(line);
                    bw.newLine();
                }
                bw.close();
                br.close();
                isCopied = true;

            } else {
                System.out.println("El argumento enviado no es un archivo");
            }
        } catch (IOException e) {
            System.out.println("Error al copiar el archivo" + e.getMessage());
            isCopied = false;
        }
        return isCopied;
    }

    /**
     * @description Copy the file of the firts parameter to the file in second
     *              parameter reemplacing the vocals for numbers
     * @param file     File to copy
     * @param copyFile File to copy in
     * @return boolean True if the file was copied successfully, false otherwise
     */
    public boolean copyToNumbers(File file, File copyFile) {
        boolean isCopied = false;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            BufferedWriter bw = new BufferedWriter(new FileWriter(copyFile));
            String line;

            if (file.isFile()) {
                while ((line = br.readLine()) != null) {
                    line = line.replaceAll("[AaÁá]", "1");
                    line = line.replaceAll("[EeÉé]", "2");
                    line = line.replaceAll("[IiÍí]", "3");
                    line = line.replaceAll("[OoÓó]", "4");
                    line = line.replaceAll("[UuÚú]", "5");

                    bw.write(line);
                    bw.newLine();
                }
                bw.close();
                br.close();
                isCopied = true;

            } else {
                System.out.println("El argumento enviado no es un archivo");
            }
        } catch (IOException e) {
            System.out.println("Error al copiar el archivo" + e.getMessage());
            isCopied = false;
        }
        return isCopied;
    }

    /**
     * @description Copy the file of the firts parameter to the file in second
     *              parameter beggin for the final character
     * @param file     File to copy
     * @param copyFile File to copy in
     * @return boolean True if the file was copied successfully, false otherwise
     */
    public boolean copyToEnd(File file, File copyFile) {
        boolean isCopied = false;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            BufferedWriter bw = new BufferedWriter(new FileWriter(copyFile));
            String line;
            ArrayList<String> reOrderLines = new ArrayList<String>();
            String backOrderLine = "";

            if (file.isFile()) {

                while ((line = br.readLine()) != null) {
                    reOrderLines.add(line);
                }
                for (int i = reOrderLines.size() - 1; i >= 0; i--) {
                    for (int j = reOrderLines.get(i).length() - 1; j >= 0; j--) {
                        backOrderLine += reOrderLines.get(i).charAt(j);
                    }
                    reOrderLines.set(i, backOrderLine);
                    backOrderLine = "";
                    bw.write(reOrderLines.get(i));
                    bw.newLine();
                }
                bw.close();
                br.close();
                isCopied = true;

            } else {
                System.out.println("El argumento enviado no es un archivo");
            }
        } catch (IOException e) {
            System.out.println("Error al copiar el archivo" + e.getMessage());
            isCopied = false;
        }
        return isCopied;

    }

}
