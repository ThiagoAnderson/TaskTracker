package Domain;

import Data.ManageFileJson;
import Entities.Task;
import Services.NewTask;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static void MenuInicialize() {
        System.out.println("-------------------------------------");
        System.out.println("Sistema de rastreamento de tarefas!!!");
        System.out.println("-------------------------------------");
        System.out.println("Escolha uma das opções abaixo:");
        System.out.println(" ");
        System.out.println("1 - Adicionar nova tarefa.");
        System.out.println("2 - Atualizar tarefa existente.");
        System.out.println("3 - Excluir uma tarefa.");
        System.out.println("4 - Listas todas as tarefas.");
        System.out.println("6 - Listas todas as tarefas concluidas.");
        System.out.println("7 - Listas todas as tarefas não concluidas.");
        System.out.println("8 - Listas todas as tarefas em progresso.");
        System.out.println("9 - Encerrar programa.");

    }

    public static void choiceMenu() {
        Scanner input = new Scanner(System.in);
        try {
            int choice = input.nextInt();
            if (choice > 9 || choice < 1) {
                System.out.println("Escolha inválida");
                MenuInicialize();
                choiceMenu();
            }
            switch (choice){
                case 1:
                    System.out.println("Qual a descrição da sua tarefa?");
                    Task task = NewTask.CreatedNewTask();
                    ManageFileJson.populateJson(task);
                case 9:
                    System.out.println("Encerrando programa.....");
                    break;

                default:MenuInicialize();
                        choiceMenu();
                        break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Apenas números são validos.");
            MenuInicialize();
            choiceMenu();
        }
    }
}
