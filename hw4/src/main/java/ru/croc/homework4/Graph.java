package ru.croc.homework4;

import java.util.*;
import java.util.stream.Stream;

/**
 * Несвязный граф.
 *
 * @param <T> определяемый тип данных
 */
public class Graph<T> {

    /** Граф. */
    private Map<Vertex<T>, List<Edge<T>>> graph = new HashMap<>();

    /** Список вершин графа, принадлежащих одной компоненте связности. */
    private List<Vertex<T>> component = new ArrayList<>();

    /**
     * Процедура добавления вершины в граф.
     *
     * @param vertex вершина
     */
    public void addVertex(Vertex<T> vertex) {
        if (!hasVertex(vertex)) {
            List<Edge<T>> edges = new ArrayList<>();
            graph.put(vertex, edges);
        }
    }

    /**
     * Поиск вершины в графе.
     *
     * @param vertex
     * @return true - есть вершина в графе, false - нет
     */
    public boolean hasVertex(Vertex<T> vertex) {
        return graph.containsKey(vertex);
    }

    /**
     * Процедура добавления ребра в граф.
     *
     * @param edge ребро
     */
    public void addEdge(Edge<T> edge) {

        // не выполняем проверку на существование вершин в графе,
        // т. к. проверка выполняется в процедуре addVertex
        addVertex(edge.getFrom());
        addVertex(edge.getTo());

        List<Edge<T>> fromEdges = graph.get(edge.getFrom());
        fromEdges.add(edge);

        List<Edge<T>> toEdges = graph.get(edge.getTo());
        toEdges.add(edge);

        edge.getFrom().addNeighbours(edge.getTo());
        edge.getFrom().addNeighbours(edge.getFrom());
    }

    /**
     * Удаление вершины.
     * При удалении вершины удаляются также все ребра, связанные с ней.
     *
     * @param vertex вершина
     */
    public void removeVertex(Vertex<T> vertex) {
        graph.remove(vertex);
    }

    /**
     * Удаление ребра.
     *
     * @param edge ребро
     */
    public void removeEdge(Edge<T> edge) {

        List<Edge<T>> fromEdges = graph.get(edge.getFrom());
        fromEdges.remove(edge);
        edge.getFrom().removeNeighbours(edge.getTo());

        List<Edge<T>> toEdges = graph.get(edge.getTo());
        toEdges.remove(edge);
        edge.getTo().removeNeighbours(edge.getFrom());

    }

    /**
     * Процедура поиска в глубину.
     *
     * @param vertex вершина
     */
    public void dfs(Vertex<T> vertex) {

        List<Vertex<T>> neighbours = vertex.getNeighbours();
        vertex.setVisited(true);

        for (int i = 0; i < neighbours.size(); i++) {
            Vertex<T> n = neighbours.get(i);
            if(n != null && (n.isVisited() == false)) {
                component.add(n);
                dfs(n);
            }
        }
    }

    /**
     * Сортирует список компонент связности по количеству узлов компоненты.
     *
     * @return отсортированный список компонент связности
     */
    public Stream<Map.Entry<String, Integer>> sort() {

        int nom = 1;
        Map<String, Integer> sortSpisok = new HashMap<>();
        for (Vertex<T> vertex : graph.keySet()) {
            vertex.setVisited(false);
        }
        for (Vertex<T> vertex : graph.keySet()) {
            component.clear();
            if (vertex.isVisited() == false) {
                dfs(vertex);
                sortSpisok.put("Номер компоненты связности: " + nom, component.size()+1);
            }
            nom++;
        }
        return sortSpisok.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue());
    }

    /**
     * Функция, выводящая информацию о компонентах графа.
     * @param comp список компонент
     * @return список из элементов вида "1=1", где первое число - номер компоненты связности,
     *                  а второе - количество вершин данной компоненты
     */
    public StringBuilder informationAboutComponents(Stream<Map.Entry<String, Integer>> comp) {
        StringBuilder str = new StringBuilder();
        comp.forEach(c -> str.append(c + "\n"));
        return str;
    }

    /**
     * Функция подсчитывает количество компонент связи в графе.
     *
     * @return количество компонент связности
     */
    public int kol() {
        int kol = 0;
        for (Vertex<T> vertex : graph.keySet()) {
            vertex.setVisited(false);
        }
        for (Vertex<T> vertex : graph.keySet()) {
            if (vertex.isVisited() == false) {
                kol++;
                dfs(vertex);
            }

        }
        return kol;
    }

}

