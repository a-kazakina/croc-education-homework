package ru.croc.homework6.film;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.croc.homework6.jaxb.JaxbConverter;

import java.io.IOException;

/**
 * Проверка сериализации и десериализации класса {@link: GroupFilms}
 */
public class GroupFilmsTest {

    @Test
    @DisplayName("Тест сериализации и десериализации класса")
    public void test() throws IOException {
        final GroupFilms groupFilms1 = new GroupFilms();

        Screenwriter screenwriter1 = new Screenwriter("Человек 1");
        Screenwriter screenwriter2 = new Screenwriter("Человек 2");
        Screenwriter screenwriter4 = new Screenwriter("Человек 4");

        Director director1 = new Director("Человек 1");
        Director director2 = new Director("Человек 2");
        Director director3 = new Director("Человек 3");

        Film film1 = new Film("Фильм1", "Описание1");
        Film film2 = new Film("Фильм2", "Описание2");

        film1.addScreenwriter(screenwriter1);
        film1.addScreenwriter(screenwriter2);
        film1.addDirector(director2);
        film1.addDirector(director3);

        film2.addScreenwriter(screenwriter2);
        film2.addScreenwriter(screenwriter4);
        film2.addDirector(director1);

        groupFilms1.addFilm(film1);
        groupFilms1.addFilm(film2);

        final JaxbConverter converter = new JaxbConverter();
        String xmlFilms = converter.toXml(groupFilms1);

        Assertions.assertEquals(groupFilms1, converter.fromXml(xmlFilms, GroupFilms.class));
    }
}
