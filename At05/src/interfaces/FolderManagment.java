package interfaces;

import models.MFileAnnotationTypeEnum;

public interface FolderManagment {

    void createFolder(String path, MFileAnnotationTypeEnum typeEnum);

    void removeFolder(String path);

    void listAllFoldersCreated(String path);


}
