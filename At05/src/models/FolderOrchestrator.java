package models;

import interfaces.FolderManagment;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.List;

public class FolderOrchestrator implements FolderManagment {
    @Override
    public void createFolder(String path, MFileAnnotationTypeEnum typeEnum) {
        String dir = "";
        switch(typeEnum){
            case REMINDER -> {
                dir = "reminders";
            }
            case IMAGE -> {
                dir = "images";
            }
            case SIMPLE -> {
                dir = "simples";
            }
            case IMPORTANT -> {
                dir = "importants";
            }
            default -> {
                dir = "";
            }
        }

        try {
            boolean mFile = new File(path +"\\"+dir).exists();
            if (mFile){
                System.out.println("Este diretório ja existe");
            } else {
                new File(path).mkdir();
                boolean result = new File(path+"\\"+dir).mkdir();
                if(result) System.out.println("Diretório criado");
                else {
                    System.out.println("Diretório não criado");
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao criar um diretório válido");
        }

    }
    @Override
    public void removeFolder(String path) {

        try {
            File mFile = new File(path);
            if (mFile.exists() && mFile.isDirectory()){
                mFile.delete();
                System.out.println("Diretório deletado");
            } else {
                System.out.println("o caminho desse diretório não existe");
            }
        } catch (Exception e) {
            System.out.println("Erro ao tentar deletar o diretório");
        }

    }
    @Override
    public void listAllFoldersCreated(String diretorio) {
        File file = new File(diretorio);
        String[] diretorios = file.list(new FilenameFilter(){
            @Override
            public boolean accept(File dir, String name) {
                return new File(dir, name).isDirectory();
            }
        });

        System.out.println("Os folders neste diretório são: " + Arrays.toString(diretorios));
    }


    public void createFolders(List<String> mListPaths){

    }

    public void removeFolders(List<String> mListPaths){

    }
}
