package ru.croc.homework5;

import ru.croc.homework5.menu.Menu;
import ru.croc.homework5.task.TaskBoard;

import java.io.*;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        File f = new File("file.txt");
        FileInputStream fileInputStream;
        ObjectInputStream objectInputStream;
        TaskBoard taskBoard = new TaskBoard();
        try {
            if (f.length() == 0) {
                f.createNewFile();
            }
            else {
                fileInputStream = new FileInputStream("file.txt");
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
                    "4 - Удалить задачу" );
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
                default:
                    System.out.println("Введите номер от 1 до 4");
            }

            System.out.println("Нажмите 0 чтобы продолжить");
            start = sc.nextInt();
        }
        FileOutputStream fileOutput;
        fileOutput = new FileOutputStream("file.txt");
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(fileOutput);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            objectOutputStream.writeObject(taskBoard);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
