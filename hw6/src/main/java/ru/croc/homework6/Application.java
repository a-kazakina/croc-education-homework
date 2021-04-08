package ru.croc.homework6;

import ru.croc.homework6.film.*;
import ru.croc.homework6.jaxb.JaxbConverter;
import ru.croc.homework6.person.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Приложение для преобразования файла films.xml.
 */
public class Application {

    // читаем файл в строку
    private static String readUsingFiles(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    public static void main(String[] args) throws IOException {

        GroupFilms films;
        People people = new People();
        JaxbConverter converter = new JaxbConverter();

        String fileName;
        String xmlFilms = " ";

        {
            fileName = "films.xml";
            try {
                xmlFilms = readUsingFiles(fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        films = converter.fromXml(xmlFilms, GroupFilms.class);

        for ( Film film : films.getFilms() ) {
            List<Screenwriter> screenwriters = film.getScreenwriters();

            for ( Screenwriter screenwriter : screenwriters ) {

                String p = screenwriter.getName();
                String fn = film.getTitle();
                GroupFunctions functions = new GroupFunctions();
                Function function = new Function();

                // если есть человек
                if (people.getPeople().containsKey(p)) {
                    FilmPerson filmPerson = people.getPeople().get(p);

                    // если есть фильм у человека, добавим функцию
                    if (filmPerson.getFilms().containsKey(fn)) {
                        function.setName("Сценарист");
                        filmPerson.getFilms().get(fn).addFunction(function);
                    }
                    // иначе созддим фильм и добавим функцию
                    else {
                        fn = film.getTitle();
                        function.setName("Сценарист");
                        functions.addFunction(function);
                        filmPerson.getFilms().put(fn, functions);
                    }
                }

                // иначе создаем нового человека
                else {
                    FilmPerson filmPersonNew = new FilmPerson();
                    fn = film.getTitle();
                    function.setName("Сценарист");
                    functions.addFunction(function);
                    filmPersonNew.getFilms().put(fn, functions);
                    p = screenwriter.getName();
                    people.getPeople().put(p, filmPersonNew);
                }
            }

            List<Director> directors = film.getDirectors();
            for ( Director director : directors ) {

                //если есть человек
                String p = director.getName();
                String fn = film.getTitle();
                GroupFunctions functions = new GroupFunctions();
                Function function = new Function();
                if (people.getPeople().containsKey(p)) {
                    FilmPerson filmPerson = people.getPeople().get(p);

                    //если есть фильм у человека, добавим функцию
                    if (filmPerson.getFilms().containsKey(fn)) {
                        function.setName("Режиссер");
                        filmPerson.getFilms().get(fn).addFunction(function);
                    }

                    // иначе созддим фильм и добавим функцию
                    else {
                        fn = film.getTitle();
                        function.setName("Режиссер");
                        functions.addFunction(function);
                        filmPerson.getFilms().put(fn, functions);
                    }
                }

                // иначе создаем нового человека
                else {
                    FilmPerson filmPersonNew = new FilmPerson();
                    fn = film.getTitle();
                    function.setName("Режиссер");
                    functions.addFunction(function);
                    filmPersonNew.getFilms().put(fn, functions);
                    p = director.getName();
                    people.getPeople().put(p, filmPersonNew);
                }
            }
        }

        String xmlPeople = converter.toXml(people);
        System.out.println(xmlPeople);
    }
}




