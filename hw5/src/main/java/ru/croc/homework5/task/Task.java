package ru.croc.homework5.task;

import ru.croc.homework5.employee.Performer;

import java.io.Serializable;

/**
 * Задача.
 */
public class Task implements Serializable {

    /** Универсальный идентификатор версии. */
    private static final long serialVersionUID = 1L;

    /** Код. */
    private int id;

    /** Наименование. */
    private String name;

    /** Описание. */
    private String description;

    /** Исполнитель. */
    private Performer performer;

    /** Статус. */
    private StatusTask status;

    public Task(int id, String name, String description, Performer performer, StatusTask status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.performer = performer;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Performer getPerformer() {
        return performer;
    }

    public void setPerformer(Performer performer) {
        this.performer = performer;
    }

    public StatusTask getStatus() {
        return status;
    }

    public void setStatus(StatusTask status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Задача " + id +
                ", наименование = " + name +
                ", описание = " + description +
                ", исполнитель = " + performer.getName() +
                ", статус = " + status;
    }
}
