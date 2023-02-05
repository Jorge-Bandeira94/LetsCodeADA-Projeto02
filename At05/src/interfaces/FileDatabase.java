package interfaces;

import models.MFileAnnotationTypeEnum;

public interface FileDatabase {

    void saveFile(String directory, String content, MFileAnnotationTypeEnum typeEnum, String nameFile);

    void recoveryFile(String directory);

    void removeFile(String directory, String nameFile, MFileAnnotationTypeEnum typeEnum);

    void listAllFiles(String directory);
}
