package ru.croc.homework6.person;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.*;

/**
 * Люди.
 */
@XmlRootElement(name = "group_people")
public class People {

    /** Список людей. */
    @XmlElement
    private Map<String, FilmPerson> people;

    public People() {
        this.people = new HashMap();
    }

    public Map<String, FilmPerson> getPeople() {
        return people;
    }

    public void setPeople(Map<String, FilmPerson> people) {
        this.people = people;
    }

    @Override
    public java.lang.String toString() {
        return "People{" +
                "people=" + people +
                '}';
    }
}
