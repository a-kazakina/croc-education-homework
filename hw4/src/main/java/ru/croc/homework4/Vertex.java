package ru.croc.homework4;

import java.util.ArrayList;
import java.util.List;

/**
 * Вершина.
 *
 * @param <T> определяемый тип данных
 */
public class Vertex<T> {

    /** Идентификатор. */
    private final int id;

    /** Данные. */
    private T info;

    /** Посещение вершины. */
    private boolean visited;

    /** Соседи вершины. */
    private List<Vertex<T>> neighbours;

    public Vertex(int id, T info) {
        this.id = id;
        this.info = info;
        visited = false;
        this.neighbours=new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isVisited() {
        return visited;
    }

    /**
     * Добавление соседа вершины.
     *
     * @param neighbour сосед вершины
     */
    public void addNeighbours(Vertex<T> neighbour) {
        this.neighbours.add(neighbour);
    }

    /**
     * Удаление соседа вершины.
     *
     * @param neighbour сосед вершины
     */
    public void removeNeighbours(Vertex<T> neighbour) {
        this.neighbours.remove(neighbour);
    }

    public List<Vertex<T>> getNeighbours() {
        return neighbours;
    }
    public void setNeighbour(List<Vertex<T>> neighbours) {
        this.neighbours = neighbours;
    }

    /**
     * Информация о вершине.
     *
     * @return информация в виде текста
     */
    public String informationAboutVertex () {
        return "Идентификатор: " + id + "\n Данные: " + info + "\n";
    }
}
