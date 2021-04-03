package ru.croc.homework5.task;

import ru.croc.homework5.employee.Performer;

import java.util.HashMap;
import java.util.Map;

/**
 * Доска задач.
 */
public class TaskBoard {

    /** Универсальный идентификатор версии. */
    private static final long serialVersionUID = 1L;

    /** Список задач. */
    private Map<Integer, Task> taskBoard;

    public TaskBoard() {
        this.taskBoard = new HashMap<>();
    }

    /**
     * Функция проверяет, если ли задача с данным кодом на доске.
     *
     * @param id код задачи
     * @return true - задача есть, false - иначе
     */
    public boolean hasTask(int id) {
        return taskBoard.containsKey(id);
    }

    /**
     * Добавление новой задачи на доску.
     *
     * @param name наименование
     * @param description описание
     * @param performer исполнитель
     * @throws IllegalArgumentException исключение в виде сообщения пользователю о неверно введеном коде задачи
     */
    public void addTask(int id, String name, String description, Performer performer) throws IllegalArgumentException {
        if (id <= 0) throw new IllegalArgumentException("Некорректное значение поля 'Код'!");
        if (hasTask(id)) throw new IllegalArgumentException("Задача с таким кодом уже существует!");
        Task task = new Task (id, name, description, performer, StatusTask.TODO);
        taskBoard.put(id, task);
    }

    /**
     * Удаление задачи с доски.
     *
     * @param id код
     * @throws IllegalArgumentException исключение в виде сообщения пользователю о неверно введеном коде задачи
     */
    public void deleteTask(int id) throws IllegalArgumentException {
        if (!hasTask(id)) throw new IllegalArgumentException("Нет задачи с таким кодом!");
        taskBoard.remove(id);
    }

    /**
     * Поиск задачи на доске.
     *
     * @param id код
     * @return найденная задача
     * @throws IllegalArgumentException исключение в виде сообщения пользователю о неверно введеном коде задачи
     */
    public Task search(int id) throws IllegalArgumentException {
        if (!hasTask(id)) throw new IllegalArgumentException("Нет задачи с таким кодом!");
        return taskBoard.get(id);
    }

    public String toString () {
        StringBuilder mapAsString = new StringBuilder();
        for (Integer key : taskBoard.keySet()) {
            mapAsString.append(key + "=" + taskBoard.get(key) + "\n");
        }
        return mapAsString.toString();
    }
}
