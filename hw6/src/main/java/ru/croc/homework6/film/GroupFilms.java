package ru.croc.homework6.film;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Список фильмов.
 */
@XmlRootElement (name="group_films")
public class GroupFilms {

    /** Список фильмов. */
    @XmlElementWrapper(name = "films")
    @XmlElement (name = "film")
    private List<Film> films = new ArrayList<>();

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    /**
     * Добавление фильма.
     * @param film фильм
     */
    public void addFilm(Film film) {
        films.add(film);
    }

    /**
     * Удаление фильма.
     * @param film фильм
     */
    public void removeFilm(Film film) {
        films.remove(film);
    }

    @Override
    public String toString() {
        return "GroupFilms{" +
                "films=" + films +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupFilms that = (GroupFilms) o;
        return Objects.equals(films, that.films);
    }

    @Override
    public int hashCode() {
        return Objects.hash(films);
    }
}
