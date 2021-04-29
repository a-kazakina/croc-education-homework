package ru.croc.homework8.model.out;

import javax.xml.bind.annotation.XmlElement;
import java.util.Objects;

/**
 * Досуговое предприятие.
 */
public class Enterprise {

    /** Наименование. */
    @XmlElement
    private String name;

    /** Описание. */
    @XmlElement
    private String description;

    public Enterprise() {}
    public Enterprise(String name, String description) {
        this.name = name;
        this.description = description;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Enterprise that = (Enterprise) o;
        return Objects.equals(name, that.name) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description);
    }
}
