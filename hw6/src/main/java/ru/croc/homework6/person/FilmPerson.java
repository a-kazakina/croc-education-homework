package ru.croc.homework6.person;

import javax.xml.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Список фильмов для человека.
 */
public class FilmPerson {

    /** Списо фильмов. */
    @XmlElement
    private Map<String, GroupFunctions> films;

    public FilmPerson() {
        this.films = new HashMap<>();
    }

    public Map<String, GroupFunctions> getFilms() {
        return films;
    }

    public void setFilms(Map<String, GroupFunctions> films) {
        this.films = films;
    }

    @Override
    public String toString() {
        return "FilmPerson{" +
                "films=" + films +
                '}';
    }
}
