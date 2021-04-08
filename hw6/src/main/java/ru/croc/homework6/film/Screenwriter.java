package ru.croc.homework6.film;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

/**
 * Сценарист.
 */
@XmlRootElement
public class Screenwriter {

    /** Имя сценариста. */
    @XmlAttribute
    private String name;

    public Screenwriter(String name) {
        this.name = name;
    }

    public Screenwriter(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Screenwriter{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Screenwriter that = (Screenwriter) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
