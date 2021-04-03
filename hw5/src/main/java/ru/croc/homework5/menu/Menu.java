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

    /**
     * Добавление новой задачи на доску.
     *
     * @param taskBoard доска
     * @throws IllegalArgumentException исключение в виде сообщения пользователю о неверно введеном коде задачи
     */
    public static void addTask(TaskBoard taskBoard) throws IllegalArgumentException{
        System.out.println("Новая задача под кодом ");
        int id = sc.nextInt();

        System.out.println("Наименование: ");
        String str = sc.nextLine();
        String name = sc.nextLine();

        System.out.println("Описание: ");
        String description = sc.nextLine();

        System.out.println("Имя исполнителя: ");
        String performerName = sc.nextLine();
        System.out.println("Возраст исполнителя: ");
        int performerAge = sc.nextInt();
        System.out.println("Пол исполнителя (1 - мужчина/ 2 - женщина): ");
        int performerSex = sc.nextInt();

        Gender performerGender;
        if (performerSex == 1)
            performerGender = Gender.MALE;
        else if (performerSex == 2)
            performerGender = Gender.FEMALE;
        else
            throw new IllegalArgumentException("Недопустимое значение!");

        Performer performer = new Performer(performerName, performerAge, performerGender);
        taskBoard.addTask(id, name, description, performer);
    }

    /**
     * Поиск задачи на доске.
     *
     * @param taskBoard доска
     */
    public static void search(TaskBoard taskBoard) {
        System.out.println("Введите код искомой задачи: ");
        int id = sc.nextInt();
        System.out.println(taskBoard.search(id));
    }

    /**
     * Изменение задачи на доске.
     *
     * @param taskBoard доска.
     * @throws IllegalArgumentException исключение в виде сообщения пользователю о неверно введеном коде задачи
     */
    public static void change(TaskBoard taskBoard) throws IllegalArgumentException {
        System.out.println("Для изменения данных о задаче введите ее код: ");
        int id = sc.nextInt();
        Task task = taskBoard.search(id);

        System.out.println("Что вы хотите изменить?\n" +
                "1 - наименование\n" +
                "2 - описание\n" +
                "3 - исполнителя\n" +
                "4 - статус");
        int change = sc.nextInt();
        String str;

        switch(change) {
            case 1:
                System.out.println("Новое наименование: ");
                str = sc.nextLine();
                String name = sc.nextLine();
                task.setName(name);
                break;
            case 2:
                System.out.println("Новое описание: ");
                str = sc.nextLine();
                String description = sc.nextLine();
                task.setDescription(description);
                break;
            case 3: {
                System.out.println("Имя исполнителя: ");
                str = sc.nextLine();
                String performerName = sc.nextLine();
                System.out.println("Возраст исполнителя: ");
                int performerAge = sc.nextInt();
                System.out.println("Пол исполнителя (1 - мужчина/ 2 - женщина): ");
                int performerSex = sc.nextInt();

                Gender performerGender;
                if (performerSex == 1)
                    performerGender = Gender.MALE;
                else if (performerSex == 2)
                    performerGender = Gender.FEMALE;
                else
                    throw new IllegalArgumentException("Недопустимое значение!");

                Performer performer = new Performer(performerName, performerAge, performerGender);
                task.setPerformer(performer);
                break;
            }
            case 4:
                System.out.println("Новый статус (" +
                        "1 - Назначенная/ " +
                        "2 - В работе/ " +
                        "3 - Выполнено): ");
                int statNumber = sc.nextInt();


                StatusTask status;
                if (statNumber == 1)
                    status = StatusTask.TODO;
                else if (statNumber == 2)
                    status = StatusTask.IN_PROGRESS;
                else if (statNumber == 3)
                    status = StatusTask.DONE;
                else
                    throw new IllegalArgumentException("Недопустимое значение!");

                task.setStatus(status);
                break;
            default:
                throw new IllegalArgumentException("Недопустимое значение!");
        }
    }

    /**
     * Удаление задачи с доски.
     *
     * @param taskBoard доска
     */
    public static void deleteTask(TaskBoard taskBoard) {
        System.out.println("Введите код удаляемой задачи: ");
        int id = sc.nextInt();
        taskBoard.deleteTask(id);
    }

    public static void allTask(TaskBoard taskBoard) {
        System.out.println(taskBoard.toString());
    }
}
