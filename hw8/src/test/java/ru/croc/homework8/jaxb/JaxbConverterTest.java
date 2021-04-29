package ru.croc.homework8.jaxb;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.croc.homework8.model.out.Enterprise;
import ru.croc.homework8.model.out.Enterprises;

import java.io.IOException;

/**
 * Проверка сериализации и десериализации класса {@link: LeisureEnterprise}
 */
public class JaxbConverterTest {

    @Test
    void test() throws IOException {
        JaxbConverter converter = new JaxbConverter();

        Enterprise enterprise1 = new Enterprise("Предприятие1", "Описание1");
        Enterprise enterprise2 = new Enterprise("Предприятие2", "Описание2");
        Enterprise enterprise3 = new Enterprise("Предприятие3", "Описание3");
        Enterprise enterprise4 = new Enterprise("Предприятие4", "Описание4");

        Enterprises enterprises = new Enterprises();
        enterprises.getlEnterprises().add(enterprise1);
        enterprises.getlEnterprises().add(enterprise2);
        enterprises.getmEnterprises().add(enterprise3);
        enterprises.getmEnterprises().add(enterprise4);

        String xmlEnterprises = converter.toXml(enterprises);
        System.out.println(xmlEnterprises);
        Assertions.assertTrue(enterprises.equals(converter.fromXml(xmlEnterprises, Enterprises.class)));
    }
}
