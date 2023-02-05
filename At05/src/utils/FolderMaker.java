package utils;


import models.*;

import java.util.Scanner;

public class FolderMaker {

    public String menuPastas(){
        Scanner scanner = new Scanner(System.in);
        HandlerFile handler = new HandlerFile();
        System.out.println("Bem vindo ao gerenciador de Pastas \n Escolha abaixo o que deseja fazer\n\n 1 - Criar Folder \n 2 - Deletar Folder \n 3 - Listar Folders \n 4 - Avançar para opções de arquivos");
        int resposta = scanner.nextInt();
        String diretorios = "";

        switch(resposta){
            case 1 -> {
                System.out.println("Agora escolha o tipo de arquivo\n\n 1 - Reminders \n 2 - Simple \n 3 - Important \n 4 - Image");
                int respostaPasta = scanner.nextInt();
                switch (respostaPasta){
                    case 1 ->{
                        System.out.println("Agora escolha o caminho do arquivo");
                        scanner.nextLine();
                        String respostaCaminho = scanner.nextLine();
                        diretorios = respostaCaminho;
                        MFile folder = new MFile();
                        folder.setPath(respostaCaminho);
                        folder.setType(MFileAnnotationTypeEnum.REMINDER);
                        handler.createADirectory(folder);
                    }
                    case 2 -> {
                        System.out.println("Agora escolha o caminho do arquivo");
                        scanner.nextLine();
                        String respostaCaminho = scanner.nextLine();
                        diretorios = respostaCaminho;
                        MFile folder = new MFile();
                        folder.setPath(respostaCaminho);
                        folder.setType(MFileAnnotationTypeEnum.SIMPLE);
                        handler.createADirectory(folder);
                    }
                    case 3 -> {
                        System.out.println("Agora escolha o caminho do arquivo");
                        scanner.nextLine();
                        String respostaCaminho = scanner.nextLine();
                        diretorios = respostaCaminho;
                        MFile folder = new MFile();
                        folder.setPath(respostaCaminho);
                        folder.setType(MFileAnnotationTypeEnum.IMPORTANT);
                        handler.createADirectory(folder);
                    }
                    case 4 -> {
                        System.out.println("Agora escolha o caminho do arquivo");
                        scanner.nextLine();
                        String respostaCaminho = scanner.nextLine();
                        diretorios = respostaCaminho;
                        MFile folder = new MFile();
                        folder.setPath(respostaCaminho);
                        folder.setType(MFileAnnotationTypeEnum.IMAGE);
                        handler.createADirectory(folder);
                    }
                }

            }
            case 2 -> {
                FolderOrchestrator orquestrador = new FileOrchestrator();
                System.out.println("Qual diretório deseja apagar?, escreva o path: ");
                scanner.nextLine();
                String caminhoApagar = scanner.nextLine();
                orquestrador.removeFolder(caminhoApagar);

            }
            case 3 ->{
                FolderOrchestrator orquestrador = new FileOrchestrator();
                System.out.println("Listando todos os diretórios... Descreva o caminho:");
                scanner.nextLine();
                String respostaCaminho = scanner.nextLine();
                orquestrador.listAllFoldersCreated(respostaCaminho);
            }
            case 4 -> {
                System.out.println("Próximo menu....");
                return diretorios;
            }
            default -> {
                System.out.println("Opção inválida");
                return diretorios;
            }
        }
        return diretorios;
    }

}
