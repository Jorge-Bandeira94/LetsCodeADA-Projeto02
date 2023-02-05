package utils;

import models.FileOrchestrator;
import models.HandlerFile;
import models.MFile;
import models.MFileAnnotationTypeEnum;

import java.util.Scanner;

public class ArchiveMaker {
    Scanner scanner = new Scanner(System.in);
    HandlerFile handler = new HandlerFile();
    public void criarArquivos(String diretorios){
        System.out.println("Agora crie um arquivo\n 1 - Reminder \n 2 - Important \n 3 - Simples \n 4 - Image");
        int respostaArquivo = scanner.nextInt();
        switch(respostaArquivo){
            case 1 ->{
                System.out.println("Um arquivo Reminder é um arquivo de texto. Crie o conteúdo do seu arquivo Reminder\n");
                scanner.nextLine();
                String textoRemider = scanner.nextLine();
                System.out.println("Agora crie o nome para o arquivo");
                String nomeDoArquivo = scanner.nextLine();
                MFile file = new MFile();
                file.setNameFile(nomeDoArquivo);
                file.setContent(textoRemider);
                file.setPath(diretorios);
                file.setType(MFileAnnotationTypeEnum.REMINDER);
                handler.saveFileWithDirectory(file);
            }
            case 2 -> {
                System.out.println("Um arquivo Important é um arquivo de texto. Crie o conteúdo do seu arquivo Important\n");
                scanner.nextLine();
                String textoImportant = scanner.nextLine();
                System.out.println("Agora crie o nome para o arquivo");
                String nomeDoArquivo = scanner.nextLine();
                MFile file = new MFile();
                file.setNameFile(nomeDoArquivo);
                file.setContent(textoImportant);
                file.setPath(diretorios);
                file.setType(MFileAnnotationTypeEnum.IMPORTANT);
                handler.saveFileWithDirectory(file);
            }
            case 3 -> {
                System.out.println("Um arquivo Simple é um arquivo de texto. Crie o conteúdo do seu arquivo Simple\n");
                scanner.nextLine();
                String textoSimple = scanner.nextLine();
                System.out.println("Agora crie o nome para o arquivo");
                String nomeDoArquivo = scanner.nextLine();
                MFile file = new MFile();
                file.setNameFile(nomeDoArquivo);
                file.setContent(textoSimple);
                file.setPath(diretorios);
                file.setType(MFileAnnotationTypeEnum.SIMPLE);
                handler.saveFileWithDirectory(file);
            }
            case 4 -> {
                System.out.println("Digite o link da imagem");
                scanner.nextLine();
                String linkUrl = scanner.nextLine();
                System.out.println("Agora crie o nome do arquivo");
                String nomeDoArquivo = scanner.nextLine();
                MFile file = new MFile();
                file.setNameFile(nomeDoArquivo);
                file.setContent(linkUrl);
                file.setPath(diretorios);
                file.setType(MFileAnnotationTypeEnum.IMAGE);
                handler.saveImageFileWithDirectory(file);
            }
            default -> {
                System.out.println("Opção inválida");
            }
        }
    }

    public void deletarArquivo(String diretorios) {
        System.out.println("Deletando arquivos....");
        FileOrchestrator orquestrador = new FileOrchestrator();
        System.out.println("Agora escolha o tipo de arquivo para deletar \n 1 - Reminder \n 2 - Important \n 3 - Simples \n 4 - Image");
        int tipoDoArquivo = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Agora digite o nome do arquivo");
        String nomeArquivo = scanner.nextLine();
        scanner.nextLine();
        switch(tipoDoArquivo){
            case 1 -> {
                orquestrador.removeFile(diretorios, nomeArquivo, MFileAnnotationTypeEnum.REMINDER);
            }
            case 2 -> {
                orquestrador.removeFile(diretorios, nomeArquivo, MFileAnnotationTypeEnum.IMPORTANT);
            }
            case 3 -> {
                orquestrador.removeFile(diretorios, nomeArquivo, MFileAnnotationTypeEnum.SIMPLE);
            }
            case 4 -> {
                orquestrador.removeFile(diretorios, nomeArquivo, MFileAnnotationTypeEnum.IMAGE);
            }
            default -> {
                System.out.println("Opção inválida");
                break;
            }
        }


    }
}
