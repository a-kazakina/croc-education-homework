package ru.croc.homework4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Проверка {@link: Graph}
 */
public class GraphTest {

    @Test
    @DisplayName("Тест методов воздушных ТС")
    public void testGraph() {

        Graph<String> graph = new Graph<>();

        System.out.println("Создадим две изолированные вершины и добавим их в граф:");
        Vertex<String> vertex1 = new Vertex<>(10, "Вершина 10");
        Vertex<String> vertex2 = new Vertex<>(20, "Вершина 20");
        System.out.println(vertex1.informationAboutVertex());
        System.out.println(vertex2.informationAboutVertex());

        graph.addVertex(vertex1);
        graph.addVertex(vertex2);

        System.out.println("Создадим ребро, которое будет связывать вершину " + vertex1.getId() + " c новой вершиной");

        Vertex<String> vertex3 = new Vertex<>(30, "Вершина 30");
        System.out.println(vertex3.informationAboutVertex());

        Edge edge1 = new Edge(vertex1, vertex3, 10);
        graph.addEdge(edge1);

        System.out.println(graph.informationAboutComponents(graph.sort()));
        Assertions.assertEquals("Номер компоненты связности: 2=1\n" +
                "Номер компоненты связности: 1=2\n", graph.informationAboutComponents(graph.sort()).toString());

        System.out.println("Удалим вершину " + vertex1.getId() + ",  которая была связана с вершиной "
                + vertex3.getId());
        graph.removeVertex(vertex1);
        System.out.println(graph.informationAboutComponents(graph.sort()));
        Assertions.assertEquals("Номер компоненты связности: 1=1\n" +
                        "Номер компоненты связности: 2=1\n", graph.informationAboutComponents(graph.sort()).toString());

        System.out.println("Посчитаем количество компонент связности: " + graph.kol());
        Assertions.assertEquals(2, graph.kol());

    }
}
