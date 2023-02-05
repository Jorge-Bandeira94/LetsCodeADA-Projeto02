package utils;


import models.FileOrchestrator;
import models.HandlerFile;
import models.MFile;
import models.MFileAnnotationTypeEnum;

import java.io.IOException;
import java.util.Scanner;

public class ArchiveReader {
    Scanner scanner = new Scanner(System.in);
    FileOrchestrator orquestrador = new FileOrchestrator();

    public void lerArquivo(String diretorio) throws IOException {
        System.out.println("Para ler um arquivo de texto você precisa escolher sei diretório \n 1 - Reminders \n 2 - Simples \n 3 - Importants \n 4 - Sair");
        int escolha = scanner.nextInt();
        try{
            switch(escolha){
                case 1 ->{
                    System.out.println("Você está na pasta de REMINDERS, qual arquivo deseja abrir? DIGITE O NOME SEM A EXTENSÃO: ");
                    scanner.nextLine();
                    String nomeArquivo = scanner.nextLine();
                    String diretorioCompleto = diretorio + "\\" + "reminders" + "\\" + nomeArquivo + ".txt";
                    orquestrador.recoveryFile((diretorioCompleto));
                }
                case 2 -> {
                    System.out.println("Você está na pasta de Simples, esta é a pasta raiz pois Simples não possui diretório \n qual arquivo deseja abrir? DIGITE O NOME SEM A EXTENSÃO: ");
                    scanner.nextLine();
                    String nomeArquivo = scanner.nextLine();
                    String diretorioCompleto = diretorio + "\\" + nomeArquivo + ".txt";
                    orquestrador.recoveryFile((diretorioCompleto));
                }
                case 3 -> {
                    System.out.println("Você está na pasta de IMPORTANTS, qual arquivo deseja abrir? DIGITE O NOME SEM A EXTENSÃO: ");
                    scanner.nextLine();
                    String nomeArquivo = scanner.nextLine();
                    String diretorioCompleto = diretorio + "\\" + "importants" + "\\" + nomeArquivo + ".txt";
                    orquestrador.recoveryFile((diretorioCompleto));
                }
                case 4 -> {
                    break;
                }
                default -> {
                    System.out.println("Opção inválida");
                }
            }
        } catch(Exception e){
            System.out.println("Erro, não foi possível ler o arquivo");
        }
    }
}
