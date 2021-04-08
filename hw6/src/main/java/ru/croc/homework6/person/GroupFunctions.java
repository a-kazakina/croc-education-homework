package ru.croc.homework6.person;

import ru.croc.homework6.film.Film;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.ArrayList;
import java.util.List;

/**
 * Список ролей.
 */
public class GroupFunctions {

    /** Список ролей. */
    @XmlElementWrapper(name="functions")
    @XmlElement(name="function")
    private List<Function> functions;

    public GroupFunctions() {
        this.functions = new ArrayList<>();
    }

    public List<Function> getFunctions() {
        return functions;
    }

    public void setFunctions(List<Function> functions) {
        this.functions = functions;
    }

    /**
     * Добавление роли.
     * @param function роль
     */
    public void addFunction(Function function) {
        functions.add(function);
    }

    /**
     * Удаление роли.
     * @param function роль
     */
    public void removeFunction(Function function) {
        functions.remove(function);
    }

    @Override
    public String toString() {
        return "GroupFunctions{" +
                "functions=" + functions +
                '}';
    }
}
