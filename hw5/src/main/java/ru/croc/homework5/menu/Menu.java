package ru.croc.homework5.menu;

import ru.croc.homework5.task.TaskBoard;
import ru.croc.homework5.employee.Gender;
import ru.croc.homework5.employee.Performer;
import ru.croc.homework5.task.StatusTask;
import ru.croc.homework5.task.Task;

import java.util.Scanner;

/**
 * Меню пользователя.
 */
public class Menu {

    public static Scanner sc = new Scanner(System.in);

    public static void addTask(TaskBoard taskBoard) throws IllegalArgumentException{
        System.out.println("Новая задача под кодом ");
        int id = sc.nextInt();

        System.out.println("Наименование: ");
        String name = sc.nextLine();

        System.out.println("Описание: ");
        String description = sc.nextLine();

        System.out.println("Имя исполнителя: ");
        String performerName = sc.nextLine();
        System.out.println("Возраст исполнителя: ");
        int performerAge = sc.nextInt();
        System.out.println("Пол исполнителя (м/ж): ");
        String performerSex;
        try {
            performerSex = sc.nextLine();
        }
        catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Допустимы только следующие строковые значения: 'м' и 'ж'");
        }

        Gender performerGender;
        if (performerSex == "м") {
            performerGender = Gender.MALE;
        }
        else if (performerSex == "ж") {
            performerGender = Gender.FEMALE;
        }
        else throw new IllegalArgumentException("Недопустимое значение!");

        Performer performer = new Performer(performerName, performerAge, performerGender);
        taskBoard.addTask(id, name, description, performer);
    }

    public static void search(TaskBoard taskBoard) {
        System.out.println("Введите код искомой задачи: ");
        int id = sc.nextInt();
        System.out.println(taskBoard.search(id));
    }

    public static void change(TaskBoard taskBoard) throws IllegalArgumentException {
        System.out.println("Для изменения данных о задаче введите ее код: ");
        int id = sc.nextInt();
        Task task = taskBoard.search(id);

        System.out.println("Что вы хотите изменить?\n" +
                "1 - наименование\n" +
                "2 - описание\n" +
                "3 - исполнителя\n" +
                "4 - статус\n");
        int change = sc.nextInt();

        switch (change) {
            case 1:
                System.out.println("Новое наименование: ");
                String name = sc.nextLine();
                task.setName(name);
                break;
            case 2:
                System.out.println("Новое описание: ");
                String description = sc.nextLine();
                task.setDescription(description);
                break;
            case 3: {
                System.out.println("Имя исполнителя: ");
                String performerName = sc.nextLine();
                System.out.println("Возраст исполнителя: ");
                int performerAge = sc.nextInt();
                System.out.println("Пол исполнителя (м/ж): ");
                String performerSex;
                try {
                    performerSex = sc.nextLine();
                }
                catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException("Допустимы только следующие строковые значения: 'м' и 'ж'");
                }

                Gender performerGender;
                if (performerSex == "м") {
                    performerGender = Gender.MALE;
                }
                else if (performerSex == "ж") {
                    performerGender = Gender.FEMALE;
                }
                else throw new IllegalArgumentException("Недопустимое значение!");

                Performer performer = new Performer(performerName, performerAge, performerGender);
                task.setPerformer(performer);
            }
            case 4:
                System.out.println("Новый статус:");
                System.out.println("1 - Назначенная\n2-В работе\n3-Выполнено");
                int statusNumber = sc.nextInt();
                StatusTask status;
                if (statusNumber == 1) {
                    status = StatusTask.TODO;
                }
                else if (statusNumber == 2) {
                    status = StatusTask.IN_PROGRESS;
                }
                else if (statusNumber == 3) {
                    status = StatusTask.DONE;
                }
                else throw new IllegalArgumentException("Недопустимое значение!");

                task.setStatus(status);
            default:
                throw new IllegalArgumentException("Недопустимое значение!");
        }
    }

    public static void deleteTask(TaskBoard taskBoard) {
        System.out.println("Введите код удаляемой задачи: ");
        int id = sc.nextInt();
        taskBoard.deleteTask(id);
    }
}
