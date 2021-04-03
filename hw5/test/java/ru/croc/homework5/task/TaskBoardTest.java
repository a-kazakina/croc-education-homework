package ru.croc.homework5.task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.croc.homework5.employee.Gender;
import ru.croc.homework5.employee.Performer;

/**
 * Проверка {@link TaskBoard}
 */
class TaskBoardTest {

    private TaskBoard taskBoard = new TaskBoard();;
    private Performer performer = new Performer("John", 20, Gender.MALE);;

    @Test
    @DisplayName("Тест добавления/удаления/поиска задачи")
    public void test() {

        // проверяем добавление
        taskBoard.addTask(1, "Task1", "Description1", performer);
        taskBoard.addTask(2, "Task2", "Description2", performer);
        taskBoard.addTask(3, "Task3", "Description3", performer);
        Assertions.assertTrue(taskBoard.hasTask(1));
        Assertions.assertTrue(taskBoard.hasTask(2));
        Assertions.assertTrue(taskBoard.hasTask(3));
        System.out.println(taskBoard.toString());

        // поиск
        Assertions.assertEquals("Task2", taskBoard.search(2).getName());
        System.out.println(taskBoard.search(2) + "\n");

        // удаление
        taskBoard.deleteTask(2);
        Assertions.assertFalse(taskBoard.hasTask(2));
        System.out.println(taskBoard.toString());
    }

}