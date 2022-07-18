package FilesManagement;

import java.io.File;
import java.util.ArrayList;

import javax.sound.sampled.SourceDataLine;

import utils.UserInput;

public class prueba {
    public static void main(String[] args) {
        FileCreation fc = new FileCreation("Jair",
                "D:\\respaldo\\Onedrive\\OneDrive - UNIVERSIDAD TÉCNICA DE AMBATO\\documentos\\1-U-SOFTWARE\\1 SEMESTRE\\ALGORTIMOS Y LOGICA DE PROGRAMACION\\projectExample",
                "com.jair.prueba");

        fc.createProjectFolder();
        fc.createPackageFolder();
        Options options = new Options(fc);
        options.showOptions();

    }

}
