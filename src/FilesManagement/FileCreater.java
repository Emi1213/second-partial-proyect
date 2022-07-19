package FilesManagement;

import java.io.File;
import utils.*;

public class FileCreater {
    private UserInput userInput = new UserInput();
    private String projectName;
    private String projectPath;
    private String packpageName;

    public FileCreater(String projectName, String projectPath, String packpageName) {
        this.projectName = projectName;
        this.projectPath = projectPath;
        this.packpageName = packpageName;
    }

    /**
     * @description Creates the project folder and the package folder
     * @return {boolean} True if the project folder and the package folder were
     *         created successfully, false otherwise
     */

    public boolean createProjectFolder() {
        File projectFolder = new File(projectPath + projectName);

        if (projectFolder.exists()) {
            System.out.println("El proyecto ya existe");
            return false;
        } else {

            return true;
        }
    }

    /**
     * @description Creates the package folders
     * @return {boolean} True if the package folder was created successfully,
     *         false otherwise
     * @param {String} packpageName The name of the package folder
     */

    public boolean createPackageFolder() {
        boolean isCreated = true;
        if (packpageName.contains(".")) {
            String ArraypackpageName[] = packpageName.split(".");
            isCreated = true;

            for (int i = 0; i < ArraypackpageName.length; i++) {
                File packageFolder = new File(projectPath + projectName + "\\" + ArraypackpageName[i]);
                if (packageFolder.exists()) {
                    System.out.println("El paquete ya existe");
                    isCreated = false;

                } else {
                    packageFolder.mkdir();
                    isCreated = true;
                }
            }
        } else {
            File packageFolder = new File(projectPath + projectName + "\\" + packpageName);
            if (packageFolder.exists()) {
                System.out.println("El paquete ya existe");
                isCreated = false;
            } else {
                packageFolder.mkdir();
                isCreated = true;
            }
        }

        if (isCreated == false) {
            return false;
        } else {
            return true;
        }
    }

    public void showFiles(File file) {
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i].getName() + " " + files[i].length());
        }
    }

}
