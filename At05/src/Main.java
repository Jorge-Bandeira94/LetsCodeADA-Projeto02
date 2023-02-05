import models.*;
import utils.*;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);
    FolderMaker gerenciadorPastas = new FolderMaker();
    ArchiveMaker archive = new ArchiveMaker();
    String continuar = "s";
    String continuar2 = "s";
    String continuar3 = "s";
    String continuar4 = "s";
    String continuar5 = "s";
    String menuInicial = "s";

    System.out.println(" Escolha o diretório para trabalho: ");
    String diretorios = scanner.nextLine();

    while(menuInicial.equals("s")){
        System.out.println(" Qual ação deseja realizar? \n 1 - Gerenciar Pastas \n 2 - Gerenciar Arquivos \n 3 - Deletar arquivos \n 4 - Listar \n 5 - Ler arquivo \n 6 - Sair");
        scanner.nextInt();
        int opcaoInicial = scanner.nextInt();
        switch(opcaoInicial){
            case 1 -> {
                while(continuar.equals("s")){
                    diretorios = gerenciadorPastas.menuPastas();
                    System.out.println("Deseja continuar a gereniar pastas? (s/n)");
                    scanner.nextLine();
                    continuar = scanner.nextLine().toLowerCase();
                }
            }
            case 2 -> {
                while(continuar2.equals("s")) {
                    archive.criarArquivos(diretorios);
                    System.out.println("Deseja continuar a criar arquivos? (s/n)");
                    scanner.nextLine();
                    continuar2 = scanner.nextLine().toLowerCase();
                }
            }
            case 3 -> {
                while(continuar3.equals("s")) {
                    archive.deletarArquivo(diretorios);
                    System.out.println("Deseja continuar a deletar arquivos? (s/n)");
                    scanner.nextLine();
                    continuar3 = scanner.nextLine().toLowerCase();
                }
            }
            case 4 -> {
                while(continuar4.equals("s")){
                    FolderOrchestrator orquestrador = new FolderOrchestrator();
                    FileOrchestrator fileOrquestrador = new FileOrchestrator();
                    System.out.println("Deseja listar \n 1 - Folders na pasta raíz\n 2 - Arquivos em uma pasta específica\n");
                    int escolhaListar = scanner.nextInt();
                    switch(escolhaListar){
                        case 1 -> {
                        orquestrador.listAllFoldersCreated(diretorios);
                        }
                        case 2 -> {
                            System.out.println("Agora escolha o tipo de arquivo que deseja listar \n 1 - Reminders \n 2 - Simples \n 3 - Importants \n 4 - Images");
                            int tipoArquivo = scanner.nextInt();
                            switch(tipoArquivo){
                                case 1 -> {
                                    fileOrquestrador.listAllFiles(diretorios + "\\" + "reminders");
                                }
                                case 2 -> {
                                    fileOrquestrador.listAllFiles(diretorios + "\\" + "simples");
                                }
                                case 3 -> {
                                    fileOrquestrador.listAllFiles(diretorios + "\\" + "importants");
                                }
                                case 4 -> {
                                    fileOrquestrador.listAllFiles(diretorios + "\\" + "images");
                                }
                                default -> {
                                    System.out.println("Opção inválida");
                                }
                            }
                        }
                        default -> {
                            System.out.println("Escolha inválida");
                        }
                    }
                    System.out.println("Deseja continuar neste menu? (s/n)");
                    scanner.nextLine();
                    continuar4 = scanner.nextLine().toLowerCase();

                }

            }
            case 5 -> {
                while(continuar5.equals("s")){
                    ArchiveReader leitor = new ArchiveReader();
                    leitor.lerArquivo(diretorios);
                    System.out.println("Deseja continuar a ler arquivos? (s/n)");
                    scanner.nextLine();
                    continuar5 = scanner.nextLine().toLowerCase();


                }
            }
            case 6 -> {
                menuInicial = "N";
            }
            default -> {
                System.out.println("Opção inválida");
            }
        }
    }

    }
}
