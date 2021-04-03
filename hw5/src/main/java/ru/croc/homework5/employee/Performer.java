package ru.croc.homework5.employee;

import java.io.Serializable;

/**
 * Исполняющий.
 */
public class Performer implements Serializable {

    /** Универсальный идентификатор версии. */
    private static final long serialVersionUID = 1L;

    /** Имя. */
    private String name;

    /** Возраст. */
    private int age;

    /** Пол. */
    private final Gender sex;

    public Performer(String name, int age, Gender sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "Исполнитель " + name +
                ", возраст = " + age +
                ", пол = " + sex;
    }
}
