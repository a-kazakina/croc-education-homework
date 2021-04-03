package ru.croc.homework5;

import ru.croc.homework5.menu.Menu;
import ru.croc.homework5.task.TaskBoard;

import java.io.*;
import java.util.Scanner;

/**
 * Приложение.
 */
public class Application {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        File file = new File("file.txt");
        FileInputStream fileInputStream;
        ObjectInputStream objectInputStream;
        TaskBoard taskBoard = new TaskBoard();
        try {
            if (file.length() == 0) {
                file.createNewFile();
            }
            else {
                fileInputStream = new FileInputStream(file);
                objectInputStream = new ObjectInputStream(fileInputStream);
                taskBoard = (TaskBoard) objectInputStream.readObject();
            }
        } catch(ClassNotFoundException | IOException e) {
            e.printStackTrace();
            return;
        }

        System.out.println("Введите 0 для запуска");
        int start = sc.nextInt();
        while (start == 0) {
            System.out.println("1 - Добавить задачу\n" +
                    "2 - Редактировать задачу\n" +
                    "3 - Просмотреть задачу\n" +
                    "4 - Удалить задачу\n" +
                    "5 - посмотреть все задачи" );
            int choice = sc.nextInt();
            switch(choice) {
                case 1:
                    Menu.addTask(taskBoard);
                    break;
                case 2:
                    Menu.change(taskBoard);
                    break;
                case 3:
                    Menu.search(taskBoard);
                    break;
                case 4:
                    Menu.deleteTask(taskBoard);
                    break;
                case 5:
                    Menu.allTask(taskBoard);
                    break;
                default:
                    System.out.println("Введите номер от 1 до 5");
            }

            System.out.println("Нажмите 0 чтобы продолжить");
            start = sc.nextInt();
        }
        FileOutputStream fileOutput = new FileOutputStream("file.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutput);
        objectOutputStream.writeObject(taskBoard);
        objectOutputStream.close();
    }
}
