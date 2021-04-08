package ru.croc.homework6.film;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Фильм.
 */
@XmlRootElement
public class Film {

    /** Название фильма. */
    @XmlElement
    private String title;

    /** Описание фильма. */
    @XmlElement
    private String description;

    @XmlElementWrapper(name = "screenwriters")
    @XmlElement (name = "screenwriter")
    private List<Screenwriter> screenwriters;

    @XmlElementWrapper(name = "directors")
    @XmlElement (name = "director")
    private List<Director> directors;

    public Film(String title, String description) {
        this.title = title;
        this.description = description;
        this.screenwriters = new ArrayList<>();
        this.directors = new ArrayList<>();
    }

    public Film(){}

    /**
     * Добавление сценариста.
     * @param screenwriter сценарист
     */
    public void addScreenwriter(Screenwriter screenwriter) {
        this.screenwriters.add(screenwriter);
    }

    /**
     * Удадение сценариста.
     * @param screenwriter сценарист
     */
    public void removeScreenwriter(Screenwriter screenwriter) {
        this.screenwriters.remove(screenwriter);
    }

    /**
     * Добавление режиссера.
     * @param director сценарист
     */
    public void addDirector(Director director) {
        this.directors.add(director);
    }

    /**
     * Удаление режиссера.
     * @param director сценарист
     */
    public void removeDirector(Director director) {
        this.directors.remove(director);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Screenwriter> getScreenwriters() {
        return screenwriters;
    }

    public void setScreenwriters(List<Screenwriter> screenwriters) {
        this.screenwriters = screenwriters;
    }

    public List<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Director> directors) {
        this.directors = directors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return Objects.equals(title, film.title) &&
                Objects.equals(description, film.description) &&
                Objects.equals(screenwriters, film.screenwriters) &&
                Objects.equals(directors, film.directors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, screenwriters, directors);
    }

    @Override
    public String toString() {
        return "Film{" +
                "name='" + title + '\'' +
                ", description='" + description + '\'' +
                ", screenwriters=" + screenwriters +
                ", directors=" + directors +
                '}';
    }
}
