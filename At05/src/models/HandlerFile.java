package models;

import interfaces.FileDatabase;
import interfaces.FolderManagment;
import interfaces.ImageFileDatabase;

public class HandlerFile {
    ImageFileDatabase imageFileOrchestrator;
    FileDatabase fileOrchestrator;
    FolderManagment folderManagment;

    public void saveFileWithDirectory(MFile mFile){
        fileOrchestrator.saveFile(
                mFile.getPath(),
                mFile.getContent(),
                mFile.getType(),
                mFile.getNameFile());

    }

    public HandlerFile(){
        imageFileOrchestrator = new FileOrchestrator();
        fileOrchestrator = new FileOrchestrator();
        folderManagment = new FolderOrchestrator();
    }

    public void createAImageDirectory(MFile mFile){
        folderManagment.createFolder(mFile.getPath(), mFile.getType());
    }

    public void saveImageFileWithDirectory(MFile mFile){
        imageFileOrchestrator.saveImageFile(mFile.getPath(), mFile.getContent(), mFile.getNameFile());
    }

    public void createADirectory(MFile mFile){
        folderManagment.createFolder(mFile.getPath(), mFile.getType());
    }
}
