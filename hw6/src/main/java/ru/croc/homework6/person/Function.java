package ru.croc.homework6.person;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * Роль человека в фильме.
 */
public class Function {

    /** Название. */
    @XmlAttribute
    private String name;

    public Function(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Function{" +
                "name='" + name + '\'' +
                '}';
    }
}
